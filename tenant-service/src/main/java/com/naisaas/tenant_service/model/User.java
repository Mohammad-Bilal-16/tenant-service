package com.naisaas.tenant_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;

    // Basic Info
    @Indexed
    private String userName;

    @Indexed(unique = true, sparse = true)
    private String email;

    private String password; // hashed

    private boolean active = true;

    // Tenant Association (Many Users → One Tenant)
    @JsonIgnore
    @DBRef//(lazy = true)
    private Tenant tenant;

    // RBAC → Each User can have multiple roles
    @JsonIgnore
    @DBRef
    private Set<Role> roles = new HashSet<>();
    /**
     * TODO: -> Need to fix this
     */
    // private RoleType roleType;

    // Audit fields
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}



//@Entity
//@Data
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    // Basic Info
//    @Column(nullable = false)
//    private String userName;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password; // Will be stored in encrypted/hashed form
//
//    private boolean active = true;
//
//    // Tenant Association (Many Users → One Tenant)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tenant_id", nullable = false) //@JoinColumn(name = "tenant_id")
//    private Tenant tenant;
//
//    // RBAC → Each User can have multiple roles
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
//    /**
//     * TODO: -> Need to fix this
//     */
//   // private RoleType roleType;
//
//    // Audit fields
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public Tenant getTenant() {
//        return tenant;
//    }
//
//    public void setTenant(Tenant tenant) {
//        this.tenant = tenant;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
////    public RoleType getRoleType() {
////        return roleType;
////    }
////
////    public void setRoleType(RoleType roleType) {
////        this.roleType = roleType;
////    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}
