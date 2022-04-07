package info.matai.models.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Plugin {
    @JsonProperty("name")
    private String name;

    @JsonProperty("mcVersion")
    private String mcVersion;

    @JsonProperty("version")
    private String version;

    @JsonProperty("dependencies")
    private Map<String, String> dependencies;

    protected Plugin() {}

    public Plugin(
            String name,
            String mcVersion,
            String version,
            Map<String, String> dependencies
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

    public Map<String, String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Map<String, String> dependencies) {
        this.dependencies = dependencies;
    }
}
