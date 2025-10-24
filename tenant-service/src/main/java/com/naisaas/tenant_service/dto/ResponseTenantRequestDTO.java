package com.naisaas.tenant_service.dto;

import com.naisaas.tenant_service.model.AssignedPlan;
import com.naisaas.tenant_service.model.TenantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTenantRequestDTO {
    private String id;
    private String tenantName;
    private String companyName;
    private String primaryEmail;
    private String tenantKey;
    private String subdomain;
    private AssignedPlan assignedPlan;
    private TenantStatus status;
    private Set<String> enabledModules;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
