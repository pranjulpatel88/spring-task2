import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRequest userRequest) throws UserAlreadyExistsException {
        // Validate input, create a User entity, and store it in the repository
        User user = new User(userRequest);
        return userRepository.createUser(user);
    }
}
