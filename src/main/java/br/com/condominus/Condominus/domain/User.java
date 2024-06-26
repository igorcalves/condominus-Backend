package br.com.condominus.Condominus.domain;

import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
@EqualsAndHashCode(of = "id")
@Entity
public class User implements UserDetails {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    @NotNull(message = "O campo 'name' é obrigatório")
    private String name;
    @Column(nullable = false)
    @NotNull(message = "O campo 'login' é obrigatório")
    private String login;
    @NotNull(message = "O campo 'phone' é obrigatório")
    @Column(nullable = false)
    private String phone;
    @NotNull(message = "O campo 'cpf' é obrigatório")
    @Column(nullable = false, unique = true)
    private String cpf;
    @NotNull(message = "O campo 'role' é obrigatório")
    @Column(nullable = false)
    private Role role;
    @NotNull(message = "O campo 'password' é obrigatório")
    @Column(nullable = false)
    private String password;
    @NotNull(message = "O campo 'email' é obrigatório")
    @Email(message = "Formato de email inválido")
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull(message = "O campo 'birthDay' é obrigatório")
    @Column(nullable = false)
    private LocalDate birthDay;
    @Column(nullable = false)
    @NotNull(message = "O campo 'condominiumPrice' é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor mínimo permitido é 0.01")
    private BigDecimal condominiumPrice;
    @NotNull(message = "O campo 'apartmentNumber' é obrigatório")
    @Column(nullable = false, unique = true)
    private String apartmentNumber;
    private Boolean enabled = true;

    public User(String id,String name,String login, String phone, String cpf,
            Role role,
            String password,
            String email,
            LocalDate birthDay,
            BigDecimal condominiumPrice,
            String apartmentNumber, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.login = login;
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

    public User(UserDTO dTO, User oldUser) {
        this.id = oldUser.id;
        this.login = oldUser.getLogin();
        this.name = dTO.getName();
        this.phone = dTO.getPhone();
        this.cpf = oldUser.getCpf();
        this.role = dTO.getRole();
        this.password = oldUser.getPassword();
        this.email = dTO.getEmail();
        this.birthDay = dTO.getBirthDay();
        this.condominiumPrice = dTO.getCondominiumPrice();
        this.apartmentNumber = dTO.getApartmentNumber();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.ADM) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
