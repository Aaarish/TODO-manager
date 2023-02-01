package com.example.TODOmanager.service;

import com.example.TODOmanager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);

    private List<Todo> todoList = new ArrayList<>();

    public String addTodo(Todo todo) {
        todoList.add(todo);
        return "todo added";
    }

    public Todo getTodo(int todoId) {
        Todo todo = todoList.stream()
                .filter(t -> t.getTodoId() == todoId)
                .findFirst()
                .get();

        return todo;
    }

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public String deleteTodo(int todoId) {
        Todo todo = this.getTodo(todoId);
        todoList.remove(todo);
        logger.info("todo list : {}", todoList);
        return "deleted";
    }

    public String updateTodo(int oldTodoId, Todo newTodoDetails) {
        Todo todo = this.getTodo(oldTodoId);

        todoList.forEach(t -> {
            if(t == todo){
                t.setTodoId(newTodoDetails.getTodoId());
                t.setContent(newTodoDetails.getContent());
                t.setStatus(newTodoDetails.getStatus());
            }
        });

        return "updated";
    }
}
