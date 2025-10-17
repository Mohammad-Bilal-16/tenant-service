package com.naisaas.tenant_service.entity;


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
    @Indexed(unique = true)
    private String tenantName;  // Example: ABC Pvt Ltd

    @Indexed(unique = true)
    private String tenantKey;   // Unique key used in JWT / Tenant context

    @Indexed(unique = true)
    private String subdomain;   // abc.nidaai.com → store "abc"

    private String subscriptionPlan; // Basic, Premium, Enterprise, etc.

    private boolean active = true;

    // Enabled modules for this tenant (decided by Level 1)
    private Set<String> enabledModules = new HashSet<>();
    // Example values: ["HRMS", "Accounting", "Talent", "Projects"]

    // Relationships
    private List<User> users = new ArrayList<>();

    // Audit fields
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public boolean isActive() {
        return active;
    }

    public Set<String> getEnabledModules() {
        return enabledModules;
    }

    public List<User> getUsers() {
        return users;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEnabledModules(Set<String> enabledModules) {
        this.enabledModules = enabledModules;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}

