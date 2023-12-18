package hells.care.entity.weight;

import hells.care.entity.pet.Pet;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weight_id")
    private Long id;

    @Column(name = "weight_weight", scale = 2)
    private BigDecimal weight;

    @Column(name = "weight_date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Weight(BigDecimal weight, LocalDateTime date, Pet pet) {
        this.weight = weight;
        this.date = date;
        this.pet = pet;
        this.pet.getWeights().add(this);
    }
}
