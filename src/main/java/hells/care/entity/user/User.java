package hells.care.entity.user;

import hells.care.entity.base.BaseUserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseUserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_login_id", unique = true)
    private String loginId;

    @Column(name = "user_pwd")
    private String password;

    @Column(name = "user_nickname", unique = true)
    private String nickName;

    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();

    public User(String loginId, String password, String nickName) {
        this.loginId = loginId;
        this.password = password;
        this.nickName = nickName;
    }
}
