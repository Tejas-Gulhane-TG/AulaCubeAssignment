package com.example.AulaCubeAssignment.Transformer;

import com.example.AulaCubeAssignment.DTO.RequestDto.UserRequestDto;
import com.example.AulaCubeAssignment.DTO.ResponseDto.UserResponseDto;
import com.example.AulaCubeAssignment.Model.User;
import com.example.AulaCubeAssignment.Security.Config;

public class UserTransformer {

    public static User DtoToUserTransformer(UserRequestDto userRequestDto){
        return User.builder()
                .name(userRequestDto.getName())
                .emailId(userRequestDto.getEmailId())
                .mobileNo(userRequestDto.getMobileNo())
                .build();
    }

    public static UserResponseDto UserToResponseDto(User user){
        return UserResponseDto.builder()
                .emailId(user.getEmailId())
                .mobileNo(user.getMobileNo())
                .name(user.getName())
                .build();
    }
}
