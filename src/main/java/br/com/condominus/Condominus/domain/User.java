package br.com.condominus.Condominus.domain;

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
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false,unique = true)
    private String cpf;
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate dayOfBirth;
    @Column(nullable = false)
    private BigDecimal priceOfCondominium;
    @Column(nullable = false)
    private int numberOfApartment;









}
