package com.example.AulaCubeAssignment.Service;

import com.example.AulaCubeAssignment.Enum.UserRole;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity AddRole(String emailId, UserRole userRole);
}
