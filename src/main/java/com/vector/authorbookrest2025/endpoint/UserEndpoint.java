package com.vector.authorbookrest2025.endpoint;

import com.vector.authorbookrest2025.dto.SaveUserRequest;
import com.vector.authorbookrest2025.dto.UserAuthRequest;
import com.vector.authorbookrest2025.dto.UserAuthResponse;
import com.vector.authorbookrest2025.entity.User;
import com.vector.authorbookrest2025.mapper.UserMapper;
import com.vector.authorbookrest2025.service.UserService;
import com.vector.authorbookrest2025.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserMapper userMapper;

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody UserAuthRequest userAuthRequest) {
        Optional<User> byEmail = userService.findByEmail(userAuthRequest.getEmail());
        if (byEmail.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }
        User user = byEmail.get();
        if (passwordEncoder.matches(userAuthRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(UserAuthResponse.builder()
                    .token(jwtTokenUtil.generateToken(user.getEmail()))
                    .name(user.getName())
                    .surname(user.getSurname())
                    .userId(user.getId())
                    .build());
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SaveUserRequest saveUserRequest) {
        if (userService.findByEmail(saveUserRequest.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        saveUserRequest.setPassword(passwordEncoder.encode(saveUserRequest.getPassword()));
        userService.save(userMapper.toEntity(saveUserRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
