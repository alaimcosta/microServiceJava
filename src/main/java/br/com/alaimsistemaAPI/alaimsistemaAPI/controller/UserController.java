package br.com.alaimsistemaAPI.alaimsistemaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMensagem(){
        return "Trabalhando com Spring boot ";
    }



}
