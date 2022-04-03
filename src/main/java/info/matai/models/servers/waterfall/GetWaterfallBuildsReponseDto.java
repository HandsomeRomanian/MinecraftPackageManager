package info.matai.models.servers.waterfall;

import info.matai.models.servers.common.PaperBuildInfo;
import java.util.List;

public class GetWaterfallBuildsReponseDto {
  public String project_id;
  public String project_name;
  public String version_group;
  public List<String> versions;
  public List<PaperBuildInfo> builds;
}
