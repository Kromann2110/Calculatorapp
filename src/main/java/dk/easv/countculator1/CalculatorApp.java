package dk.easv.countculator1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 550);  // Changed from 320, 240
        stage.setTitle("Calculator!");
        stage.setScene(scene);
        stage.setMinWidth(400);   // Add this
        stage.setMinHeight(550);  // Add this
        stage.show();
    }
}
