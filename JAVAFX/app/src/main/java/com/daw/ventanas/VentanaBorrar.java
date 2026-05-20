package com.daw.ventanas;

import java.util.ArrayList;

import com.daw.model.PeliculaCombo;
import com.daw.model.PeliculasDAO;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Ventana modal para borrar películas de la base de datos.
// Muestra un ComboBox con todas las películas y un botón para eliminar
public class VentanaBorrar extends Stage {

    private ComboBox<PeliculaCombo> cmbPeliculas;

    public VentanaBorrar(Stage stage) {
        VBox pVertical = new VBox();
        cmbPeliculas = new ComboBox<>();
        this.cargarPeliculas();
        pVertical.getChildren().add(cmbPeliculas);
        Button btnBorrar = new Button("Borrar Pelicula");
        btnBorrar.setOnAction(e -> this.eliminarPelicula());
        pVertical.getChildren().add(btnBorrar);

        Scene scene = new Scene(pVertical, 600, 400);
        this.setScene(scene);
        // Hacemos la ventana modal: bloquea la ventana padre mientras está abierta
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(stage);
    }

    // Carga la lista de películas desde la BD y la asigna al ComboBox.
    // Selecciona automáticamente el primer elemento si hay datos
    private void cargarPeliculas() {
        cmbPeliculas.getItems().clear();
        try (PeliculasDAO pDao = new PeliculasDAO()) {
            ArrayList<PeliculaCombo> listaPeliculas = pDao.getListaPeliculas();
            cmbPeliculas.setItems(FXCollections.observableList(listaPeliculas));
            if (!listaPeliculas.isEmpty()) {
                cmbPeliculas.getSelectionModel().selectFirst();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de BD");
            alert.setHeaderText(null);
            alert.setContentText("No se pudieron cargar las películas.");
            alert.showAndWait();
        }
    }

    // Elimina la película seleccionada:
    // 1. Valida que haya una selección
    // 2. Pide confirmación al usuario
    // 3. Borra de BD y recarga la lista
    // 4. Muestra mensaje de éxito o error
    private void eliminarPelicula() {
        PeliculaCombo seleccionada = cmbPeliculas.getValue();
        if (seleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona una película para borrar.");
            alert.showAndWait();
            return;
        }

        // Diálogo de confirmación antes de borrar
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar borrado");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Estás seguro de que quieres borrar \"" + seleccionada.getTitulo() + "\"?");
        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL) != ButtonType.OK) {
            return;
        }

        try (PeliculasDAO pDao = new PeliculasDAO()) {
            pDao.eliminarPeliculas(seleccionada.getId());
            this.cargarPeliculas();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operación completada");
            alert.setHeaderText(null);
            alert.setContentText("Película borrada correctamente.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al borrar");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo borrar la película.");
            alert.showAndWait();
        }
    }

}
