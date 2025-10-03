package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant , Integer> {
    // Find tenant by unique key (used in JWT / subdomain parsing)
    Optional<Tenant> findByTenantKey(String tenantKey);

    // Optional: Find tenant by name
    Optional<Tenant> findByTenantName(String tenantName);

    //TODO:
    //OpenSearch DB

}
