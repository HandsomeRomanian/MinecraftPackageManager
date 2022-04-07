package info.matai;

import info.matai.commands.MainCommand;
import picocli.CommandLine;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        int exitCode = new CommandLine(new MainCommand()).execute(input);
        scanner.close();
        System.exit(exitCode);
    }
}
