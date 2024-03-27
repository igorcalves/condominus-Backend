package br.com.condominus.Condominus.services;

import br.com.condominus.Condominus.domain.dto.ReservationReturn;
import br.com.condominus.Condominus.domain.rules.reservationRules.Reservations;
import br.com.condominus.Condominus.exceptions.exceptionModel.InvalidTimeForSchedule;
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

    @Autowired
    Reservations validationsSchedule;


    public String createReservation(UserReservationAreaDTO data){
        Areas area = areasRepository.findById(data.areaId()).orElseThrow(()-> new ResourceNotFound("o id da area não existe"));

        boolean can = validationsSchedule.canYouScheduleOpenClose(data.startOfScheduling().toLocalTime(),data.endOfScheduling().toLocalTime(),area.getOpeningTime(), area.getClosingTime());
        if(can){
            List<UserReservationsAreas> reservationsDone = reservationRepository.findReservationsByYearMouthAndDay(
                    data.startOfScheduling().getYear(),data.startOfScheduling().getMonthValue(),data.startOfScheduling().getDayOfMonth());
            for(UserReservationsAreas reservation: reservationsDone){

            }

        }
        else{
            throw new InvalidTimeForSchedule("O horario de " + data.startOfScheduling().toLocalTime() +
                    " as " + data.endOfScheduling().toLocalTime() + " é invalido " +
                    "para agendar o local " + area.getName() + " os horários disponiveis são das " + area.getOpeningTime()  + " as " + area.getClosingTime());
        }

        User entity = userRepository.findByCpf(data.cpf()).orElseThrow(()-> new ResourceNotFound("Cpf Não Cadastrado"));







        UserReservationsAreas reservation = new UserReservationsAreas(entity,area,data.startOfScheduling(),data.endOfScheduling());



        try{
            reservationRepository.save(reservation);
            
        }catch(Exception e){
             e.printStackTrace();
        }   
        return "Reserva Criada com Sucesso" + " A area: " + area.getName()
            + " esta agendado do horario " + data.startOfScheduling().toLocalTime()
            +" ate: " + data.endOfScheduling().toLocalTime()
            + " da data " + data.startOfScheduling().getDayOfMonth() + "/" + data.startOfScheduling().getMonthValue() + "/" + data.startOfScheduling().getYear()
            +" para " + entity.getName();

    }

    public List<ReservationReturn> findAllReservations(String cpf){
        User entity = userRepository.findByCpf(cpf).orElseThrow(()-> new ResourceNotFound("Cpf Não Cadastrado"));
        return reservationRepository.findAllReservationsById(entity.getId());
    }


    public List<UserReservationsAreas> t() {
        return reservationRepository.findReservationsByYearMouthAndDay(2024,3,27);
    }


}
