package br.com.condominus.Condominus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.VisitorsDTO;
import br.com.condominus.Condominus.services.VisitorsService;

@RestController
@RequestMapping("users/visitors")
public class VisitorsController {

    @Autowired
    private VisitorsService service;

    @PostMapping
    public ResponseEntity<String> createVisitorByCpfUser(@RequestBody VisitorsDTO data){
        return ResponseEntity.ok(service.createVisitorByCpfUser(data));
        
    }
    

    @GetMapping("/cpfuser")
    public ResponseEntity<List<VisitorsDTO>> findAllVisitorsByCpfUser(@RequestParam String cpf){
       return  ResponseEntity.ok(service.findAllVisitorsByCpfUser(cpf));
    }

    @GetMapping("/name")
    public ResponseEntity<List<VisitorsDTO>> findVisistorsByName(@RequestParam String name){
       return  ResponseEntity.ok(service.findVisitorByName(name));
    }

    @PutMapping()
    public ResponseEntity<String> updateVisitorByCpf(@RequestBody VisitorsDTO data){
        return ResponseEntity.ok(service.updateVisitorByCpf(data));

    }


    @DeleteMapping()
    public ResponseEntity<String> deleteVisitorById(@RequestParam String  data){
        return ResponseEntity.ok(service.deleteVisitorByCpf(data));
    }
    
}
