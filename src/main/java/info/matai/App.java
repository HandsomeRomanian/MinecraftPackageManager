package info.matai;

import info.matai.commands.MainCommand;
import picocli.CommandLine;

public class App {

  public static void main(String[] args) {
    int exitCode = new CommandLine(new MainCommand()).execute(args);
    System.exit(exitCode);
  }
}
