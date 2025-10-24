package com.naisaas.tenant_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
public class Role {

    @Id
    private String id;

    @Indexed(unique = true)
    private RoleType name;

    private String description; // for human readability & documentation.

    // For simplicity keep reverse side not managed by JPA; optional in Mongo
//    @JsonIgnore
//    private Set<String> userIds = new HashSet<>();
}
