package hello.core.repository;

import hello.core.domain.Member;
import hello.core.domain.TodoList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TodoListRepository {
    TodoList save(TodoList todoList);

    Optional<TodoList> read(Long code);
    void delete(Long code);
}
