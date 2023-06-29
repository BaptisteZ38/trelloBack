package com.example.backTrelloBis.util;

import com.example.backTrelloBis.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import io.github.cdimascio.dotenv.Dotenv;

@Component
public class JwtUtils {
    private String jwtSigninKey;

    public JwtUtils() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        jwtSigninKey = dotenv.get("JWT_KEY") != null ? dotenv.get("JWT_KEY") : "defaultKey";
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(this.jwtSigninKey.getBytes()).parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    public boolean isExpiredToken(String token) {
        return this.extractExpiration(token).before(new Date());
    }

    private String createToken(Map<String, Object> claims, User user) {
        return Jwts.builder().setClaims(claims).setSubject(user.getEmail())
                .claim("authorities", user.getAuthorities()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, this.jwtSigninKey.getBytes()).compact();
    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return this.createToken(claims, user);
    }

    public boolean isValidToken(String token, User user) {
        final String username = this.extractUsername(token);
        return (username.equals(user.getEmail()) && !this.isExpiredToken(token));
    }
}
