package br.com.condominus.artfactCondominus.domain;

import br.com.condominus.artfactCondominus.domain.enums.AreasForReservations;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate openingTime;
    @Column(nullable = false)
    private LocalDate closingTime;
    @Column(nullable = false)
    private AreasForReservations reservationArea;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

}
