package info.matai.models.servers.common;

public class PaperBuildInfo {
  private String version;
  private String build;
  private String time;
  private String channel;
  private String promoted;
  private PaperDownloadDto downloads;

  public PaperBuildInfo(
      String version,
      String build,
      String time,
      String channel,
      String promoted,
      PaperDownloadDto downloads) {
    this.version = version;
    this.build = build;
    this.time = time;
    this.channel = channel;
    this.promoted = promoted;
    this.downloads = downloads;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getBuild() {
    return build;
  }

  public void setBuild(String build) {
    this.build = build;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public PaperDownloadDto getDownloads() {
    return downloads;
  }

  public void setDownloads(PaperDownloadDto downloads) {
    this.downloads = downloads;
  }

  public String getPromoted() {
    return promoted;
  }

  public void setPromoted(String promoted) {
    this.promoted = promoted;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }
}
