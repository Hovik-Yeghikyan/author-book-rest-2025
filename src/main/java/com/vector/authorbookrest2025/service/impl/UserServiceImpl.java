package com.vector.authorbookrest2025.service.impl;


import com.vector.authorbookrest2025.entity.User;
import com.vector.authorbookrest2025.repository.UserRepository;
import com.vector.authorbookrest2025.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
