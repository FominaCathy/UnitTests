package FominaKat.third;

import FominaKat.third.tdd.User;
import FominaKat.third.tdd.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    UserRepository userRepository;
    User userAdmin;
    User userNotAdmin;

    @BeforeEach
    void init() {
        userRepository = new UserRepository();
        userAdmin = new User("Admin", "123", true);
        userNotAdmin = new User("User", "123", false);
        userAdmin.authenticate("Admin", "123");
        userNotAdmin.authenticate("User", "123");

    }

    @Test
    void logoutAllExceptAdminTest() {
        userRepository.addUser(userAdmin);
        userRepository.addUser(userNotAdmin);

        userRepository.logoutAllExceptAdmin();

        assertTrue(userRepository.findByName("Admin"));
        assertTrue(userAdmin.isAuthenticate());

        assertFalse(userRepository.findByName("User"));
        assertFalse(userNotAdmin.isAuthenticate());

    }


}
