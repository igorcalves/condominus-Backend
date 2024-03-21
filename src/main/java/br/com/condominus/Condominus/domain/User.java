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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
@EqualsAndHashCode(of="id")
@Entity
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String id;
    @Column(nullable = false)
    @NotNull(message = "O campo 'name' é obrigatório")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "O campo 'address' é obrigatório")
    private String address;

    @Column(nullable = false)
    @NotNull(message = "O campo 'phone' é obrigatório")
    private String phone;

    @Column(nullable = false, unique = true)
    @NotNull(message = "O campo 'cpf' é obrigatório")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "O campo 'role' é obrigatório")
    private Role role;

    @Column(nullable = false)
    @NotNull(message = "O campo 'password' é obrigatório")
    private String password;

    @Column(nullable = false, unique = true)
    @NotNull(message = "O campo 'email' é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "O campo 'birthDay' é obrigatório")
    private LocalDate birthDay;

    @Column(nullable = false)
    @NotNull(message = "O campo 'condominiumPrice' é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor mínimo permitido é 0.01")
    private BigDecimal condominiumPrice;

    @Column(nullable = false, unique = true)
    @NotNull(message = "O campo 'apartmentNumber' é obrigatório")
    private String apartmentNumber;

    private Boolean enabled = true;


    public User(UserDTO dTO, User oldUser){
        this.id = oldUser.id;
        this.name = dTO.getName();
        this.address = dTO.getAddress();
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
