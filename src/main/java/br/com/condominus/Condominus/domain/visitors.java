package br.com.condominus.Condominus.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VISITORS")
@EqualsAndHashCode(of="id")
@Entity
public class visitors {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false,unique = true)
    private String cpf;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    @Column(nullable = false)
    LocalDate registrationDate;
}
