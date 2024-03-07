package hello.core.controller;

import hello.core.domain.Member;
import hello.core.service.MemberLoginService;
import hello.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;

    }
    @GetMapping("/members/join")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/join")
    public String create(MemberForm form){
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(passwordEncoder.encode(form.getPassword()));
        member.setNickName(form.getNickname());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginForm(){
        return "members/login_form";
    }



}
