package com.example.tarefas.services;

import com.example.tarefas.dtos.UpdateUserDTO;
import com.example.tarefas.dtos.UpdateUserPasswordDTO;
import com.example.tarefas.dtos.UpdateUserRoleDTO;
import com.example.tarefas.entities.Users;
import com.example.tarefas.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Users create(Users user){
        return repository.save(user);
    }

    public Users findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public List<Users> findAll(){
        return repository.findAll();
    }

    public Users update(Long id, UpdateUserDTO dto){
        Users user = this.findById(id);
        modelMapper.map(dto, user);
        return repository.save(user);
    }

    public Users updatePassword(Long id, UpdateUserPasswordDTO dto){
        Users user = this.findById(id);
        modelMapper.map(dto, user);
        return repository.save(user);
    }

    public Users updateRole(Long id, UpdateUserRoleDTO dto){
        Users user = this.findById(id);
        modelMapper.map(dto, user);
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
