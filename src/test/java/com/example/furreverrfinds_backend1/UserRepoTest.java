package com.example.furreverrfinds_backend1;

import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUser() {
        User user = createUser();
        user = userRepo.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    @Order(2)
    public void getUserByUsername() {
        Optional<User> optionalUser = userRepo.getUserByUsername("testuser");
        Assertions.assertThat(optionalUser).isPresent();
        User user = optionalUser.get();
        Assertions.assertThat(user.getUsername()).isEqualTo("testuser");
    }

    @Test
    @Order(3)
    public void updateUser() {
        Optional<User> optionalUser = userRepo.getUserByUsername("testuser");
        Assertions.assertThat(optionalUser).isPresent();
        User user = optionalUser.get();
        user.setFirstName("UpdatedFirstName");
        user = userRepo.save(user);
        Assertions.assertThat(user.getFirstName()).isEqualTo("UpdatedFirstName");
    }

    @Test
    @Order(4)
    public void count() {
        long count = userRepo.count();
        Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void deleteUserById() {
        Optional<User> optionalUser = userRepo.getUserByUsername("testuser");
        Assertions.assertThat(optionalUser).isPresent();
        User user = optionalUser.get();
        userRepo.deleteById(user.getId());
        Optional<User> deletedUser = userRepo.findById(user.getId());
        Assertions.assertThat(deletedUser).isEmpty();
    }

    private User createUser() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setCpassword("password");

        return user;
    }
}
