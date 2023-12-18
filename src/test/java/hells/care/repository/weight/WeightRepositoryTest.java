package hells.care.repository.weight;

import hells.care.entity.pet.Pet;
import hells.care.entity.user.User;
import hells.care.entity.weight.Weight;
import hells.care.repository.pet.PetRepository;
import hells.care.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeightRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    WeightRepository weightRepository;

    @Test
    @Transactional
    void 체중_등록() {
        //given
        User user = new User("test", "123123", "테스트");
        userRepository.save(user);
        Pet pet = new Pet("이복댕", "닥스훈트", 1, LocalDateTime.of(2014, 07, 31, 0, 0, 0), user);
        petRepository.save(pet);

        //when
        Weight weight = new Weight(new BigDecimal(9.28), LocalDateTime.now(), pet);
        weightRepository.save(weight);
        Weight findWeight = weightRepository.findById(weight.getId()).get();

        //then
        assertThat(weight.getId()).isEqualTo(findWeight.getId());
    }

    @Test
    @Transactional
    void 반려동물_체중_가져오기() {
        //given
        User user = new User("test", "123123", "테스트");
        userRepository.save(user);
        Pet pet = new Pet("이복댕", "닥스훈트", 1, LocalDateTime.of(2014, 07, 31, 0, 0, 0), user);
        petRepository.save(pet);
        Weight weight1 = new Weight(new BigDecimal(9.28), LocalDateTime.now(), pet);
        Weight weight2 = new Weight(new BigDecimal(9.21), LocalDateTime.now(), pet);
        Weight weight3 = new Weight(new BigDecimal(9.35), LocalDateTime.now(), pet);
        Weight weight4 = new Weight(new BigDecimal(9.25), LocalDateTime.now(), pet);
        weightRepository.save(weight1);
        weightRepository.save(weight2);
        weightRepository.save(weight3);
        weightRepository.save(weight4);

        //when
        List<Weight> findWeightsByPet = weightRepository.findByPet(pet);

        //then
        assertThat(findWeightsByPet.size()).isEqualTo(pet.getWeights().size());
    }
}