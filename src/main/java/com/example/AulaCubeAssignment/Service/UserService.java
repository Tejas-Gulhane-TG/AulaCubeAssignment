package com.example.AulaCubeAssignment.Service;

import com.example.AulaCubeAssignment.DTO.RequestDto.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity RegisterUser(UserRequestDto userRequestDto);

    ResponseEntity GetUser(String emailId, String password);

    ResponseEntity UpdateUser(String emailId, String password, UserRequestDto userRequestDto);

    ResponseEntity DeleteUser(String emailId, String password);



    //Admin Service Endpoint Method
    ResponseEntity GetAllUser(String emailId, String password);

    ResponseEntity DeleteByEmail(String emailId, String password, String userEmail);

    ResponseEntity GetUserByEmailID(String emailId, String password, String userEmail);

    ResponseEntity DeleteAllUser(String emailId, String password);

}
