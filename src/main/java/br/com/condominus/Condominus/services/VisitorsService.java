package br.com.condominus.Condominus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.Visitors;
import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.dto.VisitorsDTO;
import br.com.condominus.Condominus.exceptions.exceptionModel.EmailAlreadyExistsException;
import br.com.condominus.Condominus.exceptions.exceptionModel.UserAlreadyExistsException;
import br.com.condominus.Condominus.exceptions.exceptionModel.ResourceNotFound;
import br.com.condominus.Condominus.mapper.ModelMapperConverter;
import br.com.condominus.Condominus.repositories.UserRepository;
import br.com.condominus.Condominus.repositories.VisitorsRepository;

@Service
public class VisitorsService {


    @Autowired
    private VisitorsRepository visitorsrepository;


    @Autowired
    private UserRepository userRepository;

    public String createVisitorByCpfUser(VisitorsDTO data) {
        final User user = userRepository.findByCpf(data.getCpfUser()).orElseThrow(() -> new ResourceNotFound("Cpf Não encontrado"));

            Visitors entity = new Visitors(data, user);
            try {
                visitorsrepository.save(entity);
            } catch (DataIntegrityViolationException e) {
                throw new UserAlreadyExistsException("Visitante ja cadastrado");
            }
            return "Visitante Cadastrado";

    }


    
    public List<VisitorsDTO> findAllVisitorsByCpfUser(String userCpf){
        final User user = userRepository.findByCpf(userCpf).orElseThrow(() -> new ResourceNotFound("Cpf Não encontrado"));
        return ModelMapperConverter.parseListObjects(visitorsrepository.findAllVisitors(user.getId()), VisitorsDTO.class);
    }


    public String deleteVisitorByCpf(String cpf) {
        Visitors entity = visitorsrepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFound("O cpf não corresponde a nenhum visitante"));
        visitorsrepository.delete(entity);
        return "A pessoa " + entity.getName() + " não faz mais parte da lista de visitantes";
    }

    public List<VisitorsDTO> findVisitorByName(String name){
        List<Visitors> entity = visitorsrepository.findVisitorsByName(name);
        List<VisitorsDTO> data = ModelMapperConverter.parseListObjects(entity,VisitorsDTO.class);
        return data;
        
    }


    public String updateVisitorByCpf(VisitorsDTO data) {
        Visitors entity = visitorsrepository.findByCpf(data.getCpfUser()).orElseThrow(() -> new ResourceNotFound("O cpf não corresponde a nenhum visitante"));
        User user =userRepository.findByCpf(data.getCpfUser()).orElseThrow(() ->  new ResourceNotFound("Cpf Não encontrado"));
           try {
            Visitors newEntity = new Visitors(data, entity,user);
            visitorsrepository.save(newEntity);
            return newEntity.getName() + " seu cadastro foi atualizado";
           } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyExistsException("Você tentou cadastrar um email já existente");
           }
       
    }
 

    
}
