package info.matai.models.servers.common;

public class PaperDownloadDto {

  private PaperDownloadApplicationDto application;

  public PaperDownloadDto(PaperDownloadApplicationDto application) {
    this.application = application;
  }

  public PaperDownloadApplicationDto getApplication() {
    return application;
  }

  public void setApplication(PaperDownloadApplicationDto application) {
    this.application = application;
  }
}
