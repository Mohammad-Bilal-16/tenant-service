package com.naisaas.tenant_service.controller;

import com.naisaas.tenant_service.entity.Tenant;
import com.naisaas.tenant_service.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired
    private TenantService tenantService;

    // Create a new tenant
    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        Tenant createdTenant = tenantService.createTenant(tenant);
        return ResponseEntity.ok(createdTenant);
    }

    // Get all tenants
    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    // Get tenant by tenantKey
    @GetMapping("/{tenantKey}")
    public ResponseEntity<Tenant> getTenantByKey(@PathVariable String tenantKey) {
        Tenant tenant = tenantService.getTenantByKey(tenantKey);
        return ResponseEntity.ok(tenant);
    }

    // Deactivate tenant
    // Don’t want to delete their data, because historical data (users, projects, HR records) should be preserved.
    @PutMapping("/deactivate/{tenantKey}")
    public ResponseEntity<String> deactivateTenant(@PathVariable String tenantKey) {
        tenantService.deactivateTenant(tenantKey);
        return new ResponseEntity<>("Tenant Deactivated", HttpStatus.OK);
    }
}