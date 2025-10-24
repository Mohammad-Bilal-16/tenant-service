package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface TenantRepository extends MongoRepository<Tenant, String> {

    // Find tenant by unique key (used in JWT / subdomain parsing)
    Optional<Tenant> findByTenantKey(String tenantKey);

    // Optional: Find tenant by name
    Optional<Tenant> findByTenantName(String tenantName);

    // Count tenants by status
    long countByStatus(String status);
}
