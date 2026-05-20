package com.daw.panels;

import java.util.List;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BotPanel extends GridPane {

    // Cargamos las variables de entorno una sola vez para toda la app
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("GEMINI_API_KEY");
    private static final String API_MODEL = "gemini-2.5-flash";

    // Cliente y config de Gemini se crean bajo demanda (no estáticos)
    // para evitar fallos en el arranque si falta la API key
    private Client client;
    private GenerateContentConfig config;

    private ScrollPane scrollChat;
    private Text chatHistory;
    private TextField txtPrompt;
    private Button btnEnviar;

    public BotPanel() {
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(25, 25, 25, 25));

        scrollChat = new ScrollPane();
        chatHistory = new Text("Bienvenido al chat de Jardineria, que te cuentas?");
        btnEnviar = new Button("Enviar");
        txtPrompt = new TextField();

        this.scrollChat.setContent(chatHistory);
        scrollChat.setPrefSize(500, 400);

        this.add(scrollChat, 0, 0, 2, 1);
        this.add(txtPrompt, 0, 1);
        this.add(btnEnviar, 1, 1);

        // Inicializamos el cliente y la config de la API de Gemini
        this.inicializarGemini();

        // Evento del botón: lanza la llamada a la IA en un hilo separado
        // para no bloquear la interfaz gráfica
        btnEnviar.setOnAction(e -> {
            String prompt = txtPrompt.getText().trim();
            if (!prompt.isEmpty()) {
                btnEnviar.setDisable(true);
                txtPrompt.setDisable(true);
                new Thread(this::llamarIA).start();
            }
        });
    }

    // Inicializa el cliente y la config de Gemini.
    // Si la API key no está configurada, muestra un error y deshabilita el botón
    private void inicializarGemini() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de configuración");
            alert.setHeaderText(null);
            alert.setContentText("GEMINI_API_KEY no está configurada en el archivo .env");
            alert.showAndWait();
            btnEnviar.setDisable(true);
            txtPrompt.setDisable(true);
            return;
        }

        this.client = Client.builder()
                .apiKey(API_KEY)
                .build();

        this.config = GenerateContentConfig.builder()
                .systemInstruction(
                        Content.builder()
                                .role("system")
                                .parts(List.of(
                                        Part.builder()
                                                .text("Actua como un profesor de jardineria, un jubilado experto que contesta en modo ironico y bromista con frecuencia")
                                                .build()))
                                .build())
                .temperature(2.0f)
                .topP(0.95f)
                .maxOutputTokens(50000)
                .build();
    }

    // Llama a la API de Gemini en segundo plano y actualiza la UI
    // cuando la respuesta llega. Usa Platform.runLater para tocar nodos
    // de JavaFX desde el hilo secundario
    private void llamarIA() {
        try {
            GenerateContentResponse response = client.models.generateContent(
                    API_MODEL,
                    txtPrompt.getText(),
                    config);

            String respuesta = response.text();

            // Volvemos al hilo de JavaFX para actualizar la interfaz
            Platform.runLater(() -> {
                this.chatHistory.setText(this.chatHistory.getText() + " \n"
                        + txtPrompt.getText() + "\n" + respuesta);
                txtPrompt.clear();
                btnEnviar.setDisable(false);
                txtPrompt.setDisable(false);
                txtPrompt.requestFocus();
            });

        } catch (Exception e) {
            // Cualquier error de red o API se muestra al usuario sin crashear la app
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de conexión");
                alert.setHeaderText(null);
                alert.setContentText("No se pudo conectar con la IA: " + e.getMessage());
                alert.showAndWait();
                btnEnviar.setDisable(false);
                txtPrompt.setDisable(false);
            });
        }
    }
}
