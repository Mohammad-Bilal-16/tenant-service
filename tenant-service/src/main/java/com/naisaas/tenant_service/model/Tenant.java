package com.naisaas.tenant_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "tenants")
@Data
public class Tenant {

    @Id
    private String id;

    // Tenant Identity
    @Indexed(unique = true, sparse = true)
    private String tenantName;  // Example: ABC Pvt Ltd

    private String companyName;

    private String primaryEmail;

    @Indexed(unique = true, sparse = true)
    private String tenantKey;   // Unique key used in JWT / Tenant context

    @Indexed(unique = true, sparse = true)
    private String subdomain;

    private AssignedPlan assignedPlan;

    private TenantStatus status;

    // Enabled modules for this tenant (decided by Level 1)
    private Set<String> enabledModules = new HashSet<>();
    // Example values: ["HRMS", "Accounting", "Talent", "Projects"]

    // Relationships
    @JsonIgnore // ✅ Prevent Jackson serialization error
    private List<User> users = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

