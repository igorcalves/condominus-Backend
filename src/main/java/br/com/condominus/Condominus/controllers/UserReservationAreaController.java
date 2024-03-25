package br.com.condominus.Condominus.controllers;

import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.ReservationReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.condominus.Condominus.domain.dto.UserReservationAreaDTO;
import br.com.condominus.Condominus.services.UserReservationAreaService;

import java.util.List;

@Controller
@RequestMapping("reservations")
public class UserReservationAreaController {

    @Autowired
    UserReservationAreaService service;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody UserReservationAreaDTO data){
        return ResponseEntity.ok(service.createReservation(data));
    }

    @GetMapping
    public ResponseEntity<List<ReservationReturn>> findAll(@RequestBody CpfDTO data){
        return ResponseEntity.ok(service.findAllReservations(data.cpf()));
    }
    
}
