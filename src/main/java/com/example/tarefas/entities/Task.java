package com.example.tarefas.entities;

import com.example.tarefas.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tasks")
@Data
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String titulo;
    private String descricao;

    @Enumerated(value = EnumType.STRING)
    private Status status;

}
