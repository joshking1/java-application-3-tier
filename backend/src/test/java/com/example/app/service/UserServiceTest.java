package com.example.app.service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService();
        userService.userRepository = userRepository;
        userService.passwordEncoder = passwordEncoder;
    }

    @Test
    void testSignup() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        when(userRepository.findByUsername(anyString())).thenReturn(null);

        String result = userService.signup(user);
        assertEquals("User registered successfully", result);
    }

    @Test
    void testSignin() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword(passwordEncoder.encode("password"));

        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User loginUser = new User();
        loginUser.setUsername("testuser");
        loginUser.setPassword("password");

        String result = userService.signin(loginUser);
        assertEquals("User logged in successfully", result);
    }
}
