package br.com.condominus.Condominus.controllers;

import br.com.condominus.Condominus.domain.dto.CpfDTO;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.services.UserService;
import jakarta.validation.Valid;
import br.com.condominus.Condominus.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid User user){

    return ResponseEntity.ok().body(service.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUser(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/cpf")
    public ResponseEntity<?> findUserByCPF(@RequestParam String cpf){
        return  ResponseEntity.ok(service.findByCPF(cpf));
    }

    @GetMapping("/name")
    public ResponseEntity<List<UserDTO>> findUserByName(@RequestParam String name){
        return  ResponseEntity.ok(service.findByName(name));
    }
    @PutMapping("/disable")
            public ResponseEntity<String> disableUserByCpf(@RequestParam String cpf){
        return ResponseEntity.ok(service.disableUserByCpf(cpf));

    }

    @PutMapping("/enable")
    public ResponseEntity<String> enableUserByCpf(@RequestParam String cpf){
        return ResponseEntity.ok(service.enableUserByCpf(cpf));

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO data){
        return ResponseEntity.ok(service.updateUserByCpf(data));
    }

}
