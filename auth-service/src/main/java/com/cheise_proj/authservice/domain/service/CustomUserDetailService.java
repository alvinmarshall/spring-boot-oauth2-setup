package com.cheise_proj.authservice.domain.service;

import com.cheise_proj.authservice.domain.model.CustomUserDetail;
import com.cheise_proj.authservice.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByUsername(username)
                .map(CustomUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
