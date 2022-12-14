package com.example.primeiraprova.service;

import com.example.primeiraprova.model.Todo;
import com.example.primeiraprova.repository.TodoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Getter @Setter
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public Todo addTodo(Todo newTodo) {
        Todo todo = null;

        if (newTodo != null) {
            todo = todoRepository.save(newTodo);
        }
        return todo;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findByName(String name) {
        return todoRepository.findByName(name);
    }

    public Todo findById(int id) {
        return todoRepository.findById(id);
    }

    public void deleteById(int id) throws Exception {
        Todo todo = todoRepository.findById(id);

        if (todo != null) {
            todoRepository.delete(todo);
            return;
        }

        throw new Exception();
    }

    public Todo updateTodo(Todo todoWithChanges) {
        Todo todo = todoRepository.findById(todoWithChanges.getId());

        if (todo != null) {
            todo.setName(todoWithChanges.getName());
            todo.setComplete(todoWithChanges.isComplete());
            todoRepository.save(todo);
        }

        return todo;
    }
}
