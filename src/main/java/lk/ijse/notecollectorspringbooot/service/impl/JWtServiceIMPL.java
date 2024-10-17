package lk.ijse.notecollectorspringbooot.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lk.ijse.notecollectorspringbooot.service.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

@Service
public class JWtServiceIMPL implements JWTService {
  @Value("$")
    String jwtKey;
    @Override
    public String extractUserName(String token) {
        return extractClaim(token,claims::getSubjects);
    }

    @Override
    public String genarateToken(UserDetails user) {
        return "";
    }

    @Override
    public boolean validToken(String token, UserDetails userDetails) {
        return false;
    }


    @Override
    public String refreshToken(String prevToken) {
        return null;
    }

    private <T> T extractClaim(String token, Function<Claims,T> getSubject){
        getClaims(token);

    }

    private  Claims getClaims(String token){
        Jwts.parser().setSigningKey(getKey().build().)
    }

    private Key getKey(String token){
        byte [] decodeJWT = Base64.Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(decodeJWT);
    }

}
