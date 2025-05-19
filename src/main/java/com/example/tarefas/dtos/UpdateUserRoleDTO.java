package com.example.tarefas.dtos;

import com.example.tarefas.enums.Role;
import lombok.Data;

@Data
public class UpdateUserRoleDTO {
    private Role role;
}
