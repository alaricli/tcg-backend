package com.competition.competition.util;

public class JwtTest {
    public static void main(String[] args) throws Exception {
        String token = JwtUtil.generateToken("test-client");
        System.out.println("Generated token " + token);

        try {
            var claims = JwtUtil.validateToken(token);
            System.out.println("Token is valid. Subject: " + claims.getSubject());
        } catch (Exception e) {
            System.out.println("Token validation failed: " + e.getMessage());
        }

        try {
            JwtUtil.validateToken(token + "invalid");
        } catch (Exception e) {
            System.out.println("Validation failed for invalid token: " + e.getMessage());
        }
    }
}
