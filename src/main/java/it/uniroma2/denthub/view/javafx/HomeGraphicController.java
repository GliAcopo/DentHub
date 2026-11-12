package it.uniroma2.denthub.view.javafx;

import it.uniroma2.denthub.config.StartupOptions;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** Graphic controller of home.fxml. */
public final class HomeGraphicController {

    @FXML
    private Label statusLabel;

    void showStartupOptions(StartupOptions options) {
        statusLabel.setText("Persistence: " + options.persistence().token() + " mode");
    }
}
