package hells.care.entity.pet;

import hells.care.entity.user.User;
import hells.care.entity.weight.Weight;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "pet_type")
    private String petType;

    @Column(name = "pet_gender")
    private int petGender;

    @Column(name = "pet_birth")
    private LocalDateTime petBirth;

    @Column(name = "pet_leave_date")
    private LocalDateTime petLeaveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "pet")
    List<Weight> weights = new ArrayList<>();

    public Pet(String petName, String petType, int petGender, LocalDateTime petBirth, User user) {
        this.petName = petName;
        this.petType = petType;
        this.petGender = petGender;
        this.petBirth = petBirth;
        this.user = user;
        this.user.getPets().add(this);
    }
}
