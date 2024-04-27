//package com.system.config;
//import com.system.entity.User;
//import com.system.repository.UserRepository;
//import com.system.service.JWTService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Optional;
//
////import java.util.Optional;
//@Component
//@AllArgsConstructor
//
//public class JWTRequestFilter extends OncePerRequestFilter {
//
//    private JWTService jwtService;
//
//    private UserRepository userRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String tokenHeader = request.getHeader("Authorization");
//        if(tokenHeader != null &&  tokenHeader.startsWith("Bearer")){
//            String token = tokenHeader.substring(8,tokenHeader.length()-1);
//           String username = jwtService.getUsername(token);
//            Optional<User> byUsername = userRepository.findByUsername(username);
//            if(byUsername.isPresent()){
//                User user = byUsername.get();
//
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null);
//                authenticationToken.setDetails(new WebAuthenticationDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//
//
//        }
//        filterChain.doFilter(request, response);
//
//    }
//}
