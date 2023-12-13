package hells.care.entity.user;

import hells.care.entity.base.BaseUserEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "USER")
public class User extends BaseUserEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_login_id", unique = true)
    private String loginId;

    @Column(name = "user_pwd")
    private String password;

    @Column(name = "user_nickname")
    private String nickName;
}
