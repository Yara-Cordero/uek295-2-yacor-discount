package ch.noseryoung.uek295yacordiscount.domain.role;

import ch.noseryoung.uek295yacordiscount.domain.authority.Authority;
import ch.noseryoung.uek295yacordiscount.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role_name",unique = true)
    @NotNull
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_authorities",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_authority")
    )
    private Set<Authority> authorities;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}


