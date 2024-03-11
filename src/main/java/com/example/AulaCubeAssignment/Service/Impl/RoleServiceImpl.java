package com.example.AulaCubeAssignment.Service.Impl;

import com.example.AulaCubeAssignment.Enum.UserRole;
import com.example.AulaCubeAssignment.Model.Role;
import com.example.AulaCubeAssignment.Model.User;
import com.example.AulaCubeAssignment.Repository.RoleRepository;
import com.example.AulaCubeAssignment.Repository.UserRepository;
import com.example.AulaCubeAssignment.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity AddRole(String emailId, UserRole userRole ) {
        User user = userRepository.findByEmailId(emailId);
        Role role1 = roleRepository.findByUserId(user.getId());
        if(role1!=null){
            return new ResponseEntity<>("User has already defined role : "+role1.getUserRole(), HttpStatus.NOT_ACCEPTABLE);
        }
        if(user != null){
            if(userRole == UserRole.USER){
                Role role = Role.builder()
                        .userRole(userRole)
                        .user(user)
                        .build();
                roleRepository.save(role);
                return new ResponseEntity<>("User role Added", HttpStatus.CREATED);
            }
            if(userRole == UserRole.ADMIN){
                Role role = Role.builder()
                        .userRole(userRole)
                        .user(user)
                        .build();
                roleRepository.save(role);
                return new ResponseEntity<>("Admin role Added", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Role not Found Check the Role", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }
}
