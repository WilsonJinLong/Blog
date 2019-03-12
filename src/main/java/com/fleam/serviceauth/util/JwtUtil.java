package com.fleam.serviceauth.util;

import com.fleam.serviceauth.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {

    /**
     * 生成jwt和token
     * @param user
     * @return
     */
    public static String createToken(User user){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setSubject(user.getId().toString())
                .signWith(SignatureAlgorithm.HS256,"fleam")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30));
        return jwtBuilder.compact();
    }

}

