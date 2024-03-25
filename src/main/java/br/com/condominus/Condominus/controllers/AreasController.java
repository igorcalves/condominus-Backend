package br.com.condominus.Condominus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominus.Condominus.domain.Areas;
import br.com.condominus.Condominus.services.AreasService;

@RestController
@RequestMapping("areas")
public class AreasController {

    @Autowired
    private AreasService service;
    

    @GetMapping
    public ResponseEntity<List<Areas>> findAllAreas(){
        return ResponseEntity.ok(service.findAllAreas());

    }

    
    
}
