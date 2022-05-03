package vn.techmaster.todothymeleaf.service;

import org.springframework.stereotype.Service;
import vn.techmaster.todothymeleaf.model.Todo;
import vn.techmaster.todothymeleaf.request.CreateTodoRequest;
import vn.techmaster.todothymeleaf.request.UpdateTodoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<Todo>();

    public TodoService() {
        Random rd = new Random();
        todos.add(new Todo(rd.nextInt(100), "January", false));
        todos.add(new Todo(rd.nextInt(100), "February", true));
        todos.add(new Todo(rd.nextInt(100), "March", true));
    }

    public List<Todo> getTodos(String status) {
        return switch(status) {
            case "true" -> todos.stream().filter(Todo::isStatus).collect(Collectors.toList());
            case "flase" -> todos.stream().filter(todo -> !todo.isStatus()).collect(Collectors.toList());
            default -> todos;
        };
    }

    public Todo createTodo(CreateTodoRequest request) {
        Random rd = new Random();
        // Tạo todo
        Todo todo = new Todo();
        todo.setId(rd.nextInt(100));
        todo.setTitle(request.getTitle());
        todo.setStatus(false);

        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        for (Todo todo : todos) {
            if(todo.getId() == id) {
                todo.setTitle(request.getTitle());
                todo.setStatus(request.isStatus());
                return todo;
            }
        }
        return null;
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
