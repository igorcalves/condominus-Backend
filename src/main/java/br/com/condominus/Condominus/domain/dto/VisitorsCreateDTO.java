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
public class VisitorsCreateDTO extends VisitorsDTO {
    private String cpfUser;


    public VisitorsCreateDTO(String name, String cpf, LocalDate birthDay, String email, LocalDate registrationDate, String cpfUser, String phone) {
        super(name, cpf, birthDay, email, registrationDate,phone);
        this.cpfUser = cpfUser;
    }
}
