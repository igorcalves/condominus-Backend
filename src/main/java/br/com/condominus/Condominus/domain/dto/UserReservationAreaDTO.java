package br.com.condominus.Condominus.domain.dto;

import java.time.LocalDateTime;


public record UserReservationAreaDTO(String cpf,Integer areaId,LocalDateTime startOfScheduling,LocalDateTime endOfScheduling){};
