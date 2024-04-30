package br.com.condominus.Condominus.domain.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record ReservationReturn(int id, String name, String cpf, String nameArea, LocalDateTime startOfScheduling, LocalDateTime endOfScheduling) {
}
