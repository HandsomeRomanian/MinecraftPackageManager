package info.matai.models.configuration;

import java.util.List;

public class Plugin {
  private String name;
  private String mcVersion;
  private String version;
  private List<Plugin> dependencies;

  public Plugin(
    String name,
    String mcVersion,
    String version,
    List<Plugin> dependencies
  ) {
    this.name = name;
    this.mcVersion = mcVersion;
    this.version = version;
    this.dependencies = dependencies;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMcVersion() {
    return mcVersion;
  }

  public void setMcVersion(String mcVersion) {
    this.mcVersion = mcVersion;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public List<Plugin> getDependencies() {
    return dependencies;
  }

  public void setDependencies(List<Plugin> dependencies) {
    this.dependencies = dependencies;
  }
}
