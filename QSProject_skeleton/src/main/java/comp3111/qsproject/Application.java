package comp3111.qsproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.HostServices;

public class Application extends javafx.application.Application {
    public static HostServices hostServices;
    @Override
    public void start(Stage stage) throws IOException {
        hostServices = getHostServices();


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("QS Information System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}