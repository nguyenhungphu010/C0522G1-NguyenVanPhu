package com.repository;

import com.model.AppUser;
import com.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser (AppUser appUser);
}
