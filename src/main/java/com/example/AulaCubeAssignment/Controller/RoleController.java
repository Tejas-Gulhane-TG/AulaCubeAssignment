package com.example.AulaCubeAssignment.Controller;

import com.example.AulaCubeAssignment.Enum.UserRole;
import com.example.AulaCubeAssignment.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/add/{emailId}/{userRole}")
    public ResponseEntity AddRole(@PathVariable String emailId, @PathVariable UserRole userRole){
        ResponseEntity responseEntity = roleService.AddRole(emailId, userRole);
        return responseEntity;
    }

}
