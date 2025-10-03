package com.naisaas.tenant_service.controller;

import com.naisaas.tenant_service.entity.Role;
import com.naisaas.tenant_service.entity.RoleType;
import com.naisaas.tenant_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // 1 Get all roles
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    //  Get role by enum
    @GetMapping("/{roleType}")
    public ResponseEntity<Role> getRoleByName(@PathVariable RoleType roleType) {
        Role role = roleService.getRoleByName(roleType);
        return ResponseEntity.ok(role);
    }

    @Secured("ROLE_SUPER_ADMIN")
    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        if (roleService.getAllRoles().stream().anyMatch(r -> r.getName() == role.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null); // Role already exists
        }
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }
}
