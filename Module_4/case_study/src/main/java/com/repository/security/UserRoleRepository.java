package com.repository.security;

import com.model.security.AppUser;
import com.model.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
List<UserRole> findByAppUser(AppUser user);
}
