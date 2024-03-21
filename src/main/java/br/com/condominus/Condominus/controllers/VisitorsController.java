package br.com.condominus.Condominus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.VisitorsDTO;
import br.com.condominus.Condominus.services.VisitorsService;

@RestController
@RequestMapping("user/visitors")
public class VisitorsController {

    @Autowired
    private VisitorsService service;

    @GetMapping
    public ResponseEntity<List<VisitorsDTO>> findAllVisitors(@RequestBody CpfDTO data){
       return  ResponseEntity.ok(service.findAllUsers(data.cpf()));
    }
    
}
