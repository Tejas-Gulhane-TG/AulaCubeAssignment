package com.example.AulaCubeAssignment.Controller;

import com.example.AulaCubeAssignment.DTO.RequestDto.UserRequestDto;
import com.example.AulaCubeAssignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity RegisterUser(@RequestBody UserRequestDto userRequestDto){
        ResponseEntity responseEntity = userService.RegisterUser(userRequestDto);
        return responseEntity;
    }

    @GetMapping("/get/{emailId}/{password}")
    public ResponseEntity GetUser(@PathVariable String emailId, @PathVariable String password){
        ResponseEntity responseEntity = userService.GetUser(emailId, password);
        return responseEntity;
    }

    @PutMapping("/update/{emailId}/{password}")
    public ResponseEntity UpdateUser(@PathVariable String emailId, @PathVariable String password, @RequestBody UserRequestDto userRequestDto){
        ResponseEntity responseEntity = userService.UpdateUser(emailId, password, userRequestDto);
        return responseEntity;
    }

    @DeleteMapping("/delete/{emailId}/{password}")
    public ResponseEntity DeleteUser(@PathVariable String emailId, @PathVariable String password){
        ResponseEntity responseEntity = userService.DeleteUser(emailId, password);
        return responseEntity;
    }


//    admin all endpoints

    @GetMapping("/admin/get-all-users/{emailId}/{password}")
    public ResponseEntity GetAllUser(@PathVariable String emailId, @PathVariable String password){
        ResponseEntity responseEntity = userService.GetAllUser(emailId, password);
        return responseEntity;
    }

    @GetMapping("/admin/get-user-by-emailId/{emailId}/{password}/{userEmail}")
    public ResponseEntity GetUserByEmailId(@PathVariable String emailId, @PathVariable String password, @PathVariable String userEmail ){
        ResponseEntity responseEntity = userService.GetUserByEmailID(emailId, password, userEmail);
        return responseEntity;
    }

    @DeleteMapping("/admin/delete-by-emailId/{emailId}/{password}/{userEmail}")
    public ResponseEntity DeleteByEmail(@PathVariable String emailId, @PathVariable String password, @PathVariable String userEmail ){
        ResponseEntity responseEntity = userService.DeleteByEmail(emailId, password, userEmail);
        return responseEntity;
    }

    @DeleteMapping("/admin/delete-all-user/{emailId}/{password}")
    public ResponseEntity DeleteAllUser(@PathVariable String emailId, @PathVariable String password){
        ResponseEntity responseEntity = userService.DeleteAllUser(emailId, password);
        return responseEntity;
    }



}
