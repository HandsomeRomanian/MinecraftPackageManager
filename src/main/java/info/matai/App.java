package info.matai;

import info.matai.commands.MainCommand;
import info.matai.core.MpmCore;

import picocli.CommandLine;

public class App {
  public static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.exit(new CommandLine(MainCommand.class).execute(args));
    }
}
