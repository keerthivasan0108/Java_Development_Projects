package main;
import java.util.Scanner;

import util.CLIvalidator;

public class Main {
    public static void main(String[] args) {
        CLIvalidator cli = new CLIvalidator();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> "); // prompt
            String commandline = sc.nextLine();

            if (commandline.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            cli.check_command(commandline);
        }
        
    }
}
