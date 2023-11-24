package com.demo.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    @Value("${security.jwt.key}")
    private String key;
    @Value("${security.jwt.expiration}")
    private int expirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expirationMs))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public String getUsernameFromToken(String jwtToken) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Jwt token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("Jwt token is unsupported: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid jwt token: {}", e.getMessage());
        } catch (SignatureException e) {
            log.error("Invalid jwt Signature: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("Jwt claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
