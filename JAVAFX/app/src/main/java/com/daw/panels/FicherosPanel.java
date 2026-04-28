package com.daw.panels;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class FicherosPanel extends GridPane {

    private Button btnSeleccionarFichero;
    private Label lblFichero;

    public FicherosPanel() {
        // Creamos los objetos iniciales del grid
        lblFichero = new Label("...");
        btnSeleccionarFichero = new Button("Seleccionar Fichero..");

        // Organizamos los espacios
        this.setHgap(10); // separacion horizontal entre columnas
        this.setVgap(8); // separacion vertical entre filas
        this.setPadding(new Insets(20));

        // Posicionamos en el gridpane los elementos
        this.add(lblFichero, 0, 0);
        this.add(btnSeleccionarFichero, 1, 0);

        // EVENTOS
        btnSeleccionarFichero.setOnAction(e -> {
            abrirFichero();
        });

    }

    /**
     * Funcion que abre un dialogo para seleccionar un fichero
     */
    private void abrirFichero() {

        FileChooser fileChooser = new FileChooser();
        TextArea txtFichero = new TextArea();
        ImageView imagen;
        fileChooser.setTitle("Seleccionar fichero de texto o de imagen");

        // Filtros de extension
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Ficheros de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Imagen Jpg", "*.jpg"));

        // Abrimos el dialogo de seleccion de ficheros, sin ventana padre
        // Lo suyo seria pasar el stage padre para que se bloqueara
        // Nos devuelve directamente un file abierto que es el seleccionado
        File fichero = fileChooser.showOpenDialog(null);

        if (fichero != null) { // null si el usuario cancelo
            String nombreFichero = fichero.getName();
            // Sacamos la extension y si es txt añadimos un textArea con el contenido del
            // fichero
            if (nombreFichero.substring(nombreFichero.length() - 3, nombreFichero.length()).equalsIgnoreCase("txt")) {
                try {
                    String contenido = Files.readString(fichero.toPath());
                    txtFichero.setText(contenido);
                } catch (IOException ex) {
                    txtFichero.setText("Error al leer: " + ex.getMessage());
                }
                // Ponemos en nuestro gridpanel el textarea con el contenido del texto
                this.add(txtFichero, 0, 1, 4, 4);
            } else {
                // Desde el fichero que nos devuelve filechoser
                // cogemos la ruta con toURI y la pasamos como string para crear la imagen
                Image img = new Image(fichero.toURI().toString());
                // La imagen la insertamos en el objeto javafx que muestra imagenes
                ImageView imageView = new ImageView(img);
                // La añadiimos al panel
                this.add(imageView, 0, 1, 4, 4);

            }
        }

    }

}
