package com.example.tarefas.dtos;

import com.example.tarefas.enums.Status;
import lombok.Data;

@Data
public class TaskDTO {
    private String titulo;
    private String descricao;
    private Status status;
}
