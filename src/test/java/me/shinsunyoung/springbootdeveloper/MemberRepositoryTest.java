package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
// JPA 메서드 사용법 익히기

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    // SELECT * FROM member;
    @Sql("/insert-members.sql")
    @Test
    void getAllMembers() {
        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(3);
    }

    // SELECT * FROM member WHERE id = 2;
    @Sql("/insert-members.sql")
    @Test
    void getMemberById() {
        // when
        Member member = memberRepository.findById(2L).get();

        //then
        assertThat(member.getName()).isEqualTo("B");
    }
    @Sql("/insert-members.sql")
    @Test
    void getMemberByName() {
        // when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }
}