package com.repository.security;

import com.model.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String appUserName);
}
