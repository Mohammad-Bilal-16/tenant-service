package com.naisaas.tenant_service.service;

import com.naisaas.tenant_service.entity.Role;
import com.naisaas.tenant_service.entity.RoleType;
import com.naisaas.tenant_service.entity.Tenant;
import com.naisaas.tenant_service.entity.User;
import com.naisaas.tenant_service.repository.RoleRepository;
import com.naisaas.tenant_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user inside a tenant
    public User registerUser(String username, String email, String password, RoleType roleType, Tenant tenant) {
        if (userRepository.existsByUserName(username)) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(); // Created User here!!
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // hash password
        user.setTenant(tenant);

        Role role = roleRepository.findByName(roleType)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleType));
        user.getRoles().add(role);

        return userRepository.save(user);
    }

    // Get all users of a tenant
    public List<User> getUsersByTenant(Tenant tenant) {
        return userRepository.findByTenant(tenant);
    }

    // Get user by username (for login)
    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }
}
