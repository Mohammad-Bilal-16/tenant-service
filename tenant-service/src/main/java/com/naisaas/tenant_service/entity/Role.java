package com.naisaas.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // store as text (PLATFORM_OWNER, ADMIN, etc.)
    @Column(nullable = false, unique = true)
    private RoleType name;

    private String description; // for human readability & documentation.

    // Back reference to users
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, unique = true)
//    private RoleType name;
//}
