package com.example.tarefas.controllers;

import com.example.tarefas.dtos.AuthRequestDTO;
import com.example.tarefas.dtos.AuthResponseDTO;
import com.example.tarefas.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto){
        return ResponseEntity.ok(service.login(dto));
    }


}
