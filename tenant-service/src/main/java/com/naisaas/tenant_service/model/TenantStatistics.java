package com.naisaas.tenant_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tenant_statistics")
@Data
public class TenantStatistics {
    private long totalTenants;
    private long activeTenants;
    private long pendingApprovals;
    private long suspendedTenants;

    public TenantStatistics(long totalTenants, long activeTenants, long pendingApprovals, long suspendedTenants) {
        this.totalTenants = totalTenants;
        this.activeTenants = activeTenants;
        this.pendingApprovals = pendingApprovals;
        this.suspendedTenants = suspendedTenants;
    }
}
