package com.example.live;
import java.util.List;
import com.example.live.user.User;
import com.example.live.user.UserController;
import com.example.live.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
    }

    @Test
    void getAllUsersTest() throws Exception {
        given(userRepository.findAll()).willReturn(List.of(user));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(user))));
    }

    @Test
    void getUserByIdTest() throws Exception {
        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(user)));
    }

    @Test
    void createUserTest() throws Exception {
        given(userRepository.save(any(User.class))).willReturn(user);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(user)));
    }

    @Test
    void updateUserTest() throws Exception {
        User updatedUser = new User();
        updatedUser.setName("Jane Doe");
        updatedUser.setEmail("jane.doe@example.com");

        given(userRepository.findById(1L)).willReturn(Optional.of(user));
        given(userRepository.save(any(User.class))).willReturn(updatedUser);

        mockMvc.perform(put("/api/users/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedUser)));
    }

    @Test
    void deleteUserTest() throws Exception {
        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        mockMvc.perform(delete("/api/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully"));
    }

    // Plus d'autres tests pour couvrir les cas d'erreur ou de comportements spécifiques non couverts ici.
}
