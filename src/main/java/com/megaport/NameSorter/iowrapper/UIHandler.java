package com.megaport.NameSorter.iowrapper;

import java.io.Console;

public class UIHandler {
    // Create a Console for CLI input
    // console used for extensibility e.g. queuing multiple files, parsing input flags
    private Console console;

    private String input, output;

    public String getUserInput() {
        return this.input;
    }

    public String getCLIOutput() {
        return this.output;
    }

    // initialize
    public UIHandler() {
        this.console = System.console();
        this.input = "";
        this.output = "";
    }

    // primary functionality
    public void ReadInput() {
        this.input = this.console.readLine();
    }

    public void WriteOutput(String output) {
        this.console.writer().println(output);
        FlushOutput();
    }

    public void WriteOutput() {
        this.console.writer().println(this.output);
        FlushOutput();
    }

    private void FlushOutput() {
        this.output = "";
    }
}
