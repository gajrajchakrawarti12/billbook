package com.backend.controllers;

import java.util.Map;

import com.backend.exception.UnauthenticatedUserException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AuthController {
    @GetMapping("/api/me")
    public Map<String, Object> currentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthenticatedUserException("Authentication is required");
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof OAuth2User oauth2User) {
            return oauth2User.getAttributes();
        }
        if (principal instanceof UserDetails userDetails) {
            return Map.of("username", userDetails.getUsername());
        }

        throw new UnauthenticatedUserException("Unsupported authentication principal");
    }
}
