package hello.core.service;

import hello.core.domain.Member;
import hello.core.domain.TodoList;
import hello.core.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getEmail();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
