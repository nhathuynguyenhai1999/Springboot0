package cg.codegym.module4.customermanagementthymeleaf.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    // Constructors, getters, and setters
    public Note() {}

    public Note(String content) {
        this.content = content;
    }

}
