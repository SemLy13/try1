package Tasks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class KVTaskClient {
    private final String serverUrl;
    private final String apiKey;

    public KVTaskClient(String serverUrl) throws IOException {
        this.serverUrl = serverUrl;
        this.apiKey = register();
    }

    private String register() throws IOException {
        URL url = new URL(serverUrl + "/register");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream in = connection.getInputStream(); Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            return scanner.nextLine();
        }
    }

    public void put(String key, String json) throws IOException {
        URL url = new URL(serverUrl + "/save/" + key + "?API_TOKEN=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to save data: " + responseCode);
        }

        // Чтение ответа сервера (если есть)
        try (InputStream in = connection.getInputStream(); Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public String load(String key) throws IOException {
        URL url = new URL(serverUrl + "/load/" + key + "?API_TOKEN=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to load data: " + responseCode);
        }

        try (InputStream in = connection.getInputStream(); Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            } else {
                return null; // Возвращаем null для пустого ответа
            }
        }
    }

}
