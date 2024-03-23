package br.com.condominus.Condominus.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
@EqualsAndHashCode(of="id")
@Entity
public class Reservations {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalTime openingTime;
    @Column(nullable = false)
    private LocalTime closingTime;

    

}
