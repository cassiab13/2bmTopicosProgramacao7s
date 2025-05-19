package com.example.tarefas.controllers;

import com.example.tarefas.dtos.UpdateUserDTO;
import com.example.tarefas.dtos.UpdateUserPasswordDTO;
import com.example.tarefas.dtos.UpdateUserRoleDTO;
import com.example.tarefas.entities.Users;
import com.example.tarefas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public Users create(@RequestBody Users user){
        return service.create(user);
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Users> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Users update(@PathVariable Long id, @RequestBody UpdateUserDTO dto){
        return service.update(id, dto);
    }

    @PatchMapping("/update-password/{id}")
    public Users updatePassword(@PathVariable Long id, @RequestBody UpdateUserPasswordDTO dto){
        return service.updatePassword(id, dto);
    }

    @PatchMapping("/update-role/{id}")
    public Users updateRole(@PathVariable Long id, @RequestBody UpdateUserRoleDTO dto){
        return service.updateRole(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
