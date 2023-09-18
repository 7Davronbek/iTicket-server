package com.example.iticket.user;

import com.example.iticket.user.entity.User;
import com.example.iticket.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_SaveIsNotNull() {
//      Arrange
        User testUser = User.builder()
                .id(UUID.randomUUID())
                .name("Test name")
                .phoneNumber("+998973216545")
                .build();
//      Act
        User saveUser = userRepository.save(testUser);

//      Assert
        Assertions.assertNotNull(saveUser);
    }

    @Test
    public void UserRepository_UUIDIsNotEqual() {

        User testUser = User.builder()
                .id(UUID.randomUUID())
                .name("Test name")
                .phoneNumber("+998973216545")
                .build();
        User saveUser = userRepository.save(testUser);

        Assertions.assertNotEquals(UUID.randomUUID(), saveUser.getId());
    }

    @Test
    public void UserRepository_GetAll_ReturnMoreThanOneUser() {
        User testingUser1 = User.builder()
                .id(UUID.randomUUID())
                .phoneNumber("+998947895642")
                .name("Testing name1")
                .build();
        userRepository.save(testingUser1);

        User testingUser2 = User.builder()
                .id(UUID.randomUUID())
                .phoneNumber("+998947895641")
                .name("Testing name2")
                .build();
        userRepository.save(testingUser2);

        User testingUser3 = User.builder()
                .id(UUID.randomUUID())
                .phoneNumber("+998947895643")
                .name("Testing name3")
                .build();
        userRepository.save(testingUser3);

        List<User> users = userRepository.findAll();

        Assertions.assertEquals(3, users.size());
    }
}
