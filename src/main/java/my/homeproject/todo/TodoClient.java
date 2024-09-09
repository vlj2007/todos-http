package my.homeproject.todo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/***
 * Класс для работы клиента
 */

public class TodoClient {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    /**
     * Конструктор - создание нового объекта клиента
     * @see TodoClient#TodoClient()
     */

    public TodoClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    /***
     * Метод для списка всех задач в системе, возвращает всю строку данных
     */

    public List<Todo> findAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<>() {}) ;
    }

    /***
     * Метод для списка всех задач в системе, возвращает строку данных по Id
     */

    public Todo findById(int i) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + i))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Todo.class);
    }

    /***
     * Метод для списка всех задач в системе, возвращает строку данных по Title
     */

    public Todo findByTitle(String i) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + i))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Todo.class);
    }

    /***
     * Метод для списка всех задач в системе, возвращает строку данных по Completed
     */

    public Todo findByCompleted(Boolean i) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + i))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Todo.class);
    }

}
