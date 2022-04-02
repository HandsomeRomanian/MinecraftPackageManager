package info.matai.services.server;

import java.io.File;
import java.util.List;

public interface IServerFetcherService {
  List<String> getVersion();
  File downLoadVersion();
}
