package hello.core.repository;

import hello.core.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface MemberRepository  {
    Member save(Member member);
    Optional<Member> findByEmail(String Email);

}
