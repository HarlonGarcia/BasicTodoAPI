package com.example.primeiraprova.repository;

import com.example.primeiraprova.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
    List<Todo> findByName(String name);

    List<Todo> findAll();
    Todo findById(int id);

    List<Todo> findByIsComplete(boolean isComplete);
}
