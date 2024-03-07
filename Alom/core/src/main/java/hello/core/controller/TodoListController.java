package hello.core.controller;

import hello.core.domain.Member;
import hello.core.domain.TodoList;
import hello.core.repository.TodoListRepository;
import hello.core.service.MemberService;
import hello.core.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoListController {
    private final TodoService todoService;
    @Autowired
    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }




}
