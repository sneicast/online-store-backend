package dev.scastillo.auth.shared.util;


import dev.scastillo.auth.shared.enums.ClientType;
import dev.scastillo.auth.shared.util.dto.JwtClaimCustom;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtUtil {
    
    private final Key key;
    private final long expiration;

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expirationSeconds
    ) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expirationSeconds * 1000; // convertir a milisegundos
    }

    public String generateToken(String subject, JwtClaimCustom jwtClaimCustom) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", jwtClaimCustom.getUserId());
        claims.put("fullName", jwtClaimCustom.getFullName());
        claims.put("typeUser", jwtClaimCustom.getTypeUser());

        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getSubject(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public JwtClaimCustom getAllClaims(String token) {
        Claims claims = parseToken(token).getBody();
        JwtClaimCustom customClaims = JwtClaimCustom.builder()
                .userId(claims.get("userId", String.class))
                .fullName(claims.get("fullName", String.class))
                .typeUser(ClientType.valueOf(claims.get("typeUser", String.class)))
                .build();


         return customClaims;
    }

    private Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
