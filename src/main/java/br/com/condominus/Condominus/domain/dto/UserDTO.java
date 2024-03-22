package br.com.condominus.Condominus.domain.dto;

import br.com.condominus.Condominus.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String cpf;
    private String phone;
    private Role role;
    private String email;
    private LocalDate birthDay;
    private BigDecimal condominiumPrice;
    private String apartmentNumber;
}
