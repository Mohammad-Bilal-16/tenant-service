package com.naisaas.tenant_service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "roles")
@Data
public class Role {

    @Id
    private String id;

    @Indexed(unique = true)
    private RoleType name;

    private String description; // for human readability & documentation.

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
}
