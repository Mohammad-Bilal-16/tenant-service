package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.entity.Role;
import com.naisaas.tenant_service.entity.RoleType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    // Find role by enum
    Optional<Role> findByName(RoleType name);

    boolean existsByName(RoleType name);

}
