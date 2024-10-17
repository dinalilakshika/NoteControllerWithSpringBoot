package lk.ijse.notecollectorspringbooot.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);
    String genarateToken(UserDetails user);
    boolean validToken(String token,UserDetails user);
    String refreshToken(String prevToken);
}
