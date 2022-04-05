package info.matai.models.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Server {
    @JsonProperty("version")
    private String version;

    @JsonProperty("mcVersion")
    private String mcVersion;

    @JsonProperty("serverType")
    private String serverType;

    @JsonProperty("plugins")
    private Map<String, String> plugins;

    protected Server() {}

    public Server(String mcVersion, String serverType, Map<String, String> plugins) {
        this.mcVersion = mcVersion;
        this.serverType = serverType;
        this.plugins = plugins;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getMcVersion() {
        return mcVersion;
    }
    public void setMcVersion(String mcVersion) {
        this.mcVersion = mcVersion;
    }

    public String getServerType() {
        return serverType;
    }
    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public Map<String, String> getPlugins() {
        return plugins;
    }
    public void setPlugins(Map<String, String> plugins) {
        this.plugins = plugins;
    }
}
