package com.example.primeiraprova.controller;

import com.example.primeiraprova.model.Todo;
import com.example.primeiraprova.service.TodoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping(value = "/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        ResponseEntity<Todo> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Todo todoCreated = todoService.addTodo(todo);

        if (todoCreated != null) {
            response = new ResponseEntity<Todo>(todoCreated, HttpStatus.CREATED);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return new ResponseEntity<List<Todo>>(todoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/q")
    public ResponseEntity<Todo> findByName(@RequestParam("name") String name) {
        return new ResponseEntity<Todo>(todoService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable int id) {
        ResponseEntity<Todo> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Todo todo = todoService.findById(id);

        if (todo != null) {
            response = new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }
        return response;
    }
}

