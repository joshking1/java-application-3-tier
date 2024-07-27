package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testSignup() throws Exception {
        when(userService.signup(any(User.class))).thenReturn("User registered successfully");

        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"testuser\", \"password\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));
    }

    @Test
    void testSignin() throws Exception {
        when(userService.signin(any(User.class))).thenReturn("User logged in successfully");

        mockMvc.perform(post("/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"testuser\", \"password\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User logged in successfully"));
    }
}
