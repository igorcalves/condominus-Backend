package br.com.condominus.Condominus;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;


    public String createUser(User user){
        try {
            repository.save(user);
        }catch (Exception e){
            return "erro ao criar";
        }
        return "usuario criado com sucesso";
    }

}
