package br.com.condominus.Condominus.services;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.core.regex.ValidationsRegex;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.exceptions.exceptionModel.UserAlreadyExistsException;
import br.com.condominus.Condominus.exceptions.exceptionModel.ResourceNotFound;
import br.com.condominus.Condominus.mapper.ModelMapperConverter;
import br.com.condominus.Condominus.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {



    @Autowired
    private UserRepository repository;
    public String createUser(User user){
        try {
                String encryptPassword = new BCryptPasswordEncoder().encode(user.getPassword());
                user.setPassword(encryptPassword);
                repository.save(user);
                return "Usuario Criado com sucesso";


        }catch (DataIntegrityViolationException e){
            throw new UserAlreadyExistsException("Você está tentando inserir dados repetidos ");
        }

    }
    public List<UserDTO> findAll(){
        return ModelMapperConverter.parseListObjects(repository.findAllEnabledUSer(),UserDTO.class);
    }



    public UserDTO findByCPF(String cpf) {
            final User entity = repository.findByCpf(cpf).orElseThrow(()-> new ResourceNotFound("Usuario não econtrado"));
            return ModelMapperConverter.parseObject(entity,UserDTO.class);
    }

    public List<UserDTO> findByName(String name){
        final List<User> entity = repository.findUserByName(name);
        if(entity != null){
            return ModelMapperConverter.parseListObjects(entity, UserDTO.class);
        }
       throw  new ResourceNotFound("Usuario Não Encontrado");

    }

    public String updateUserByCpf(UserDTO userDTO){
            User entity = repository.findByCpf(userDTO.getCpf()).orElseThrow(()-> new ResourceNotFound("Usuario não econtrado"));
            User newUser = new User(userDTO,entity);
            repository.save(newUser);
            return  newUser.getName() + " seu cadastro foi atualizado";

    }

    @Transactional
    public String disableUserByCpf(String cpf){
        repository.findByCpf(cpf).orElseThrow(()-> new ResourceNotFound("Usuario não econtrado"));
        repository.disableUser(cpf);
        return "Usuario Desabilitado";
    }

    @Transactional
    public String enableUserByCpf(String cpf){
        User entity = repository.findByCpf(cpf).orElseThrow(()-> new ResourceNotFound("Usuario não econtrado"));
        repository.enableUser(cpf);
        return "Usuario Habilitado";

    }


}
