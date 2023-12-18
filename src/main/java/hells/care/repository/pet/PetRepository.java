package hells.care.repository.pet;

import hells.care.entity.pet.Pet;
import hells.care.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByUser(User user);
}
