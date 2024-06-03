package cg.codegym.module4.customermanagementthymeleaf.Jwt2;

import cg.codegym.module4.customermanagementthymeleaf.Model.PlayerJwt;
import cg.codegym.module4.customermanagementthymeleaf.Repository.IPlayerJwtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceJwt implements UserDetailsService {
    @Autowired
    private IPlayerJwtRepository userRepository;

    public PlayerJwt findByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserDetails loadUserByUsername(String userName) {
        return UserPrinciple.build(userRepository.findByUserName(userName));
    }
}