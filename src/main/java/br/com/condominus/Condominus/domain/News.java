package br.com.condominus.Condominus.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "News")
@EqualsAndHashCode(of="id")
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String body;
}
