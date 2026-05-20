package com.daw;

import com.daw.panels.BotPanel;
import com.daw.panels.FicherosPanel;
import com.daw.panels.PeliculaPanel;
import com.daw.ventanas.VentanaBorrar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Aplicación principal con pestañas y menús.
 * Integra los paneles de Películas, Ficheros y Agente IA
 * en un TabPane con una barra de menú superior
 */
public class EjemploPaneles extends Application {

    private VentanaBorrar vBorrar;

    @Override
    public void start(Stage stage) {

        // Creamos los tres paneles que irán en cada pestaña
        BorderPane pPrincipal = new BorderPane();
        PeliculaPanel pPelicula = new PeliculaPanel();
        FicherosPanel pFicheros = new FicherosPanel();
        BotPanel pJardinero = new BotPanel();

        // Configuramos el panel de pestañas con las tres pestañas
        TabPane tPane = new TabPane();
        Tab tPelicula = new Tab("Crear Pelicula");
        Tab tFicheros = new Tab("Abrir Fichero");
        Tab tBot = new Tab("Agente IA");

        // Las pestañas no se pueden cerrar individualmente
        tPelicula.setClosable(false);
        tFicheros.setClosable(false);
        tBot.setContent(pJardinero);
        tPane.getTabs().addAll(tPelicula, tFicheros, tBot);

        tPelicula.setContent(pPelicula);
        tFicheros.setContent(pFicheros);

        /***********************
         * MENUS
         ************************/
        MenuBar mbPrincipal = new MenuBar();
        Menu mArchivo = new Menu("Archivo");
        Menu mBD = new Menu("Base de Datos");
        Menu mOpciones = new Menu("Opciones");
        Menu mAyuda = new Menu("Ayuda");
        Menu mOperaciones = new Menu("Operaciones");

        MenuItem miAbrir = new MenuItem("Abrir..");
        MenuItem miGuardar = new MenuItem("Guardar..");
        MenuItem miSalir = new MenuItem("Cerrar..");
        SeparatorMenuItem separador = new SeparatorMenuItem();

        mArchivo.getItems().addAll(miAbrir, miGuardar, separador, miSalir);
        MenuItem miCrearPelicula = new MenuItem("Crear Pelicula");
        MenuItem miBorrarPelicula = new MenuItem("Borrar Pelicula");
        mBD.getItems().add(mOperaciones);
        mOperaciones.getItems().addAll(miCrearPelicula, miBorrarPelicula);

        mbPrincipal.getMenus().addAll(mArchivo, mBD, mOpciones, mAyuda);

        /*****************************
         * EVENTOS
         ************************/
        miSalir.setOnAction(e -> stage.close());

        miCrearPelicula.setOnAction(e -> {
            // Al pulsar "Crear Pelicula" en el menú,
            // nos lleva directamente a la pestaña del formulario
            tPane.getSelectionModel().select(tPelicula);
        });

        miBorrarPelicula.setOnAction(e -> {
            // Abre la ventana modal de borrado.
            // Se crea una nueva cada vez para que los datos estén actualizados
            vBorrar = new VentanaBorrar(stage);
            vBorrar.show();
        });

        // Montamos el BorderPane: menú arriba, pestañas en el centro
        pPrincipal.setCenter(tPane);
        pPrincipal.setTop(mbPrincipal);

        Scene scene = new Scene(pPrincipal, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Ejemplo Paneles");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
