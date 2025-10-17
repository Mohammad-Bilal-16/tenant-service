package com.naisaas.tenant_service.entity;



//import jakarta.persistence.*;
import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

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

//@Entity
//
//@Data
//@Table(name = "tenants")
//public class Tenant {


@Document(collection = "tenants")
@Data
public class Tenant {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;*/

    @Id
    private String id;


//    // Tenant Identity
//    @Column(nullable = false, unique = true)
//    private String tenantName;  // Example: ABC Pvt Ltd

    // Tenant Identity
    @Indexed(unique = true)
    private String tenantName;  // Example: ABC Pvt Ltd

//    @Column(nullable = false, unique = true)
//    private String tenantKey;   // Unique key used in JWT / Tenant context

    @Indexed(unique = true)
    private String tenantKey;   // Unique key used in JWT / Tenant context

//    @Column(nullable = false, unique = true)
//    private String subdomain;   // abc.nidaai.com → store "abc"

    @Indexed(unique = true)
    private String subdomain;   // abc.nidaai.com → store "abc"

    private String subscriptionPlan; // Basic, Premium, Enterprise, etc.

    private boolean active = true;

    // Enabled modules for this tenant (decided by Level 1)
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "tenant_modules", joinColumns = @JoinColumn(name = "tenant_id"))
//    @Column(name = "module_name")
//    private Set<String> enabledModules = new HashSet<>();
//    // Example values: ["HRMS", "Accounting", "Talent", "Projects"]

    // Enabled modules for this tenant (decided by Level 1)
    private Set<String> enabledModules = new HashSet<>();
    // Example values: ["HRMS", "Accounting", "Talent", "Projects"]

    // Relationships
//    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> users = new ArrayList<>();

    // Relationships
    private List<User> users = new ArrayList<>();

//    // Audit fields
//    @CreationTimestamp
//    private LocalDateTime createdAt;

    @CreatedDate
    private LocalDateTime createdAt;

//    @UpdateTimestamp
//    private LocalDateTime updatedAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

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

