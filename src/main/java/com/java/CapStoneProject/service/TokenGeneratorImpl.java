package com.java.CapStoneProject.service;
//    package com.java.CapStoneProject.service;
//
//    import com.java.CapStoneProject.domain.User;
//    import io.jsonwebtoken.Jwts;
//    import io.jsonwebtoken.SignatureAlgorithm;
//    import org.springframework.stereotype.Service;
//
//    import java.util.Date;
//    import java.util.HashMap;
//    import java.util.Map;
//
//    @Service
//    public class TokenGeneratorImpl implements ITokenGenerator{
//        @Override
//        public Map<String, String> generateToken(User user) {
//            String jwtToken = null;
//            jwtToken = Jwts.builder()
//                    .setSubject(String.valueOf(user.getEmail()))
//                    .setIssuedAt(new Date())
//                    .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
//
//            Map<String,String> map = new HashMap<>();
//            map.put("token",jwtToken);
//            map.put("message","User Successgully logged in!");
//            return map;
//        }
//    }


import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.service.ITokenGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGeneratorImpl implements ITokenGenerator {

    // Generate a secure key once and keep it here (or load from env/config)
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(key) // Use secure key here
                .compact();

        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "User Successfully logged in!");
        return map;
    }

    public SecretKey getKey() {
        return key;
    }
}
