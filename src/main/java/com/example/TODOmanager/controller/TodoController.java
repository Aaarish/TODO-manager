package com.example.TODOmanager.controller;

import com.example.TODOmanager.model.Todo;
import com.example.TODOmanager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.addTodo(todo));
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable int todoId){
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> getAllTodos(@PathVariable int todoId){
        return ResponseEntity.ok(todoService.deleteTodo(todoId));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<String> updateTodo(@PathVariable("todoId") int oldTodoId, @RequestBody Todo newTodoDetails){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.updateTodo(oldTodoId, newTodoDetails));
    }
}
