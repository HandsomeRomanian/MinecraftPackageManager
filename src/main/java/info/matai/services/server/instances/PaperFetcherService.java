package info.matai.services.server.instances;

import com.google.gson.Gson;
import info.matai.App;
import info.matai.models.enums.ServerType;
import info.matai.models.servers.waterfall.GetWaterfallBuildsReponseDto;
import info.matai.models.servers.waterfall.GetWaterfallVersionsReponseDto;
import info.matai.services.common.utils.FileUtils;
import info.matai.services.common.utils.HttpUtils;
import info.matai.services.server.IServerFetcherService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PaperFetcherService implements IServerFetcherService {
  private final String API_URL;

  CloseableHttpClient httpClient = HttpClients.createDefault();

  public PaperFetcherService(ServerType type) {
    if (
      !(
        type == ServerType.PAPERMC ||
        type == ServerType.WATERFALL ||
        type == ServerType.VELOCITY
      )
    ) {
      throw new IllegalArgumentException("Invalid server type");
    }
    switch (type) {
      case PAPERMC:
        API_URL = "https://papermc.io/api/v2/projects/paper";
        break;
      case WATERFALL:
        API_URL = "https://papermc.io/api/v2/projects/waterfall";
        break;
      case VELOCITY:
        API_URL = "https://papermc.io/api/v2/projects/velocity";
        break;
      default:
        throw new IllegalArgumentException("Invalid server type");
    }
  }

  @Override
  public List<String> getVersions() {
    try {
      String data = HttpUtils.get(API_URL);
      GetWaterfallVersionsReponseDto dto = new Gson()
      .fromJson(data, GetWaterfallVersionsReponseDto.class);
      return dto.versions;
    } catch (IOException e) {
      App.LOGGER.log(
        Level.SEVERE,
        String.format("Failed to fetch server versions.%n %s", API_URL)
      );
    }
    return new ArrayList<>();
  }

  @Override
  public String getLatestBuild(String version) {
    try {
      String data = HttpUtils.get(API_URL + "/version_group/" + version);
      GetWaterfallBuildsReponseDto builds = new Gson()
      .fromJson(data, GetWaterfallBuildsReponseDto.class);
      return builds.getBuilds().get(builds.getBuilds().size() - 1).getBuild();
    } catch (IOException e) {
      App.LOGGER.log(
        Level.SEVERE,
        String.format(
          "And error occured while trying to fetch server builds.%n %s",
          API_URL
        )
      );
    }
    return null;
  }

  @Override
  public boolean downLoadVersion(String version) {
    String build = getLatestBuild(version);
    if (build != null) {
      return downloadJar(version, build);
    }

    return false;
  }

  @Override
  public boolean downLoadVersion(String version, String build) {
    if (build != null) {
      return downloadJar(version, build);
    }

    return false;
  }

  private boolean downloadJar(String version, String build) {
    try {
      String url =
        API_URL +
        "/versions/" +
        version +
        "/builds/" +
        build +
        "/downloads/paper-" +
        version +
        "-" +
        build +
        ".jar";
      return FileUtils.downloadFile(url, "./server.jar");
    } catch (Exception e) {
      App.LOGGER.log(
        Level.SEVERE,
        String.format(
          "And error occured while trying to download server version.%n %s",
          API_URL
        )
      );
    }
    return false;
  }
}
