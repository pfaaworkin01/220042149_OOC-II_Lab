import java.util.UUID;

public class User {
    private String userID;
    private String username;
    private String email;
    private String password;
    private String userType;

    public User(String username, String email, String password, String userType) {
        this.userID = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUserType() {
        return userType;
    }
}

