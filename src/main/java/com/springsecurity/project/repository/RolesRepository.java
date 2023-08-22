package com.springsecurity.project.repository;

import com.springsecurity.project.model.Roles;
import com.springsecurity.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Set<Roles> findByUser(User user);
}
