package com.daw.panels;

import java.util.List;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BotPanel extends GridPane {

    // Carga las variables del fichero .env el el objeto dotenv
    private Dotenv dotenv = Dotenv.load();

    private ScrollPane scrollChat;
    private Text chatHistory;
    private TextField txtPrompt;
    private Button btnEnviar;

    // Datos de la llamada a la api
    // sacamos del .env la clave api de gemini
    private final String API_KEY = dotenv.get("GEMINI_API_KEY");
    private final String API_MODEL = "gemini-2.5-flash";

    public BotPanel() {
        // espaciamos los elementos
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(25, 25, 25, 25));

        // Contruimos los nodos de javafx
        scrollChat = new ScrollPane();
        chatHistory = new Text("Bienvenido al chat de Jardineria, que te cuentas?");
        btnEnviar = new Button("Enviar");
        txtPrompt = new TextField();

        // Metemos el Text del chat en el ScrollPane
        this.scrollChat.setContent(chatHistory);

        scrollChat.setPrefSize(500, 400);

        this.add(scrollChat, 0, 0, 2, 1);
        this.add(txtPrompt, 0, 1);
        this.add(btnEnviar, 1, 1);

        btnEnviar.setOnAction(e -> {
            llamarIA();
        });

    }

    private void llamarIA() {

        // Creamos el objeto que llama a la api de google con la apikey
        Client client = Client.builder()
                .apiKey(API_KEY)
                .build();

        GenerateContentConfig config = GenerateContentConfig.builder()
                .systemInstruction(
                        Content.builder()
                                .role("system")
                                .parts(List.of(
                                        Part.builder()
                                                .text("Actua como un profesor de jardineria, un jubilado experto que contesta en modo ironico y bromista con frecuencia")
                                                .build()))
                                .build())// Para dar un rol y instrucciones hay que crear un objeto content que mentemos
                                         // a systemInstructions
                .temperature(2.0f) // temperatura es la locura o creatividad de la ia
                .topP(0.95f) // topp es la variedad de respuestas que tiene en cuenta
                .maxOutputTokens(50000) // tokens limita la cantidad de tokens gastados en la generacion
                .build();

        // llamamos a gemini con una pregunta
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash",
                txtPrompt.getText(),
                config);

        this.chatHistory.setText(this.chatHistory.getText() + " \n" +
                txtPrompt.getText() + "\n" + response.text());

    }
}
