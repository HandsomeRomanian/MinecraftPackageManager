package info.matai;

import info.matai.commands.MainCommand;
import info.matai.models.configuration.Server;
import info.matai.models.configuration.ServerLock;
import info.matai.services.plugins.PluginFileReaderService;
import picocli.CommandLine;

public class App {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new MainCommand()).execute(args);
        System.exit(exitCode);
    }
}
