package com.repository;

import com.entity.AppUser;
import com.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser (AppUser appUser);
}
