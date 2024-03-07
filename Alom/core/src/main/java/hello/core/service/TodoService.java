package hello.core.service;

import hello.core.domain.TodoList;
import hello.core.repository.TodoListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    private final TodoListRepository todoListRepository;

    public TodoService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    @Transactional
    public Long Create(TodoList todoList){
        todoListRepository.save(todoList);
        return todoList.getCode();
    }
    @Transactional
    public void Read(TodoList todoList){
        todoListRepository.read(todoList.getCode());
    }
    @Transactional
    public void Update(TodoList todoList,Long code){
        todoListRepository.read(code).ifPresentOrElse(
                existingTodoList -> {
                    existingTodoList.setInformaiton(todoList.getInformaiton());
                    existingTodoList.setDone(todoList.getDone());
                    existingTodoList.setStartTime(todoList.getStartTime());
                    existingTodoList.setEndTime(todoList.getEndTime());
                    todoListRepository.save(existingTodoList);
                },
                () -> {
                    throw new IllegalArgumentException("TodoList with code " + code + " not found");
                }
        );
    }
    @Transactional
    public void Delete(TodoList todoList,Long code){
        todoListRepository.delete(code);
    }


}
