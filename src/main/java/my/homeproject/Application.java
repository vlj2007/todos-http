package my.homeproject;


import my.homeproject.todo.Todo;
import my.homeproject.todo.TodoClient;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Возвращаем весь список

//        TodoClient todoClient = new TodoClient();
//        List<Todo> todos = todoClient.findAll();
//        System.out.println(todos);

        //Поиск по id

        TodoClient todoClient = new TodoClient();
        var todos = todoClient.findById(5);
        System.out.println(todos);

        //Поиск по title (It dosen't work!)

//        TodoClient todoClient = new TodoClient();
//        var todos = todoClient.findByTitle("aliquam aut quasi");
//        System.out.println(todos);

        //Поиск по Сompleted (It dosen't work!)

//        TodoClient todoClient = new TodoClient();
//        var todos = todoClient.findByCompleted(false);
//        System.out.println(todos);

    }
}
