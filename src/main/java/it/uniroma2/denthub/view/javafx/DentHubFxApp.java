package it.uniroma2.denthub.view.javafx;

import it.uniroma2.denthub.config.StartupOptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** JavaFX interface: loads the first FXML view. */
public final class DentHubFxApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        StartupOptions options = StartupOptions.parse(getParameters().getRaw().toArray(String[]::new));
        FXMLLoader loader = new FXMLLoader(DentHubFxApp.class.getResource("home.fxml"));
        Scene scene = new Scene(loader.load());
        HomeGraphicController controller = loader.getController();
        controller.showStartupOptions(options);
        stage.setTitle("DentHub");
        stage.setScene(scene);
        stage.show();
    }
}
