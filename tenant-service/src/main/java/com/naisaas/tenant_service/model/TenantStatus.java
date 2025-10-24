package com.naisaas.tenant_service.model;

public enum TenantStatus {
    PENDING,    // created but not yet active
    ACTIVE,     // fully active tenant
    SUSPENDED,  // temporarily disabled
    DELETED    // permanently removed
}