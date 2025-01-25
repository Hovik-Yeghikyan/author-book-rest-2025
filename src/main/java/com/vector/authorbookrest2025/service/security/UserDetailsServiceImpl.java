package com.vector.authorbookrest2025.service.security;


import com.vector.authorbookrest2025.entity.User;
import com.vector.authorbookrest2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userService.findByEmail(username);
        if (byEmail.isPresent()) {
            User userFromDB = byEmail.get();
            return new CurrentUser(userFromDB);
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
