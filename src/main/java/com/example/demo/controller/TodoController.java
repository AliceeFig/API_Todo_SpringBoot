package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todosList = todoService.getAllTodos();
        return ResponseEntity.ok(todosList);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestParam String title) {
        Todo createdTodo = todoService.createTodo(title);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id,
                                           @RequestParam String title) {
        Todo updatedTodo = todoService.updateTodo(id, title);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/isCompleted")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable long id) {
        Todo updatedTodo = todoService.updateTodoStatus(id);
        return ResponseEntity.ok(updatedTodo);
    }
}
