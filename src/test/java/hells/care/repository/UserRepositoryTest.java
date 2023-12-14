package hells.care.repository;

import hells.care.entity.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    void 유저_등록() {
        //given
        User user = new User("test", "123123", "테스트");

        //when
        userRepository.save(user);
        User findUser = userRepository.findById(user.getId()).get();
        int userCount = userRepository.findAll().size();

        //then
        assertThat(userCount).isEqualTo(1);
        assertThat(findUser.getId()).isEqualTo(user.getId());
    }

    @Test
    void 유저_중복_확인() {
        //given
        User user = new User("test", "123123", "테스트");
        userRepository.save(user);

        //when
        User findByLoginId = userRepository.findByLoginId("test").get();     // 아이디 중복 확인
        User findByNickName = userRepository.findByNickName("테스트").get();   // 닉네임 중복 확인

        //then
        assertThat(user.getId()).isEqualTo(findByLoginId.getId());
        assertThat(user.getId()).isEqualTo(findByNickName.getId());

    }
}