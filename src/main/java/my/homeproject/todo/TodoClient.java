package my.homeproject.todo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/***
 * Класс для работы клиента
 */

public class TodoClient {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    private final HttpClient client;

    /***
     * Клиент для вызова других сервисов
     */

    public TodoClient() {
        client = HttpClient.newHttpClient();
    }

    /***
     * Метод для списка всех задач в системе, возвращает строку данных
     */

    public String findAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


}
