package hello.core.repository;

import hello.core.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<String,Member> store = new HashMap<>();
    @Override
    public Member save(Member member) {
        store.put(member.getEmail(),member);
        return member;
    }

    @Override
    public Optional<Member> findByEmail(String Email) {
        return Optional.empty();
    }

}
