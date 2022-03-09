package iowrapper;

import java.io.Console;
import java.util.Scanner;

public class InputHandler {
    // Create a Console for CLI input
    // console used for extensibility e.g. queuing multiple files 
    
    private Console console;
    private Scanner scanner;

    // initialize
    InputHandler(Console console) {
        this.console = System.console();
        this.scanner = new Scanner(System.in);
    }

    // if we can't get a console, figure it out
    public boolean ConsoleExists() {
        if (console == null) {
            return false;
        }
        return true;
    }

    // primary functionality
    public String GetInput() {
        String input = "";
        if (ConsoleExists()) {
            input = GetInputFromConsole();
        } else {
            input = GetInputFromScanner();
        }

        return input;
    }

    // ideal path
    public String GetInputFromConsole() { 
        String input = console.readLine();
        String sanitizedInput = SanitizeInput(input);
        return sanitizedInput;
    }

    // backup path
    public String GetInputFromScanner() {
        String input = scanner.nextLine();
        String sanitizedInput = SanitizeInput(input);
        return sanitizedInput;
    }


    private String SanitizeInput(String input) {
        // Todo
        return input;
    }



}
