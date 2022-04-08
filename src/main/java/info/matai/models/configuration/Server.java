package info.matai.models.configuration;

import info.matai.models.enums.ServerType;
import java.util.List;

public class Server {
  private String mcVersion;
  private ServerType serverType;
  private String serverBuild;
  private List<Plugin> plugins;

  public Server(String mcVersion, ServerType serverType, List<Plugin> plugins) {
    this.plugins = plugins;
    this.serverType = serverType;
    this.mcVersion = mcVersion;
  }

  public List<Plugin> getPlugins() {
    return plugins;
  }

  public void setPlugins(List<Plugin> plugins) {
    this.plugins = plugins;
  }

  public String getServerBuild() {
    return serverBuild;
  }

  public void setServerBuild(String serverBuild) {
    this.serverBuild = serverBuild;
  }

  public ServerType getServerType() {
    return serverType;
  }

  public void setServerType(ServerType serverType) {
    this.serverType = serverType;
  }

  public String getMcVersion() {
    return mcVersion;
  }

  public void setMcVersion(String mcVersion) {
    this.mcVersion = mcVersion;
  }
}
