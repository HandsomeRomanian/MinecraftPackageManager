package info.matai;

import info.matai.commands.MainCommand;

import picocli.CommandLine;

public class App {

    public static void main(String[] args) {
        System.exit(new CommandLine(MainCommand.class).execute(args));
    }
}
