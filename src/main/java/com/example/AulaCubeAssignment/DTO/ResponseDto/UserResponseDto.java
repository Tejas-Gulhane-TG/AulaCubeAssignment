package com.example.AulaCubeAssignment.DTO.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    String name;

    long mobileNo;

    String emailId;

}
