package info.matai.models.servers.waterfall;

import java.util.List;

public class GetWaterfallVersionsReponseDto {
  private List<String> version_groups;
  private List<String> versions;
  private String project_id;
  private String project_name;

  public GetWaterfallVersionsReponseDto(
      List<String> version_groups,
      List<String> versions,
      String project_id,
      String project_name) {
    this.version_groups = version_groups;
    this.versions = versions;
    this.project_id = project_id;
    this.project_name = project_name;
  }

  public List<String> getVersionGroups() {
    return version_groups;
  }

  public void setVersionGroups(List<String> versionGroups) {
    this.version_groups = versionGroups;
  }

  public String getProjectName() {
    return project_name;
  }

  public void setProjectName(String projectName) {
    this.project_name = projectName;
  }

  public String getProjectId() {
    return project_id;
  }

  public void setProjectId(String projectId) {
    this.project_id = projectId;
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }
}
