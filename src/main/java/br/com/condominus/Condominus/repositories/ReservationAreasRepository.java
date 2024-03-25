package br.com.condominus.Condominus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.condominus.Condominus.domain.ReservationAreas;

@Repository
public interface ReservationAreasRepository extends JpaRepository<ReservationAreas,Integer>{
}
