package my.homeproject;


import my.homeproject.todo.Todo;
import my.homeproject.todo.TodoClient;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

        TodoClient todoClient = new TodoClient();
        List<Todo> todos = todoClient.findAll();
        System.out.println(todos);
    }
}
