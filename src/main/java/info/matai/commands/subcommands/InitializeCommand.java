package info.matai.commands.subcommands;

import java.io.*;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;

@Command(name = "initialize", aliases = { "init" }, mixinStandardHelpOptions = true, exitCodeOnExecutionException = 34)
public class InitializeCommand extends AbstractSubCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        try {
            InputStreamReader unbuffered = new InputStreamReader(System.in);
            for (int i = 0; i < 10; ++i) {
                int x = unbuffered.read();
                System.out.println(String.format("%08x", x));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return 33;
    }
}
