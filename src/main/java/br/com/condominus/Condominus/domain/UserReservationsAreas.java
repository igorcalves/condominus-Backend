package br.com.condominus.Condominus.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "User_Reservation_Areas")
@EqualsAndHashCode(of="id")
@Entity
public class UserReservationsAreas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startOfScheduling;
    private LocalDateTime endOfScheduling;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "reservation_id")
    private Areas area;

    public UserReservationsAreas(@NotNull(message = "é necessario um morador para agendar um local")User user,
                                @NotNull(message = "é necessario um local realizar um agendamento")Areas area,
                                @NotNull(message = "O campo inicio do agendamento é obrigatorio")LocalDateTime startOfScheduling,
                                @NotNull(message = "O campo fim do agendamento é obrigatorio")LocalDateTime endOfScheduling){
        this.user = user;
        this.area = area;
        this.startOfScheduling = startOfScheduling;
        this.endOfScheduling = endOfScheduling;
    }

    
}
