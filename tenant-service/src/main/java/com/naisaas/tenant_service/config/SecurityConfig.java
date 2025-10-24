package com.naisaas.tenant_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for easier API testing via Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all requests for now
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults()); // keep basic config but it won't be enforced

        return http.build();
    }
}






//package com.naisaas.tenant_service.configs;
//
//import com.naisaas.tenant_service.security.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableMethodSecurity // enables @PreAuthorize, @Secured, etc.
//public class SecurityConfig {
//
//    private final CustomUserDetailsService userDetailsService;
//
//    public SecurityConfig(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    // Password encoder bean
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Authentication provider using your DB users
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    // Expose AuthenticationManager for programmatic login
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    // Main security filter chain
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
//                .authorizeHttpRequests(auth -> auth
//                                .requestMatchers("/api/**").permitAll()
///*
//                        // Public endpoints (login, registration)
//                        .requestMatchers("/api/auth/**").permitAll()
//
//
//                        // Tenant management (SUPER_ADMIN only)
//                        .requestMatchers("/api/tenants/**").hasRole("SUPER_ADMIN")
//
//                        // User management (ADMIN + SUPER_ADMIN)
//                        .requestMatchers("/api/users/**").hasAnyRole("ADMIN","SUPER_ADMIN")
//
//                        // Role management (SUPER_ADMIN only)
//                        .requestMatchers("/api/roles/**").hasRole("SUPER_ADMIN")
//*/
//
//                        // All other endpoints require authentication
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(); // Temporary; replace with JWT later
//
//        return http.build();
//    }
//}
