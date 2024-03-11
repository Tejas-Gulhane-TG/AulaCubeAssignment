package com.example.AulaCubeAssignment.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    long mobileNo;

    @Column(unique = true, nullable = false)
    String emailId;

    @Column(nullable = false)
    String password;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Role role;
}
