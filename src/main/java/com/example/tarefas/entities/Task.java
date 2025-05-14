package com.example.tarefas.entities;

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
    private Enumerated status;

}
