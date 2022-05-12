package com.cheise_proj.authservice.domain.repository;

import com.cheise_proj.authservice.domain.model.AppClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<AppClient, String> {
    Optional<AppClient> findClientByClientId(String clientId);
}
