package com.kwetter.userGateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtil {
    public static String getEmailFromToken(String token) {
        JwtConfig jwtConfig = new JwtConfig();

        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(token.replace(jwtConfig.getPrefix(), ""))
                .getBody();

        return claims.getSubject();
    }
}
