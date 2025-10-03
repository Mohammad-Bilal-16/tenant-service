package com.naisaas.tenant_service.entity;

public enum RoleType {

    // Level 1
    PLATFORM_OWNER, FINANCE_MANAGER, OPS_MANAGER,

    // Level 2
    SUPER_ADMIN, ADMIN, MANAGER, EMPLOYEE,

    // Level 3
    HR_STAFF, FINANCE_ANALYST, RECRUITER, DEVELOPER

}

