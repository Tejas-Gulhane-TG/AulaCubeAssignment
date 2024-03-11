package com.example.AulaCubeAssignment.Repository;

import com.example.AulaCubeAssignment.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUserId(long id);
}
