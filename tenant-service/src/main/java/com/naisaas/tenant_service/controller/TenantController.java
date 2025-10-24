package com.naisaas.tenant_service.controller;

import com.naisaas.tenant_service.dto.CreateTenantRequestDTO;
import com.naisaas.tenant_service.dto.ResponseTenantRequestDTO;
import com.naisaas.tenant_service.mapper.TenantMapper;
import com.naisaas.tenant_service.model.Tenant;
import com.naisaas.tenant_service.model.TenantStatistics;
import com.naisaas.tenant_service.service.TenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired
    private TenantServiceImpl tenantService;

    // Create a new tenant
    @PostMapping
    public ResponseEntity<ResponseTenantRequestDTO> createTenant(
            @RequestBody CreateTenantRequestDTO requestDTO) {

        ResponseTenantRequestDTO responseDTO = tenantService.createTenant(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    // Get all tenants
    @GetMapping
    public ResponseEntity<List<ResponseTenantRequestDTO>> getAllTenants() {
        return ResponseEntity.ok(tenantService.getAllTenants());
    }
    // Get tenant by tenantKey
    @GetMapping("/{tenantKey}")
    public ResponseEntity<ResponseTenantRequestDTO> getTenantByKey(@PathVariable String tenantKey) {
        return ResponseEntity.ok(tenantService.getTenantByKey(tenantKey));
    }
    // Deactivate tenant
    @PutMapping("/deactivate/{tenantKey}")
    public ResponseEntity<ResponseTenantRequestDTO> deactivateTenant(@PathVariable String tenantKey) {
        Tenant tenant = tenantService.deactivateTenant(tenantKey);
        return ResponseEntity.ok(TenantMapper.toResponseDTO(tenant));
    }

    //Get tenant statistics
    @GetMapping("/statistics")
    public ResponseEntity<TenantStatistics> getTenantStatistics() {
        TenantStatistics statistics = tenantService.getTenantStatistics();
        return ResponseEntity.ok(statistics);
    }
}



//    // Create a new tenant
//    @PostMapping
//    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
//        Tenant createdTenant = tenantService.createTenant(tenant);
//        return ResponseEntity.ok(createdTenant);
//    }

    // Get all tenants
//    @GetMapping
//    public ResponseEntity<List<Tenant>> getAllTenants() {
//        List<Tenant> tenants = tenantService.getAllTenants();
//        return ResponseEntity.ok(tenants);
//    }

//    // Get tenant by tenantKey
//    @GetMapping("/{tenantKey}")
//    public ResponseEntity<Tenant> getTenantByKey(@PathVariable String tenantKey) {
//        Tenant tenant = tenantService.getTenantByKey(tenantKey);
//        return ResponseEntity.ok(tenant);
//    }

    // Deactivate tenant
    // Don’t want to delete their data, because historical data (users, projects, HR records) should be preserved.
//    @PutMapping("/deactivate/{tenantKey}")
//    public ResponseEntity<String> deactivateTenant(@PathVariable String tenantKey) {
//        tenantService.deactivateTenant(tenantKey);
//        return new ResponseEntity<>("Tenant Deactivated", HttpStatus.OK);
//    }

    // Get tenant statistics
//    @GetMapping("/statistics")
//    public ResponseEntity<TenantStatistics> getTenantStatistics() {
//        TenantStatistics statistics = tenantService.getTenantStatistics();
//        return ResponseEntity.ok(statistics);
//    }
//}