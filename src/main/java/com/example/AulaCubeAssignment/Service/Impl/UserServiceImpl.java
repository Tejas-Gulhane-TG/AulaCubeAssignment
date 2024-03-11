package com.example.AulaCubeAssignment.Service.Impl;

import com.example.AulaCubeAssignment.DTO.RequestDto.UserRequestDto;
import com.example.AulaCubeAssignment.DTO.ResponseDto.UserResponseDto;
import com.example.AulaCubeAssignment.Enum.UserRole;
import com.example.AulaCubeAssignment.Model.User;
import com.example.AulaCubeAssignment.Repository.UserRepository;
import com.example.AulaCubeAssignment.Security.Config;
import com.example.AulaCubeAssignment.Service.UserService;
import com.example.AulaCubeAssignment.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity RegisterUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByEmailId(userRequestDto.getEmailId());
        if(user != null){
            return new ResponseEntity<>("Email Id Already Register", HttpStatus.NOT_ACCEPTABLE);
        }
        User user1 = userRepository.findByMobileNo(userRequestDto.getMobileNo());
        if(user1 != null){
            return new ResponseEntity<>("Mobile No Already Register", HttpStatus.NOT_ACCEPTABLE);
        }
        User user2 = UserTransformer.DtoToUserTransformer(userRequestDto);
        user2.setPassword(Config.encode(userRequestDto.getPassword()));
        userRepository.save(user2);
        UserResponseDto userResponseDto = UserTransformer.UserToResponseDto(user2);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity GetUser(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                UserResponseDto userResponseDto = UserTransformer.UserToResponseDto(user);
                return new ResponseEntity<>(userResponseDto, HttpStatus.ACCEPTED);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Email Id Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity UpdateUser(String emailId, String password, UserRequestDto userRequestDto) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                if(userRequestDto.getEmailId() != null) {
                    user.setEmailId(userRequestDto.getEmailId());
                }
                if(userRequestDto.getName() != null){
                    user.setName(userRequestDto.getName());
                }
                if(userRequestDto.getMobileNo() > 0){
                    user.setMobileNo(userRequestDto.getMobileNo());
                }
                userRepository.save(user);
                UserResponseDto userResponseDto = UserTransformer.UserToResponseDto(user);
                return new ResponseEntity<>(userResponseDto, HttpStatus.ACCEPTED);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Email Id Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity DeleteUser(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                userRepository.delete(user);
                return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Email Id Not Found", HttpStatus.NOT_FOUND);
    }


    //Admin Service Implementations
    @Override
    public ResponseEntity GetAllUser(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                if(UserRole.ADMIN == user.getRole().getUserRole()){
                    List<User> userList = userRepository.findAll();
                    List<String> NameList = new ArrayList<>();
                    for(int i=0; i<userList.size(); i++){
                        User user1 = userList.get(i);
                        NameList.add("ID: "+user1.getId()+", Name: "+user1.getName()+", EmailId: "+user1.getEmailId());
                    }
                    return new ResponseEntity<>(NameList, HttpStatus.OK);
                }
                return new ResponseEntity<>("Only ADMIN user can Access the data ", HttpStatus.NOT_ACCEPTABLE);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity DeleteByEmail(String emailId, String password, String userEmail) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                if(UserRole.ADMIN == user.getRole().getUserRole()){
                    User user1 = userRepository.findByEmailId(userEmail);
                    if(user1 != null){
                        userRepository.delete(user1);
                        return new ResponseEntity<>("User delete Success by Admin", HttpStatus.ACCEPTED);
                    }
                    return new ResponseEntity<>("User not Found", HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>("Only ADMIN user can Access the data ", HttpStatus.NOT_ACCEPTABLE);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Admin Id Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity GetUserByEmailID(String emailId, String password, String userEmail) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                if(UserRole.ADMIN == user.getRole().getUserRole()){
                    User user1 = userRepository.findByEmailId(userEmail);
                    if(user1 != null){
                        return new ResponseEntity<>(UserTransformer.UserToResponseDto(user1), HttpStatus.ACCEPTED);
                    }
                    return new ResponseEntity<>("User not Found", HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>("Only ADMIN user can Access the data ", HttpStatus.NOT_ACCEPTABLE);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity DeleteAllUser(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                if(UserRole.ADMIN == user.getRole().getUserRole()){
                    userRepository.deleteAll();
                    return new ResponseEntity<>("All user deleted by Admin", HttpStatus.ACCEPTED);
                }
                return new ResponseEntity<>("Only ADMIN user can Access the data ", HttpStatus.NOT_ACCEPTABLE);
            }
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
    }
}
