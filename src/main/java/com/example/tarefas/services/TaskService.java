package com.example.tarefas.services;

import com.example.tarefas.dtos.*;
import com.example.tarefas.entities.Task;
import com.example.tarefas.entities.Users;
import com.example.tarefas.repository.TaskRepository;
import com.example.tarefas.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskResponseDTO create(TaskDTO dto){
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        Task task = modelMapper.map(dto, Task.class);
        task.setUser(user);
        return modelMapper.map(repository.save(task), TaskResponseDTO.class);
    }

    public TaskResponseDTO findById(Long id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        return modelMapper.map(task, TaskResponseDTO.class);

    }

    public List<TaskResponseDTO> findAll(){
        return repository.findAll().stream()
                .map(task -> modelMapper.map(task, TaskResponseDTO.class))
                .toList();

    }

    public TaskResponseDTO update(Long id, TaskDTO dto){
        Task task = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        modelMapper.map(dto, task);
        task.setUser(user);
        return modelMapper.map(repository.save(task), TaskResponseDTO.class);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }

}
