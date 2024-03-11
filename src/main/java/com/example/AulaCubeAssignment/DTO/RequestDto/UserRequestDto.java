package com.example.AulaCubeAssignment.DTO.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;

    long mobileNo;

    String password;

    String emailId;
}
