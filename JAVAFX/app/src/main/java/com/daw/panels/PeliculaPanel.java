package com.daw.panels;

import java.sql.SQLException;

import com.daw.model.PeliculasDAO;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PeliculaPanel extends GridPane {

    // VARIABLES MIEMBRO DEL GRIDPANE
    private Label lblTitulo;
    private Label lblClasificacion;
    private Label lblDuracion;
    private Label lblSinopsis;

    public TextField txtTitulo;
    public ComboBox<String> cmbClasificacion;
    public Slider sldDuracion;
    public TextArea txtSinopsis;
    public Button btnReset;
    public Button btnGuardar;

    public PeliculaPanel() {

        // Creamos los controles
        lblTitulo = new Label("Título");
        lblClasificacion = new Label("Clasificaciín");
        lblDuracion = new Label("Duración");
        lblSinopsis = new Label("Sinopsís");
        txtTitulo = new TextField("Escribe un Título..");
        cmbClasificacion = new ComboBox<String>();
        sldDuracion = new Slider(30, 600, 120);
        txtSinopsis = new TextArea("Escribe una descripcion");
        btnReset = new Button("Limpiar");
        btnGuardar = new Button("Guardar");

        // Organizamos los espacios
        this.setHgap(10); // separacion horizontal entre columnas
        this.setVgap(8); // separacion vertical entre filas
        this.setPadding(new Insets(20));

        // Añadimos datos al comboBox
        cmbClasificacion.getItems().addAll("Todos los Públicos", "+3", "+6", "+9", "+12", "+14", "+18",
                "Jubilados Only");

        txtSinopsis.setPrefWidth(500);
        txtSinopsis.setPrefHeight(300);

        // Añadimos al gridPane los elementos
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

        // Cuando pulsamos sobre el boton reset llamamos a
        // La funcion reset
        btnReset.setOnAction(e -> {
            reset();
        });

        btnGuardar.setOnAction(e -> {
            guardar();
        });

    }

    /**
     * Resetea el formulario
     */
    private void reset() {
        this.txtTitulo.clear();
        // Para seleccionar un elemento usamos selectionModel
        this.cmbClasificacion.getSelectionModel().selectFirst();
        sldDuracion.setValue(120);
        txtSinopsis.clear();
    }

    /**
     * 
     * @return
     */
    private int guardar() {
        int resultado = -1;
        try (PeliculasDAO peliculasDAO = new PeliculasDAO()) {
            resultado = peliculasDAO.crearPelicula(txtTitulo.getText(),
                    cmbClasificacion.getSelectionModel().getSelectedIndex(), (int) sldDuracion.getValue(),
                    txtSinopsis.getText());
        } catch (Exception e) {
            // Mostramos una ventana de error con el mensaje
        }
        return resultado;
    }

}
