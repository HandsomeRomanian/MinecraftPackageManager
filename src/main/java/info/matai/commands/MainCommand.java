package info.matai.commands;

import info.matai.commands.subcommands.InstallCommand;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "mpm", mixinStandardHelpOptions = true, subcommands = InstallCommand.class)
public class MainCommand implements Callable<Integer> {


    @Override
    public Integer call() {
        return null;
    }

}