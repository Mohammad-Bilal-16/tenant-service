package com.naisaas.tenant_service.service;

import com.naisaas.tenant_service.dto.CreateTenantRequestDTO;
import com.naisaas.tenant_service.dto.ResponseTenantRequestDTO;
import com.naisaas.tenant_service.model.Tenant;
import com.naisaas.tenant_service.model.TenantStatistics;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TenantService {
    ResponseTenantRequestDTO createTenant(CreateTenantRequestDTO requestDTO);
    List<ResponseTenantRequestDTO> getAllTenants();
    ResponseTenantRequestDTO getTenantByKey(String tenantKey);
    public Tenant deactivateTenant(String tenantKey);
    TenantStatistics getTenantStatistics();
}
