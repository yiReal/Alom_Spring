package hello.core;

import hello.core.repository.*;
import hello.core.service.MemberService;
import hello.core.service.TodoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public TodoService todoService(){
        return new TodoService(todoListRepository());
    }

    @Bean
    public TodoListRepository todoListRepository(){
        return new MemoryTodoListRepository();
    }
}
