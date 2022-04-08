package info.matai.services.server;

import info.matai.App;
import info.matai.models.configuration.Server;
import info.matai.services.server.instances.PaperFetcherService;

public class ServerVersioningService {
  public static Server plugins;
  public static Server pluginsLock;

  public ServerVersioningService() {
    this.initData();
    IServerFetcherService fetcher = getFetcherService();
    if (plugins != null) {
      initWithPluginJson(fetcher);
    } else if (pluginsLock != null) {
      this.initWithPluginLockJson(fetcher);
      // todo create plugins.yml file
    } else {
      // init
    }
  }

  private IServerFetcherService getFetcherService() {
    switch (ServerVersioningService.plugins.getServerType()) {
      case PAPERMC:
      case WATERFALL:
      case VELOCITY:
        return new PaperFetcherService(plugins.getServerType());
      case SPIGOT:
        // TODO add other fetchers
        // return new SpigotFetcherService();

      default:
        return new PaperFetcherService(plugins.getServerType());
    }
  }

  private void initWithPluginJson(IServerFetcherService fetcher) {
    if (StringUtils.hasText(ServerVersioningService.plugins.getMcVersion()) &&
        StringUtils.hasText(ServerVersioningService.plugins.getServerBuild())) {
      // Check if same as lock if not update
      if (pluginsLock != null) {
        // Check if plugin has same value as plugin-lock
        if (!ServerVersioningService.plugins.getMcVersion()
            .equals(ServerVersioningService.pluginsLock.getMcVersion()) ||
            !ServerVersioningService.plugins.getServerBuild()
                .equals(ServerVersioningService.pluginsLock.getServerBuild())) {
          App.LOGGER.info(
              String.format(
                  "Downloading server version  %s-%s",
                  ServerVersioningService.plugins.getMcVersion(),
                  ServerVersioningService.plugins.getServerBuild()));
          fetcher.downLoadVersion(
              ServerVersioningService.plugins.getMcVersion(),
              ServerVersioningService.plugins.getServerBuild());
          this.updateLock();
        }
      } else {
        this.updateToLatestBuild(fetcher);
      }
    } else if (StringUtils.hasText(ServerVersioningService.plugins.getMcVersion()) &&
        !StringUtils.hasText(ServerVersioningService.plugins.getServerBuild())) {
      this.updateToLatestBuild(fetcher);
    }
  }

  private void initWithPluginLockJson(IServerFetcherService fetcher) {
    App.LOGGER.info(
        "Plugin file does not exist, using installed files data to init plugins.yml");
    ServerVersioningService.plugins.setMcVersion(
        ServerVersioningService.pluginsLock.getMcVersion());
    ServerVersioningService.plugins.setServerBuild(
        ServerVersioningService.pluginsLock.getServerBuild());
  }

  private void updateToLatestBuild(IServerFetcherService fetcher) {
    App.LOGGER.info("Checking if server is on latest build");

    String build = fetcher.getLatestBuild(
        ServerVersioningService.plugins.getMcVersion());
    if (!build.equals(ServerVersioningService.plugins.getServerBuild())) {
      boolean success = fetcher.downLoadVersion(
          ServerVersioningService.plugins.getMcVersion(),
          build);
      if (success) {
        App.LOGGER.info(
            String.format("Updated server version to build %s", build));
        ServerVersioningService.plugins.setServerBuild(build);
      }
    } else {
      App.LOGGER.info("Server is on latest build");
    }
  }

  private void updateLock() {
    ServerVersioningService.pluginsLock.setMcVersion(
        ServerVersioningService.plugins.getMcVersion());
    ServerVersioningService.pluginsLock.setServerBuild(
        ServerVersioningService.plugins.getServerBuild());
  }

  // NOTE will be removed once core is implemented
  public void initData() {
    Server serverinfo = new Server("1.18", "Waterfall", null);
    ServerVersioningService.plugins = serverinfo;
  }
}
