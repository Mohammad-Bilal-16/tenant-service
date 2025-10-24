package com.naisaas.tenant_service.mapper;

import com.naisaas.tenant_service.dto.CreateTenantRequestDTO;
import com.naisaas.tenant_service.dto.ResponseTenantRequestDTO;
import com.naisaas.tenant_service.model.Tenant;
import com.naisaas.tenant_service.model.TenantStatus;

public class TenantMapper {
    public static ResponseTenantRequestDTO toResponseDTO(Tenant tenant) {
        return ResponseTenantRequestDTO.builder()
                .id(tenant.getId())
                .tenantName(tenant.getTenantName())
                .companyName(tenant.getCompanyName())
                .primaryEmail(tenant.getPrimaryEmail())
                .tenantKey(tenant.getTenantKey())
                .subdomain(tenant.getSubdomain())
                .assignedPlan(tenant.getAssignedPlan())
                //.status(tenant.getStatus())
                .enabledModules(tenant.getEnabledModules())
                .createdAt(tenant.getCreatedAt())
                .updatedAt(tenant.getUpdatedAt())
                .build();
    }

    public static Tenant toEntity(CreateTenantRequestDTO dto) {
        Tenant tenant = new Tenant();
        tenant.setTenantName(dto.getTenantName());
        tenant.setCompanyName(dto.getCompanyName());
        tenant.setPrimaryEmail(dto.getPrimaryEmail());
        tenant.setSubdomain(dto.getSubdomain());
        tenant.setAssignedPlan(dto.getAssignedPlan());
        tenant.setEnabledModules(dto.getEnabledModules());
        tenant.setStatus(TenantStatus.ACTIVE); // default status
        return tenant;
    }
}
