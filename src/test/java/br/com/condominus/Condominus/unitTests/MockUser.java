package br.com.condominus.Condominus.unitTests;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.enums.Role;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockUser {


    public User mockEntity(){
        return mockEntity(1);
    }
    public UserDTO mockDto(){
        return mockDto(1);
    }

    public List<User> mockEntityList(){
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            users.add(mockEntity(i));
        }
        return users;

    }

    public List<UserDTO> mockDtoList(){
        List<UserDTO> users = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            users.add(mockDto(i));
        }
        return users;

    }


    public User mockEntity(Integer n){
        User user = new User();
        user.setId("UUID" + n);
        user.setName("name Test" + n);
        user.setPhone("phone Test" +n);
        user.setCpf(("Cpf Test" + n));
        user.setRole(Role.USER);
        user.setPassword("password Test" + n);
        user.setEmail("email Test" + n);
        user.setBirthDay(LocalDate.of(n,n,n));
        user.setCondominiumPrice(new BigDecimal(n.toString()));
        user.setApartmentNumber("a" +n);
        user.setEnabled(true);

        return user;
    }

    public UserDTO mockDto(Integer n){
        UserDTO data = new UserDTO();
        data.setName("name Test" + n);
        data.setCpf("cpf test" + n);
        data.setPhone("phone Test" + n);
        data.setRole(Role.USER);
        data.setEmail("email teste"+ n);
        data.setBirthDay(LocalDate.of(n,n,n));
        data.setApartmentNumber("a" + n);
        return data;
    }
}
