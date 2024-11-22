package br.com.hospital.painel.hospitalpanel.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer idRole;

    @Column(unique = true, nullable = false)
    private String name;

    // Relacionamento muitos-para-muitos com a entidade AppUser
    @ManyToMany(mappedBy = "roles")
    @JsonBackReference // Indica o lado "traseiro" da relação
    private Set<AppUser> users;

    public Role() {}
}
