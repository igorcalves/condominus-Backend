package br.com.condominus.Condominus.domain;

import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
@EqualsAndHashCode(of="id")
@Entity
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(nullable = false)

    private BigDecimal condominiumPrice;

    @Column(nullable = false, unique = true)
    private String apartmentNumber;

    private Boolean enabled = true;


    public User(String id, @NotNull(message = "O campo 'name' é obrigatório") String name,
            @NotNull(message = "O campo 'phone' é obrigatório") String phone,
            @NotNull(message = "O campo 'cpf' é obrigatório") String cpf,
            @NotNull(message = "O campo 'role' é obrigatório") Role role,
            @NotNull(message = "O campo 'password' é obrigatório") String password,
            @NotNull(message = "O campo 'email' é obrigatório") @Email(message = "Formato de email inválido") String email,
            @NotNull(message = "O campo 'birthDay' é obrigatório") LocalDate birthDay,
            @NotNull(message = "O campo 'condominiumPrice' é obrigatório") @DecimalMin(value = "0.01", message = "O valor mínimo permitido é 0.01") BigDecimal condominiumPrice,
            @NotNull(message = "O campo 'apartmentNumber' é obrigatório") String apartmentNumber, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
        this.role = role;
        this.password = password;
        this.email = email;
        this.birthDay = birthDay;
        this.condominiumPrice = condominiumPrice;
        this.apartmentNumber = apartmentNumber;
        this.enabled = enabled;
    }





    public User(UserDTO dTO, User oldUser){
        this.id = oldUser.id;
        this.name = dTO.getName();
        this.phone = dTO.getPhone();
        this.cpf = oldUser.getCpf();
        this.role = oldUser.getRole();
        this.password = oldUser.getPassword();
        this.email = oldUser.getEmail();
        this.birthDay = dTO.getBirthDay();
        this.condominiumPrice = oldUser.getCondominiumPrice();
        this.apartmentNumber = oldUser.getApartmentNumber();
    }







}
