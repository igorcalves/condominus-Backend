package br.com.condominus.Condominus.controllers;

import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.ReservationReturn;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.condominus.Condominus.domain.dto.UserReservationAreaDTO;
import br.com.condominus.Condominus.services.UserReservationAreaService;

import java.util.List;

@Controller
@RequestMapping("reservations")
public class UserReservationAreaController {

    @Autowired
    UserReservationAreaService service;

    @Operation(summary = "create reservation")
    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody UserReservationAreaDTO data){
        return ResponseEntity.ok(service.createReservation(data));
    }
    @Operation(summary = "Get all reservations for a user by cpf via RequestParam")
    @GetMapping
    public ResponseEntity<List<ReservationReturn>> findAll(@RequestParam String cpf){
        return ResponseEntity.ok(service.findAllReservations(cpf));
    }
    
}
