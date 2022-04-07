package info.matai.models.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import info.matai.models.enums.ServerTypes;

import java.util.List;

public class ServerLock {
    @JsonProperty("mcVersion")
    private String mcVersion;

    @JsonProperty("serverType")
    private ServerTypes serverType;

    @JsonProperty("build")
    private Integer buildVersion;

    @JsonProperty("plugins")
    private List<Plugin> plugins;

    protected ServerLock() {}

    public ServerLock(String mcVersion, ServerTypes serverType, Integer buildVersion, List<Plugin> plugins) {
        this.mcVersion = mcVersion;
        this.serverType = serverType;
        this.buildVersion = buildVersion;
        this.plugins = plugins;
    }

    public String getMcVersion() {
        return mcVersion;
    }
    public void setMcVersion(String mcVersion) {
        this.mcVersion = mcVersion;
    }

    public ServerTypes getServerType() {
        return serverType;
    }
    public void setServerType(ServerTypes serverType) {
        this.serverType = serverType;
    }

    public Integer getBuildVersion() {
        return buildVersion;
    }
    public void setBuildVersion(Integer buildVersion) {
        this.buildVersion = buildVersion;
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }
    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }
}
