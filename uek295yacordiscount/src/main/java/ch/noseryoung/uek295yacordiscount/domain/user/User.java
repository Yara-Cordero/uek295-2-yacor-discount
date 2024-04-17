package ch.noseryoung.uek295yacordiscount.domain.user;

import ch.noseryoung.uek295yacordiscount.domain.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @NotNull
    @Column(name = "name")
    @Length(max = 25)
    private String name;

    @NotNull
    @Column(name = "password")
    @Length(min = 4, max = 15)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id")
    private Role role;


}
