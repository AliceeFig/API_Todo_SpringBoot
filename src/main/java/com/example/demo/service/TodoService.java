package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    public Todo updateTodo(long id, String updatedTitle) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (todo.getTitle().equals(updatedTitle)) {
            throw new IllegalArgumentException("Title is the same as current");
        }

        todo.setTitle(updatedTitle);
        return todoRepository.save(todo);
    }

    public void deleteTodo(long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }
        todoRepository.deleteById(id);
    }

    public Todo updateTodoStatus(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (todo.isCompleted()) {
            throw new IllegalArgumentException("Todo already completed");
        }

        todo.setCompleted(true);
        return todoRepository.save(todo);
    }
}
