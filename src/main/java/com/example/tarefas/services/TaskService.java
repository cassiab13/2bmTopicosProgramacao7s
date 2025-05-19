package com.example.tarefas.services;

import com.example.tarefas.dtos.*;
import com.example.tarefas.entities.Task;
import com.example.tarefas.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskResponseDTO create(TaskDTO dto){
        Task task = modelMapper.map(dto, Task.class);
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
        modelMapper.map(dto, task);
        return modelMapper.map(repository.save(task), TaskResponseDTO.class);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }

}
