package com.example.demo.serviese;

import com.example.demo.models.Security;
import com.example.demo.repos.SecurityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    final SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return securityRepository.findFirstByUsername(username)
                .map(Security::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User %s not found.", username)));
    }
}