package info.matai.models.servers.waterfall;

import info.matai.models.servers.common.PaperBuildInfo;
import java.util.List;

public class GetWaterfallBuildsReponseDto {
  private String project_id;
  private String project_name;
  private String version_group;
  private List<String> versions;
  private List<PaperBuildInfo> builds;

  public GetWaterfallBuildsReponseDto(
      String project_id,
      String project_name,
      String version_group,
      List<String> versions,
      List<PaperBuildInfo> builds) {
    this.project_id = project_id;
    this.project_name = project_name;
    this.version_group = version_group;
    this.versions = versions;
    this.builds = builds;
  }

  public List<PaperBuildInfo> getBuilds() {
    return builds;
  }

  public String getProjectId() {
    return project_id;
  }

  public void setProjectId(String projectId) {
    this.project_id = projectId;
  }

  public String getProjectName() {
    return project_name;
  }

  public void setProjectName(String projectName) {
    this.project_name = projectName;
  }

  public String getVersionGroup() {
    return version_group;
  }

  public void setVersionGroup(String versionGroup) {
    this.version_group = versionGroup;
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }

  public void setBuilds(List<PaperBuildInfo> builds) {
    this.builds = builds;
  }
}
