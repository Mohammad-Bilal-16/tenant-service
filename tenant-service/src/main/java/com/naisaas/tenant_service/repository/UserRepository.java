package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.entity.Tenant;
import com.naisaas.tenant_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User , Integer> {
/*    // For authentication
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    // List all users under a tenant
    List<User> findByTenant(Tenant tenant);

    // Check existence
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);*/
}
