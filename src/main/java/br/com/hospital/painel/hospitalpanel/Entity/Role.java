package br.com.hospital.painel.hospitalpanel.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long idRole;

    @Column(unique = true, nullable = false)
    private String name;

    // Relacionamento muitos-para-muitos com a entidade AppUser
    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> users;

    public Role() {}
}
