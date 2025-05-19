package com.example.tarefas.entities;

import com.example.tarefas.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
