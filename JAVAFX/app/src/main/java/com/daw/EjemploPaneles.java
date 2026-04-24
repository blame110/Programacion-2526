package com.daw;

import com.daw.panels.PeliculaPanel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploPaneles extends Application {

    @Override
    public void start(Stage stage) {

        PeliculaPanel pPelicula = new PeliculaPanel();
        // Creamos una escena que contiene al gridpane
        Scene scene = new Scene(pPelicula, 800, 600);
        // Asignamos la escena al stage
        stage.setScene(scene);
        stage.setTitle("Ejemplo Paneles");
        // Mostramos la app
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
