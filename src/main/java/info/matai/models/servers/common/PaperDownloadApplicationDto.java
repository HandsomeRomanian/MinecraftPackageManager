package info.matai.models.servers.common;

public class PaperDownloadApplicationDto {
    private String name;
    private String sha256;

    public PaperDownloadApplicationDto(
            String name,
            String sha256) {
        this.name = name;
        this.sha256 = sha256;
    }

    public String getSha256() {
        return sha256;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }
}
