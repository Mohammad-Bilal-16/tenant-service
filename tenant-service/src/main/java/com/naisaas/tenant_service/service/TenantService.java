package com.naisaas.tenant_service.service;

import com.naisaas.tenant_service.entity.Tenant;
import com.naisaas.tenant_service.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    // Create a new tenant
    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    // Get all tenants
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    // Get tenant by key (used for subdomain/JWT context)
    public Tenant getTenantByKey(String tenantKey) {
        return tenantRepository.findByTenantKey(tenantKey)
                .orElseThrow(() -> new RuntimeException("Tenant not found: " + tenantKey));
    }
//
//    // Deactivate tenant
    public Tenant deactivateTenant(String tenantKey) {
        Tenant tenant = getTenantByKey(tenantKey);
        tenant.setActive(false);
        return tenantRepository.save(tenant);
    }

    public Tenant getTenantById(String tenantId) {
        return tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + tenantId));
    }
}



//    @Autowired
//    private TenantRepository tenantRepository;
//
//    public Tenant createTenant(Tenant tenant) {
//        return tenantRepository.save(tenant);
//    }
//
//    public List<Tenant> getAllTenants() {
//        return tenantRepository.findAll();
//    }
//
//    public Optional<Tenant> getTenantByName(String name) {
//        return tenantRepository.findByTenantName(name);
//    }
//}
