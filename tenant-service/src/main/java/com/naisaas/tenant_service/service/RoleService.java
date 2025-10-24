package com.naisaas.tenant_service.service;

import com.naisaas.tenant_service.model.Role;
import com.naisaas.tenant_service.model.RoleType;
import com.naisaas.tenant_service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get role by enum
    public Role getRoleByName(RoleType roleType) {
        return roleRepository.findByName(roleType)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleType));
    }

    // Create role (in case you want to add new roles dynamically later)
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
