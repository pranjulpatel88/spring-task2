public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String userName;

    // Constructors, getters, and setters (omitted for brevity)

    public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.userName = userRequest.getUserName();
    }
}
