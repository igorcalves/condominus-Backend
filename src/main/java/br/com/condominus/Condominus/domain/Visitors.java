package br.com.condominus.Condominus.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

import br.com.condominus.Condominus.domain.dto.VisitorsDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VISITORS")
@EqualsAndHashCode(of="id")
@Entity
public class Visitors {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
@NotNull(message = "O campo 'name' é obrigatório")
private String name;

@Column(nullable = false)
@NotNull(message = "O campo 'birthDay' é obrigatório")
private LocalDate birthDay;

@Column(nullable = false)
@NotNull(message = "O campo 'phone' é obrigatório")
private String phone;

@Column(nullable = false, unique = true)
@NotNull(message = "O campo 'cpf' é obrigatório")
private String cpf;

@Column(nullable = false, unique = true)
@NotNull(message = "O campo 'email' é obrigatório")
@Email(message = "Formato de email inválido")
private String email;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_user", referencedColumnName = "id")
@NotNull(message = "O campo 'user' é obrigatório")
private User user;

@Column(nullable = false)
@NotNull(message = "O campo 'registrationDate' é obrigatório")
private LocalDate registrationDate;

public Visitors (VisitorsDTO data, User user){
    this.name = data.getName();
    this.birthDay = data.getBirthDay();
    this.cpf = data.getCpf();
    this.email = data.getEmail();
    this.phone = data.getPhone();
    this.registrationDate = LocalDate.now();
    this.user = user;
    
}

public Visitors (VisitorsDTO newData,Visitors oldData , User user){
    this.id = oldData.id;
    this.name = newData.getName();
    this.birthDay = newData.getBirthDay();
    this.cpf = oldData.getCpf();
    this.email = newData.getEmail();
    this.phone = newData.getPhone();
    this.registrationDate = LocalDate.now();
    this.user = user;
    
}

}
