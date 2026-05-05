package com.daw;

import com.daw.panels.FicherosPanel;
import com.daw.panels.PeliculaPanel;
import com.daw.ventanas.VentanaBorrar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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

    private VentanaBorrar vBorrar;

    @Override
    public void start(Stage stage) {

        // El panel de pestañas contiene pestañas
        // Por defecto se pueden cerrar, con setclosable se quita la opcion
        // Hay que añadir las pestañas al panel de pestañas para que se muestren
        // Hay que añadir contenido a las pestañas con setContent

        BorderPane pPrincipal = new BorderPane();
        PeliculaPanel pPelicula = new PeliculaPanel();
        FicherosPanel pFicheros = new FicherosPanel();

        TabPane tPane = new TabPane();

        Tab tPelicula = new Tab("Crear Pelicula");
        Tab tFicheros = new Tab("Abrir Fichero");
        Tab tBot = new Tab("Agente IA");

        tPelicula.setClosable(false);
        tFicheros.setClosable(false);
        tPane.getTabs().addAll(tPelicula, tFicheros, tBot);

        // Metemos el panelPelicula en la primera pestaña
        tPelicula.setContent(pPelicula);
        tFicheros.setContent(pFicheros);

        /***********************
         * MENUS
         ************************/
        MenuBar mbPrincipal = new MenuBar();
        // Menus
        Menu mArchivo = new Menu("Archivo");
        Menu mBD = new Menu("Base de Datos");
        Menu mOpciones = new Menu("Opciones");
        Menu mAyuda = new Menu("Ayuda");
        Menu mOperaciones = new Menu("Operaciones");
        // MenuItems
        MenuItem miAbrir = new MenuItem("Abrir..");
        MenuItem miGuardar = new MenuItem("Guardar..");
        MenuItem miSalir = new MenuItem("Cerrar..");
        SeparatorMenuItem separador = new SeparatorMenuItem();

        mArchivo.getItems().addAll(miAbrir, miGuardar, separador, miSalir);
        MenuItem miCrearPelicula = new MenuItem("Crear Pelicula");
        MenuItem miBorrarPelicula = new MenuItem("Borrar Pelicula");
        mBD.getItems().add(mOperaciones);
        mOperaciones.getItems().addAll(miCrearPelicula, miBorrarPelicula);

        // Cargamos en la barra de menus lso menus
        mbPrincipal.getMenus().addAll(mArchivo, mBD, mOpciones, mAyuda);

        /*****************************
         * EVENTOS
         ************************/
        miSalir.setOnAction(e -> {
            stage.close();
        });

        miCrearPelicula.setOnAction(e -> {
            // Seleccionamos la pestaña primer del panel
            // Que es la de insertar pelicula
            tPane.getSelectionModel().select(tPelicula);
        });

        // Cuando pulsamos en borrar se abre la ventana de borrar peliculas
        miBorrarPelicula.setOnAction(e -> {

            vBorrar = new VentanaBorrar(stage);
            vBorrar.show();

        });

        // Ponemos en la posicion central del borderpane
        // Nuestro Tabpane
        pPrincipal.setCenter(tPane);
        // Ponemos en la parte superior del borderpane el menu
        pPrincipal.setTop(mbPrincipal);

        // Creamos una escena que contiene al panel pricipal (borderpane)
        Scene scene = new Scene(pPrincipal, 800, 600);
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
