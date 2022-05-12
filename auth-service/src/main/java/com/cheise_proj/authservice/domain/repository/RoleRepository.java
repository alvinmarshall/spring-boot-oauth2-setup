package com.cheise_proj.authservice.domain.repository;

import com.cheise_proj.authservice.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
