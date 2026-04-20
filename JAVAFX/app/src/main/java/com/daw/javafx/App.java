package com.daw.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    // Punto de entrada JavaFX
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Barra de menús
        root.setTop(crearMenuBar(stage));

        // Pestañas en el centro
        root.setCenter(crearTabPane());

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("Mi App JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar crearMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();

        // Menú Archivo
        Menu menuArchivo = new Menu("Archivo");
        MenuItem nuevo = new MenuItem("Nuevo");
        MenuItem abrir = new MenuItem("Abrir");
        MenuItem salir = new MenuItem("Salir");
        salir.setOnAction(e -> stage.close());
        menuArchivo.getItems().addAll(nuevo, abrir,
                new SeparatorMenuItem(), salir);

        // Menú Ayuda
        Menu menuAyuda = new Menu("Ayuda");
        MenuItem sobre = new MenuItem("Acerca de...");
        sobre.setOnAction(e -> mostrarAlerta());
        menuAyuda.getItems().add(sobre);

        menuBar.getMenus().addAll(menuArchivo, menuAyuda);
        return menuBar;
    }

    private TabPane crearTabPane() {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Inicio");
        tab1.setClosable(false);
        tab1.setContent(new Label("  Bienvenido a la pestaña Inicio"));

        Tab tab2 = new Tab("Formulario");
        tab2.setClosable(false);
        tab2.setContent(crearFormulario());

        Tab tab3 = new Tab("Tabla");
        tab3.setClosable(false);
        tab3.setContent(new Label("  Aquí irá una TableView"));

        tabPane.getTabs().addAll(tab1, tab2, tab3);
        return tabPane;
    }

    private VBox crearFormulario() {
        VBox form = new VBox(12);
        form.setPadding(new javafx.geometry.Insets(20));
        form.getChildren().addAll(
                new Label("Nombre:"),
                new TextField(),
                new Label("Email:"),
                new TextField(),
                new Button("Guardar"));
        return form;
    }

    private void mostrarAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setContentText("Mi App JavaFX v1.0");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}