public interface UserRepository {
    User createUser(User user) throws UserAlreadyExistsException;
}
