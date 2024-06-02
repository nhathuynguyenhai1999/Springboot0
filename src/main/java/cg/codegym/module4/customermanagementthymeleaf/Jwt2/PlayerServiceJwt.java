package cg.codegym.module4.customermanagementthymeleaf.Jwt2;

import cg.codegym.module4.customermanagementthymeleaf.Jwt2.UserPrinciple;
import cg.codegym.module4.customermanagementthymeleaf.Model.Player;
import cg.codegym.module4.customermanagementthymeleaf.Repository.IPlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceJwt implements UserDetailsService {
    @Autowired
    private IPlayerRepository userRepository;

    public Player findByName(String name) {
        return userRepository.findByName(name);
    }

    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findByUsername(username));
    }
}