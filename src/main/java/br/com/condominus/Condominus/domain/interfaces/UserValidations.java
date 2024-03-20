package br.com.condominus.Condominus.domain.interfaces;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.dto.UserDTO;

public interface UserValidations {

    boolean isValidUser(User user);

    boolean isValidDto(UserDTO data);

}