package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.model.Tenant;
import com.naisaas.tenant_service.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

//public interface UserRepository extends JpaRepository <User , Integer> {
public interface UserRepository extends MongoRepository<User, String> {
    // For authentication
    Optional<User> findByUserName(String username);

    Optional<User> findByEmail(String email);

    // List all users under a tenant
    List<User> findByTenant(Tenant tenant);

    // Check existence
    boolean existsByUserName(String username);

    boolean existsByEmail(String email);
}
