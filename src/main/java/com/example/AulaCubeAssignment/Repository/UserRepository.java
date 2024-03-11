package com.example.AulaCubeAssignment.Repository;

import com.example.AulaCubeAssignment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(String emailId);
    User findByMobileNo(long mobileNo);
    User findById(long id);
}
