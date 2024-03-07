package hello.core.repository;

import hello.core.domain.Member;
import hello.core.domain.TodoList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.*;

public class MemoryTodoListRepository implements TodoListRepository{
    private static Map<Long, TodoList> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public TodoList save(TodoList todoList) {
        todoList.setCode(sequence);
        store.put(todoList.getCode(),todoList);
        return todoList;
    }
    @Override
    public Optional<TodoList> read(Long code) {
        return store.values().stream().filter(todoList -> todoList.getCode().equals(code)).findAny();
    }

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void delete(Long code) {
        entityManager.createQuery("DELETE FROM TodoList t WHERE t.Code = :code")
                .setParameter("code", code)
                .executeUpdate();

    }



}
