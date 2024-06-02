package cg.codegym.module4.customermanagementthymeleaf.Jwt2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String token;
    private String type = "Bearer";
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String name;
    @Getter
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(Long id, String token, String username, String name, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.name = name;
        this.authorities = authorities;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

}