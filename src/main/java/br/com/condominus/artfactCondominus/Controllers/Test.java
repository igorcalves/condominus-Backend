package br.com.condominus.artfactCondominus.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("test")
public class Test {

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("hello world");
    }
}
