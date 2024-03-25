package br.com.condominus.Condominus.repositories;


import br.com.condominus.Condominus.domain.dto.ReservationReturn;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominus.Condominus.domain.UserReservationsAreas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReservationsAreasRespository extends JpaRepository<UserReservationsAreas,String>{



    @Query(value = "SELECT new br.com.condominus.Condominus.domain.dto.ReservationReturn(u.name,u.cpf,r.name,ur.startOfScheduling,ur.endOfScheduling) FROM UserReservationsAreas ur INNER JOIN User u ON ur.user.id = u.id INNER  JOIN Areas r ON ur.area.id = r.id WHERE ur.user.id =:id")
    List<ReservationReturn> findAllReservationsById(@Param("id") String id);

    
}