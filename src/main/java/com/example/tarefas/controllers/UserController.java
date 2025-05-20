package com.example.tarefas.controllers;

import com.example.tarefas.dtos.UpdateUserDTO;
import com.example.tarefas.dtos.UpdateUserPasswordDTO;
import com.example.tarefas.dtos.UpdateUserRoleDTO;
import com.example.tarefas.entities.Users;
import com.example.tarefas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody UpdateUserDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PatchMapping("/update-password/{id}")
    public ResponseEntity<Users> updatePassword(@PathVariable Long id, @RequestBody UpdateUserPasswordDTO dto){
        return ResponseEntity.ok(service.updatePassword(id, dto));
    }

    @PatchMapping("/update-role/{id}")
    public ResponseEntity<Users> updateRole(@PathVariable Long id, @RequestBody UpdateUserRoleDTO dto){
        return ResponseEntity.ok(service.updateRole(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
