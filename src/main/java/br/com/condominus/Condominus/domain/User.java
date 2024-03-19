package br.com.condominus.Condominus.domain;

import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.enums.Role;
import jakarta.persistence.*;
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
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false,unique = true)
    @Setter(AccessLevel.NONE)
    private String cpf;
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    @Setter(AccessLevel.NONE)
    private String email;
    @Column(nullable = false)
    private LocalDate birthDay;
    @Column(nullable = false)
    private BigDecimal condominiumPrice;
    @Column(nullable = false,unique = true)
    private int apartmentNumber;
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
