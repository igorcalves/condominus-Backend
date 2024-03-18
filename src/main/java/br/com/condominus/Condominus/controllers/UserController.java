package br.com.condominus.Condominus.controllers;

import br.com.condominus.Condominus.UserService;
import br.com.condominus.Condominus.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<String> createUser(@RequestBody  User user){

    return ResponseEntity.ok().body(service.createUser(user));
    }


}
