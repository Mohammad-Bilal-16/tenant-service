package com.naisaas.tenant_service.dto;

import com.naisaas.tenant_service.model.AssignedPlan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTenantRequestDTO {
    private String tenantName;
    private String companyName;

    private String primaryEmail;
    private String subdomain;

    private AssignedPlan assignedPlan;
    private Set<String> enabledModules;
}
