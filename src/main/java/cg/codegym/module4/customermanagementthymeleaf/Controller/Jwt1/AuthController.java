package cg.codegym.module4.customermanagementthymeleaf.Controller.Jwt1;

import cg.codegym.module4.customermanagementthymeleaf.Jwt2.JwtResponse;
import cg.codegym.module4.customermanagementthymeleaf.Jwt2.JwtService;
import cg.codegym.module4.customermanagementthymeleaf.Jwt2.PlayerServiceJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import cg.codegym.module4.customermanagementthymeleaf.Model.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PlayerServiceJwt userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody PlayerJwt user) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getId(), user.getUserName()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        PlayerJwt currentUser = userService.findByName(user.getUserName());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
}