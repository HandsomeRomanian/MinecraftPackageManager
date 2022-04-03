package info.matai.models.servers.waterfall;

import java.util.List;

public class GetWaterfallVersionsReponseDto {
  public List<String> version_groups;
  public List<String> versions;
  public String project_id;
  public String project_name;
}
