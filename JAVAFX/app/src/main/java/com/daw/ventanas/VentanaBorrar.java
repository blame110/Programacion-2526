package com.daw.ventanas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daw.model.PeliculaCombo;
import com.daw.model.PeliculasDAO;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaBorrar extends Stage {

    private ComboBox<PeliculaCombo> cmbPeliculas;

    public VentanaBorrar(Stage stage) {
        // Creamos un VBox para añadir los elementos
        VBox pVertical = new VBox();
        // Añadimos al VBox la lista y el boton de borrar
        cmbPeliculas = new ComboBox<PeliculaCombo>();
        // Cargamos las peliculas de BD en el comboBox
        this.cargarPeliculas();
        pVertical.getChildren().add(cmbPeliculas);
        Button btnBorrar = new Button("Borrar Pelicula");
        // Al pulsar el boton de llama a la función
        // Para borrarla desde bd
        btnBorrar.setOnAction(e -> {
            this.eliminarPelicula();
        });
        pVertical.getChildren().add(btnBorrar);
        // Creamos la scene con el vbox con la lista y el boton
        Scene scene = new Scene(pVertical, 600, 400);
        // Esta misma clase es el stage, le asignamos la scene con el vbox
        this.setScene(scene);
        // Ponemos de modalidad de apertura window_modal para bloquear a la padre
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(stage);

    }

    private void cargarPeliculas() {
        // Vaciamos el combobox
        cmbPeliculas.getItems().clear();
        // Creamos el objeto peliculasDAO para sacar las peliculas
        // y cargamos de BD
        try (PeliculasDAO pDao = new PeliculasDAO();) {

            ArrayList<PeliculaCombo> listaPeliculas = pDao.getListaPeliculas();
            // Asignamos la lista de peliculas combo al combobox
            // Convirtientiendolas a Observablelist
            cmbPeliculas.setItems(FXCollections.observableList(listaPeliculas));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarPelicula() {
        // Saco el id del peliculaCombo selecionado en el combobox
        int idEliminar = cmbPeliculas.getValue().getId();
        try (PeliculasDAO pDao = new PeliculasDAO()) {
            pDao.eliminarPeliculas(idEliminar);
            this.cargarPeliculas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
