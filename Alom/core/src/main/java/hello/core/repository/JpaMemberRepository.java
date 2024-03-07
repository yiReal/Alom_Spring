package hello.core.repository;

import hello.core.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }


    @Override
    public Optional<Member> findByEmail(String email) {
        List<Member> result = em.createQuery("select m from Member m where m.Email = :email",Member.class).setParameter("email",email).getResultList();
        return result.stream().findAny();
    }

}
