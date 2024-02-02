package com.example.live;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.live.user.UserController;
import com.example.live.user.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LiveApplicationTests {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        // Vérifier que le contexte charge correctement
    }

    @Test
    void contextLoadsUserController() {
        // Vérifier que le UserController est chargé
        assertThat(userController).isNotNull();
    }

    @Test
    void contextLoadsUserRepository() {
        // Vérifier que le UserRepository est chargé
        assertThat(userRepository).isNotNull();
    }
}
