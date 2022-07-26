package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static java.lang.reflect.Modifier.PROTECTED;

@Data
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "sec_users")
public class Security {

    @Id
    @Column(nullable = false, name = "sec_username")
    private String username;

    @Column(nullable = false, name = "sec_password")
    private String password;

    @Column(nullable = false, name = "sec_enabled")
    private boolean active;

    @Column(nullable = false, name = "sec_authority")
    private String authority;

    public UserDetails toUserDetails() {
        return User.builder()
                .username(username)
                .password(password)
                .disabled(!active)
                .accountExpired(!active)
                .credentialsExpired(!active)
                .authorities(AuthorityUtils.createAuthorityList(authority))
                .build();
    }
}