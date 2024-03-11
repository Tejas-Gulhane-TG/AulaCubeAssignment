package com.example.AulaCubeAssignment.Model;

import com.example.AulaCubeAssignment.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Enumerated (EnumType.STRING)
    UserRole userRole;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
