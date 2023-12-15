package hells.care.repository.user;

import hells.care.entity.user.DeletedUser;
import hells.care.entity.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeletedUserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired DeletedUserRepository deletedUserRepository;

    @Test
    void 유저_탈퇴() {
        //given
        User user = new User("test", "123123", "테스트");
        userRepository.save(user);
        DeletedUser deletedUser = new DeletedUser(user.getLoginId(), user.getPassword(), user.getNickName());

        //when
        deletedUserRepository.save(deletedUser);
        userRepository.delete(user);
        DeletedUser findDeletedUser = deletedUserRepository.findByLoginId(deletedUser.getLoginId()).get();
        Optional<User> findUser = userRepository.findByLoginId(user.getLoginId());

        //then
        assertThat(findDeletedUser.getLoginId()).isEqualTo(user.getLoginId());
        System.out.println("탈퇴 시간 : " + findDeletedUser.getDeletedDate());
        assertThat(findUser.isPresent()).isFalse();
    }
}