package info.matai.commands.subcommands;

import java.util.concurrent.Callable;

import info.matai.core.MpmCore;
import picocli.CommandLine.Command;

@Command(name = "install", aliases = { "i" }, mixinStandardHelpOptions = true, exitCodeOnExecutionException = 34)
public class InstallCommand extends AbstractSubCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println(MpmCore.getInstance().test());
        return 33;
    }
}
