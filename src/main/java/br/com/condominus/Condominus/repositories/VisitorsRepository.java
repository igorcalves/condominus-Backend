package br.com.condominus.Condominus.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.condominus.Condominus.domain.Visitors;
import br.com.condominus.Condominus.domain.dto.VisitorsDTO;

@Repository
public interface VisitorsRepository extends JpaRepository<Visitors,String> {

    Visitors findByCpf(String cpf);

    @Query(value = "SELECT v FROM Visitors v WHERE user.id =:id ")
    List<Visitors> findAllVisitors(@Param("id") String id);


    @Query("SELECT v FROM Visitors v WHERE LOWER(v.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Visitors> findVisitorsByName(@Param("name") String name);
}

