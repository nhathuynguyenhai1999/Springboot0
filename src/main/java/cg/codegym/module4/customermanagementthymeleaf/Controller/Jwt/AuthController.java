package cg.codegym.module4.customermanagementthymeleaf.Controller.Jwt;

import cg.codegym.module4.customermanagementthymeleaf.Jwt.JwtResponse;
import cg.codegym.module4.customermanagementthymeleaf.Jwt.JwtService;
import cg.codegym.module4.customermanagementthymeleaf.Service.iml.PlayerService;
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
    private PlayerService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Player player) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(player.getFirstName(), player.getLastName()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Player currentUser = userService.fidnByFirstNameAndLastName(player.getFirstName(),player.getLastName());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
}