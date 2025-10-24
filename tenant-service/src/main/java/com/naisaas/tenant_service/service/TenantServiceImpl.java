package com.naisaas.tenant_service.service;

import com.naisaas.tenant_service.dto.CreateTenantRequestDTO;
import com.naisaas.tenant_service.dto.ResponseTenantRequestDTO;
import com.naisaas.tenant_service.mapper.TenantMapper;
import com.naisaas.tenant_service.model.Tenant;
import com.naisaas.tenant_service.model.TenantStatistics;
import com.naisaas.tenant_service.model.TenantStatus;
import com.naisaas.tenant_service.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    // Create a new tenant
    @Override
    public ResponseTenantRequestDTO createTenant(CreateTenantRequestDTO dto) {
        Tenant tenant = TenantMapper.toEntity(dto);

        // Set server-managed fields
        tenant.setStatus(TenantStatus.PENDING);
        tenant.setCreatedAt(LocalDateTime.now());
        tenant.setUpdatedAt(LocalDateTime.now());

//        if (tenant.getTenantKey() == null || tenant.getTenantKey().isEmpty()) {
//            tenant.setTenantKey(dto.getTenantName().trim().replaceAll("\\s+", "-").toLowerCase());
//        }
        Tenant savedTenant = tenantRepository.save(tenant);

        // Map Entity → Response DTO
        return TenantMapper.toResponseDTO(savedTenant);
    }

    // Get all tenants
    @Override
    public List<ResponseTenantRequestDTO> getAllTenants() {
        return tenantRepository.findAll()
                .stream()
                .map(TenantMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Get tenant by key (used for subdomain/JWT context)
    @Override
    public ResponseTenantRequestDTO getTenantByKey(String tenantKey) {
        Tenant tenant = tenantRepository.findByTenantKey(tenantKey)
                .orElseThrow(() -> new RuntimeException("Tenant not found with key: " + tenantKey));
        return TenantMapper.toResponseDTO(tenant);
    }

    // Deactivate tenant
    @Override
    public Tenant deactivateTenant(String tenantKey) {
        // Find tenant by tenantKey
        Tenant tenant = tenantRepository.findByTenantKey(tenantKey)
                .orElseThrow(() -> new RuntimeException("Tenant not found with key: " + tenantKey));

        // Update status to SUSPENDED
        tenant.setStatus(TenantStatus.SUSPENDED);

        // Update timestamp
        tenant.setUpdatedAt(LocalDateTime.now());

        // Save back to MongoDB
        return tenantRepository.save(tenant);
    }

    // Get tenant statistics
    @Override
    public TenantStatistics getTenantStatistics() {
        long total = tenantRepository.count();
        long active = tenantRepository.findAll().stream().filter(t -> t.getStatus() == TenantStatus.ACTIVE).count();
        long pending = tenantRepository.findAll().stream().filter(t -> t.getStatus() == TenantStatus.PENDING).count();
        long deleted = tenantRepository.findAll().stream().filter(t -> t.getStatus() == TenantStatus.DELETED).count();

        return new TenantStatistics(total, active, pending, deleted);
    }

}

    // Create a new tenant
//    public Tenant createTenant(Tenant tenant) {
//        return tenantRepository.save(tenant);
//    }
//
//    // Get all tenants
//    public List<Tenant> getAllTenants() {
//        return tenantRepository.findAll();
//    }
//
//    // Get tenant by key (used for subdomain/JWT context)
//    public Tenant getTenantByKey(String tenantKey) {
//        return tenantRepository.findByTenantKey(tenantKey)
//                .orElseThrow(() -> new RuntimeException("Tenant not found: " + tenantKey));
//    }
////

//
////    public Tenant getTenantById(int tenantId) {
//    public Tenant getTenantById(String tenantId) {
//        return tenantRepository.findById(tenantId)
//                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + tenantId));
//    }
//    // Get tenant statistics
//    public TenantStatistics getTenantStatistics() {
//        long totalTenants = tenantRepository.count();
//        long activeTenants = tenantRepository.countByStatus("ACTIVE");
//        long pendingApprovals = tenantRepository.countByStatus("PENDING_APPROVAL");
//        long suspendedTenants = tenantRepository.countByStatus("SUSPENDED");
//
//        return new TenantStatistics(totalTenants, activeTenants, pendingApprovals, suspendedTenants);
//    }
//}

