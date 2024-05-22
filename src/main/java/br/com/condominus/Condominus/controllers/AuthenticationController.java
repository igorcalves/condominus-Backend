package br.com.condominus.Condominus.controllers;

import br.com.condominus.Condominus.configurations.security.TokenService;
import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.dto.AuthenticationDTO;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.mapper.ModelMapperConverter;
import br.com.condominus.Condominus.repositories.UserRepository;
import br.com.condominus.Condominus.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var auth = authenticationManager.authenticate(userNamePassword);

        User loggedInUser = (User) auth.getPrincipal();

        var token = tokenService.generatedToken((User) auth.getPrincipal());
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(ModelMapperConverter.parseObject(loggedInUser, UserDTO.class));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid User data){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(data));
    }



}
