package cg.codegym.module4.customermanagementthymeleaf.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class PlayerJwt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Positions> positions;
}
