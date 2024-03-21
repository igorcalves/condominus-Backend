package br.com.condominus.Condominus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.dto.VisitorsDTO;
import br.com.condominus.Condominus.exceptions.exceptionModel.UserNotFoundException;
import br.com.condominus.Condominus.repositories.UserRepository;
import br.com.condominus.Condominus.repositories.VisitorsRepository;

@Service
public class VisitorsService {


    @Autowired
    private VisitorsRepository visitorsrepository;

    

    @Autowired
    private UserRepository userRepository;

    
    public List<VisitorsDTO> findAllUsers(String userCpf){
        User user = userRepository.findByCpf(userCpf);

        if(user!=null){
            return visitorsrepository.findAllVisitors(user.getId());
        }
        throw new UserNotFoundException("usuario Não encontrado");
    }
 

    
}
