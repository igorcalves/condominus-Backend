package br.com.condominus.Condominus.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitorsDTO {
    private String name;
    private String cpf;
    private LocalDate birthDay;
    private String email;
    private LocalDate registrationDate;
    private String phone;  
}
