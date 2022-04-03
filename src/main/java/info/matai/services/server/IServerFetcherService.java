package info.matai.services.server;

import java.util.List;

public interface IServerFetcherService {
  List<String> getVersions();
  String getLatestBuild(String version);
  boolean downLoadVersion(String version);
  boolean downLoadVersion(String version, String build);
}
