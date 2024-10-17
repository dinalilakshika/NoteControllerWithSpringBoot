package lk.ijse.notecollectorspringbooot.config;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class JWTConfigFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
 String initToken = request.getHeader("Authorization");
 String userEmail;
 String extractedJWtToken;


 if(StringUtils.isEmpty(initToken)||!initToken).startWith("Bearer"){
     filterChain.doFilter(request,response);


     extractedJWtToken = initToken

        }




 //Todo: extract token

    }

}
