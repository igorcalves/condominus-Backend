package br.com.condominus.Condominus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.condominus.Condominus.domain.dto.UserReservationAreaDTO;
import br.com.condominus.Condominus.services.UserReservationAreaService;

@Controller
@RequestMapping("reservations")
public class UserReservationAreaController {

    @Autowired
    UserReservationAreaService service;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody UserReservationAreaDTO data){
        return ResponseEntity.ok(service.createReservation(data));
    }
    
}
