package com.naisaas.tenant_service.entity;

//import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

//@Entity
@Document(collection = "roles")
@Data
//@Table(name = "roles")
public class Role {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String id;

//    @Enumerated(EnumType.STRING) // store as text (PLATFORM_OWNER, ADMIN, etc.)
//    @Column(nullable = false, unique = true)
    @Indexed(unique = true)
    private RoleType name;

    private String description; // for human readability & documentation.

//    // Back reference to users
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    // For simplicity keep reverse side not managed by JPA; optional in Mongo
    private Set<String> userIds = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<String> userIds) {
        this.userIds = userIds;
    }
}
