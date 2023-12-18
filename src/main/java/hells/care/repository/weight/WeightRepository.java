package hells.care.repository.weight;

import hells.care.entity.pet.Pet;
import hells.care.entity.weight.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightRepository extends JpaRepository<Weight, Long> {

    List<Weight> findByPet(Pet pet);
}
