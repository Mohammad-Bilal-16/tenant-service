package com.naisaas.tenant_service.controller;

import com.naisaas.tenant_service.entity.RoleType;
import com.naisaas.tenant_service.entity.Tenant;
import com.naisaas.tenant_service.entity.User;
import com.naisaas.tenant_service.service.TenantService;
import com.naisaas.tenant_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TenantService tenantService;

    //  Register new user under a tenant
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam RoleType roleType,
            @RequestParam String tenantId
    ) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        User user = userService.registerUser(username, email, password, roleType, tenant);
        // return ResponseEntity.ok(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
/*
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User request) {
        Tenant tenant = tenantService.getTenantById(request.getTenant().getId());
        User user = userService.registerUser(
                request.getUserName(),
                request.getEmail(),
                request.getPassword(),
              //  request.getRoleType(),
                tenant
        );
        //return ResponseEntity.ok(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
*/

    //  Get all users of a tenant
    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<List<User>> getUsersByTenant(@PathVariable String tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        List<User> users = userService.getUsersByTenant(tenant);
        return ResponseEntity.ok(users);
    }

    //  Get user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
