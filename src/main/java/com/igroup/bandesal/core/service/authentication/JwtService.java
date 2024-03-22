package com.igroup.bandesal.core.service.authentication;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class JwtService {
    public String generateJwt() {
        Set<String> roles = new HashSet<>(Arrays.asList("admin","writer"));
        return Jwt.issuer("igroup")
                .subject("user")
                .groups("admin").expiresAt(System.currentTimeMillis() + 3600).sign();
    }
}