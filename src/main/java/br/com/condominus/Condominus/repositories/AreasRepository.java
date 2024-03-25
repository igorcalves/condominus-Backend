package br.com.condominus.Condominus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.condominus.Condominus.domain.Areas;


public interface AreasRepository extends JpaRepository<Areas,Integer>{
}
