package info.matai;

import info.matai.commands.MainCommand;
import info.matai.models.enums.ServerTypes;
import info.matai.services.server.instances.PaperFetcherService;
import java.util.logging.Logger;
import picocli.CommandLine;

public class App {
  public static final Logger LOGGER = Logger.getLogger(App.class.getName());

  public static void main(String[] args) {
    PaperFetcherService service = new PaperFetcherService(
      ServerTypes.WATERFALL
    );

    service.getVersions();
    int exitCode = new CommandLine(new MainCommand()).execute(args);
    System.exit(exitCode);
  }
}
