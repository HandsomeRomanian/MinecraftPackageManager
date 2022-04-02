package info.matai.models.configuration;

import java.util.List;

public class Server {
  private String mcVersion;
  private String serverType;
  private List<Plugin> plugins;

  public Server(String mcVersion, String serverType, List<Plugin> plugins) {
    this.mcVersion = mcVersion;
    this.serverType = serverType;
    this.plugins = plugins;
  }
}
