package com.vector.authorbookrest2025.service;



import com.vector.authorbookrest2025.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);


    Optional<User> findByEmail(String email);
}
