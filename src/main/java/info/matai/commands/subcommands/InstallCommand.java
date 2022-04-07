package info.matai.commands.subcommands;


import java.util.concurrent.Callable;
import picocli.CommandLine.Command;

@Command(name = "install", mixinStandardHelpOptions = true,
        exitCodeOnExecutionException = 34)
public class InstallCommand extends AbstractSubCommand implements Callable<Integer>{

    @Override
    public Integer call() {
        System.out.println(core.test());
        return 33;
    }
}


