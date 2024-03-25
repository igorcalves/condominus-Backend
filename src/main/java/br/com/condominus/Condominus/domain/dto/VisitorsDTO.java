package br.com.condominus.Condominus.domain.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class VisitorsDTO {
    private String name;
    private String cpf;
    private LocalDate birthDay;
    private String email;
    private LocalDate registrationDate;
    private String phone;
    private String cpfUser;
}
