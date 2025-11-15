package org.example.proyectofinalp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("MenuPrincipal.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("🎵 Academia Musical - Sistema de Gestión");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(1000);
        stage.setMinHeight(700);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}