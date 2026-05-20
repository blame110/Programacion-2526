package com.daw.panels;

import com.daw.model.PeliculasDAO;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

// Panel del formulario para crear películas.
// Contiene los campos: título, clasificación, duración y sinopsis,
// más los botones Guardar y Limpiar
public class PeliculaPanel extends GridPane {

    private Label lblTitulo;
    private Label lblClasificacion;
    private Label lblDuracion;
    private Label lblSinopsis;

    private TextField txtTitulo;
    private ComboBox<String> cmbClasificacion;
    private Slider sldDuracion;
    private TextArea txtSinopsis;
    private Button btnReset;
    private Button btnGuardar;

    public PeliculaPanel() {

        // Creamos todos los controles del formulario
        lblTitulo = new Label("Título");
        lblClasificacion = new Label("Clasificación");
        lblDuracion = new Label("Duración");
        lblSinopsis = new Label("Sinopsis");
        txtTitulo = new TextField();
        txtTitulo.setPromptText("Escribe un Título..");
        cmbClasificacion = new ComboBox<>();
        sldDuracion = new Slider(30, 600, 120);
        txtSinopsis = new TextArea();
        txtSinopsis.setPromptText("Escribe una descripción");
        btnReset = new Button("Limpiar");
        btnGuardar = new Button("Guardar");

        // Configuramos el espaciado del grid
        this.setHgap(10);
        this.setVgap(8);
        this.setPadding(new Insets(20));

        // Cargamos las opciones del ComboBox de clasificación
        // y seleccionamos la primera por defecto
        cmbClasificacion.getItems().addAll("Todos los Públicos", "+3", "+6", "+9", "+12", "+14", "+18",
                "Jubilados Only");
        cmbClasificacion.getSelectionModel().selectFirst();

        txtSinopsis.setPrefWidth(500);
        txtSinopsis.setPrefHeight(300);

        // Colocamos cada campo en su posición del grid
        // Los parámetros son: nodo, columna, fila, [columnSpan, rowSpan]
        this.add(lblTitulo, 0, 0);
        this.add(txtTitulo, 1, 0);
        this.add(lblClasificacion, 0, 1);
        this.add(cmbClasificacion, 1, 1);
        this.add(lblDuracion, 0, 2);
        this.add(sldDuracion, 1, 2);
        this.add(lblSinopsis, 0, 3);
        this.add(txtSinopsis, 1, 3, 3, 3);
        this.add(btnGuardar, 0, 6);
        this.add(btnReset, 1, 6);

        // Evento: botón Limpiar restablece el formulario
        btnReset.setOnAction(e -> reset());

        // Evento: botón Guardar intenta insertar en BD y muestra resultado
        btnGuardar.setOnAction(e -> {
            int resultado = guardar();

            if (resultado == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error En la Operacion");
                alert.setHeaderText(null);
                alert.setContentText("El registro no se ha guardado correctamente.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operacion completada");
                alert.setHeaderText(null);
                alert.setContentText("La pelicula se ha guardado correctamente.");
                alert.showAndWait();
                reset();
            }
        });
    }

    // Resetea todos los campos del formulario a su estado inicial
    private void reset() {
        this.txtTitulo.clear();
        this.cmbClasificacion.getSelectionModel().selectFirst();
        sldDuracion.setValue(120);
        txtSinopsis.clear();
    }

    // Recoge los valores del formulario y los guarda en la BD.
    // Devuelve el número de filas insertadas (1 = éxito) o -1 si falló
    private int guardar() {
        int resultado = -1;
        try (PeliculasDAO peliculasDAO = new PeliculasDAO()) {
            // getSelectedIndex() puede devolver -1 si nada está seleccionado;
            // en ese caso usamos 0 como valor seguro
            int indice = cmbClasificacion.getSelectionModel().getSelectedIndex();
            if (indice < 0) {
                indice = 0;
            }
            resultado = peliculasDAO.crearPelicula(txtTitulo.getText(),
                    indice, (int) sldDuracion.getValue(),
                    txtSinopsis.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al guardar");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }
        return resultado;
    }

}
