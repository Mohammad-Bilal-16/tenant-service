package com.naisaas.tenant_service.repository;

import com.naisaas.tenant_service.entity.Tenant;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//public interface TenantRepository extends JpaRepository<Tenant , Integer> {
public interface TenantRepository extends MongoRepository<Tenant, String> {

    // Find tenant by unique key (used in JWT / subdomain parsing)
    Optional<Tenant> findByTenantKey(String tenantKey);

    // Optional: Find tenant by name
    Optional<Tenant> findByTenantName(String tenantName);

    //TODO:
    //OpenSearch DB

}
