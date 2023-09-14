import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class UserControllerTests {
    private UserController userController;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void testRegisterUser_Success() throws UserAlreadyExistsException {
        UserRequest userRequest = new UserRequest();
        User user = new User(userRequest);

        when(userService.registerUser(userRequest)).thenReturn(user);

        ResponseEntity<?> response = userController.registerUser(userRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testRegisterUser_UserAlreadyExists() throws UserAlreadyExistsException {
        UserRequest userRequest = new UserRequest();

        when(userService.registerUser(userRequest)).thenThrow(new UserAlreadyExistsException("User already exists"));

        ResponseEntity<?> response = userController.registerUser(userRequest);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}

