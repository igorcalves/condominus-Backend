package br.com.condominus.Condominus.services;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.core.regex.ValidationsRegex;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.exceptions.exceptionModel.UserAlreadyExistsException;
import br.com.condominus.Condominus.exceptions.exceptionModel.UserNotFoundException;
import br.com.condominus.Condominus.mapper.ModelMapperConverter;
import br.com.condominus.Condominus.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ValidationsRegex validation;

    @Autowired
    private UserRepository repository;
    public String createUser(User user){
        try {
            repository.save(user);
            return "Usuario Criado com sucesso";
        }catch (DataIntegrityViolationException e){
            throw new UserAlreadyExistsException("Você está tentando inserir dados repetidos" );
        }

    }
    public List<UserDTO> findAll(){
        return ModelMapperConverter.parseListObjects(repository.findAll(),UserDTO.class);
    }
    public UserDTO findByCPF(String cpf) {
        User user = repository.findByCpf(cpf);
        if(user!=null){
            return ModelMapperConverter.parseObject(user,UserDTO.class);
        }
       throw  new UserNotFoundException("Usuario Não Encontrado");
    }

    public List<UserDTO> findByName(String name){
        List<User> entity = repository.findUserByName(name);
        if(entity != null){
            return ModelMapperConverter.parseListObjects(entity, UserDTO.class);
        }
       throw  new UserNotFoundException("Usuario Não Encontrado");

    }

    public String updateUserByCpf(UserDTO userDTO){
        User entity = repository.findByCpf(userDTO.getCpf());
        if(entity != null){
            User newUser = new User(userDTO,entity);
            repository.save(newUser);
            return  newUser.getName() + " seu cadastro foi atualizado";
        }
        throw  new UserNotFoundException("Usuario não econtrado");
    }

    @Transactional
    public String disableUserByCpf(String cpf){
        final User entity = repository.findByCpf(cpf);
        if(entity != null) {
            repository.disableUser(cpf);
            return "Usuario Desabilitado";
        }
        throw  new UserNotFoundException("usuario Não Encontrado");
    }

    @Transactional
    public String enableUserByCpf(String cpf){
        final User entity = repository.findByCpf(cpf);
        if(entity != null){
            repository.enableUser(cpf);
            return "Usuario Habilitado";
        }
            throw  new UserNotFoundException("usuario Não Encontrado");
    }


}
