package it.uniroma2.denthub.view.cli;

import it.uniroma2.denthub.config.StartupOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/** Command line interface: menu loop of the CLI graphic controllers. */
public final class CliApplication {

    private static final String EXIT_CHOICE = "0";

    private final StartupOptions options;
    private final BufferedReader in;
    private final PrintWriter out;

    public CliApplication(StartupOptions options, InputStream input, OutputStream output) {
        this.options = options;
        this.in = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        this.out = new PrintWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8), true);
    }

    public void run() throws IOException {
        out.println("DentHub, command line interface (" + options.persistence().token() + " mode)");
        String choice;
        do {
            out.println(EXIT_CHOICE + ") Exit");
            out.print("> ");
            out.flush();
            choice = in.readLine();
        } while (choice != null && !EXIT_CHOICE.equals(choice.trim()));
    }
}
