package br.com.condominus.Condominus.services;

import br.com.condominus.Condominus.domain.dto.ReservationReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominus.Condominus.controllers.UserReservationAreaController;
import br.com.condominus.Condominus.domain.Areas;
import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.UserReservationsAreas;
import br.com.condominus.Condominus.domain.dto.UserReservationAreaDTO;
import br.com.condominus.Condominus.exceptions.exceptionModel.ResourceNotFound;
import br.com.condominus.Condominus.repositories.AreasRepository;
import br.com.condominus.Condominus.repositories.UserRepository;
import br.com.condominus.Condominus.repositories.UserReservationsAreasRespository;

import java.util.List;


@Service
public class UserReservationAreaService {

    @Autowired
    UserReservationsAreasRespository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AreasRepository areasRepository;


    public String createReservation(UserReservationAreaDTO data){
        User entity = userRepository.findByCpf(data.cpf());
        Areas area = areasRepository.findById(data.areaId()).orElseThrow(()-> new ResourceNotFound("o id da area não existe"));
        if(entity ==null) throw new ResourceNotFound("Cpf Não Encontrado");
        UserReservationsAreas reservation = new UserReservationsAreas(entity,area,data.startOfScheduling(),data.endOfScheduling());
        try{
            reservationRepository.save(reservation);
            
        }catch(Exception e){
             e.printStackTrace();
        }   
        return "Reserva Criada com Sucesso" + " A area: " + area.getName()
            + " esta agendado do horario " + data.startOfScheduling() 
            +" ate: " + data.endOfScheduling()
            +" para " + entity.getName();

    }

    public List<ReservationReturn> findAllReservations(String cpf){
        User entity = userRepository.findByCpf(cpf);
        if(entity ==null) throw new ResourceNotFound("Cpf Não Encontrado");
        return reservationRepository.findAllReservationsById(entity.getId());
    }

    
    
}
