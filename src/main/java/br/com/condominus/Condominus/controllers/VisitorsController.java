package br.com.condominus.Condominus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<String> createVisitorByCpfUser(@RequestBody VisitorsDTO data){
        return ResponseEntity.ok(service.createVisitorByCpfUser(data));
    }
    

    @GetMapping
    public ResponseEntity<List<VisitorsDTO>> findAllVisitorsByCpfUser(@RequestBody CpfDTO data){
       return  ResponseEntity.ok(service.findAllVisitorsByCpfUser(data.cpf()));
    }

     
    


    @DeleteMapping
    public ResponseEntity<String> deleteVisitorById(@RequestBody CpfDTO data){
        return ResponseEntity.ok(service.deleteVisitorByCpf(data.cpf()));
    }
    
}
