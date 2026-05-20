package com.daw;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        // Label para el nombre (Etiqueta de texto)
        Label lblNombre = new Label("Nombre:");
        Label lblMensaje = new Label("");
        Label lblBanner = new Label("App Mutante");
        Label lblSlider = new Label("50");
        lblBanner.setScaleX(4);
        lblBanner.setScaleY(4);
        // input de texto para guardar el valor
        TextField txtNombre = new TextField();
        txtNombre.setMaxWidth(200);
        // Boton para pulsar
        Button btnNombre = new Button("GO!!!");
        // Creamos un Slider
        Slider sldPuntuacion = new Slider(0, 100, 50);

        // Panel para añadir los elementos
        VBox vPanel = new VBox();
        // Espacio entre los elementos de VBox
        vPanel.setSpacing(20);
        // Espaciado interior de cada elemento
        // siendo el orden de las cuatro coordenadas
        // top right bottom left
        vPanel.setPadding(new Insets(10, 0, 10, 200));

        /***** EVENTOS *********/
        btnNombre.setOnAction(e -> {
            lblMensaje.setText("Bienvenido a tu primera App, " + txtNombre.getText());
            // Solo añadimos el label si no está ya en el panel para evitar duplicados
            if (!vPanel.getChildren().contains(lblMensaje)) {
                vPanel.getChildren().add(lblMensaje);
            }
        });
        // Escuchamos cambios en el slider mediante la propiedad value,
        // que captura tanto arrastre del ratón como cambios por teclado
        sldPuntuacion.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblSlider.setText("Valor: " + newVal.intValue());
        });

        vPanel.getChildren().addAll(lblNombre, txtNombre, btnNombre);

        // Creamos un borderpane, que esta dividido en 5 zonas
        // central, superior inferior derecha e izquierda
        BorderPane panelPrincipal = new BorderPane();
        panelPrincipal.setCenter(vPanel);
        panelPrincipal.setTop(lblBanner);
        panelPrincipal.setBottom(sldPuntuacion);
        panelPrincipal.setRight(lblSlider);
        // Para alinear elementos dentro de una posicion de un panel
        // podemos utilizar setAlignment, elegir el nodo
        // y con pos. seleccionar la alineacion
        panelPrincipal.setAlignment(lblBanner, Pos.CENTER);
        panelPrincipal.setPadding(new Insets(20));

        // Añadimos el VBOX a la escena
        var scene = new Scene(panelPrincipal, 640, 480);

        stage.setTitle("Aplicación Mutante");
        stage.setHeight(500);
        stage.setWidth(900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}