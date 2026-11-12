package it.uniroma2.denthub;

import it.uniroma2.denthub.config.StartupOptions;
import it.uniroma2.denthub.config.UiType;
import it.uniroma2.denthub.view.cli.CliApplication;
import it.uniroma2.denthub.view.javafx.DentHubFxApp;
import javafx.application.Application;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Entry point. The interface and the persistence mode are chosen at startup,
 * e.g. {@code gui demo}, {@code cli file}, {@code gui db} (default: {@code gui demo}).
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) throws IOException {
        StartupOptions options = StartupOptions.parse(args);
        if (options.ui() == UiType.CLI) {
            // Standard output opened through its file descriptor, so the CLI gets a plain stream.
            try (OutputStream stdout = new FileOutputStream(FileDescriptor.out)) {
                new CliApplication(options, System.in, stdout).run();
            }
        } else {
            Application.launch(DentHubFxApp.class, args);
        }
    }
}
