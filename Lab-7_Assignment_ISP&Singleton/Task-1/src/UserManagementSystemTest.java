import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagementSystemTest {
    private UserManagementSystem ums;
    private User regularUser;
    private User powerUser;
    private User adminUser;

    @BeforeEach
    public void setUp() {
        ums = UserManagementSystem.getInstance();

        regularUser = new User("regularUser", "regular@example.com", "password123", "Regular");
        powerUser = new User("powerUser", "power@example.com", "password456", "Power");
        adminUser = new User("adminUser", "admin@example.com", "adminPass", "Admin");

        ums.addUser(powerUser);
        ums.addUser(adminUser);
    }

    @Test
    public void testRegularUserCanView() {
        User viewedUser = ums.viewUser(regularUser.getUserID());
        assertNull(viewedUser, "Regular user should not be able to view other users without authentication.");

        ums.addUser(regularUser);
        viewedUser = ums.viewUser(regularUser.getUserID());
        assertNotNull(viewedUser, "User should be able to view their own information.");
    }

    @Test
    public void testPowerUserCanAddUser() {
        User newUser = new User("newUser", "new@example.com", "newPassword", "Regular");
        ums.addUser(newUser);
        User retrievedUser = ums.viewUser(newUser.getUserID());
        assertNotNull(retrievedUser, "Power user should be able to add new users.");
    }

    @Test
    public void testPowerUserCannotRenameFile() {
        ums.renameUserFile("RenamedUser.csv");
        assertFalse(new java.io.File("RenamedUser.csv").exists(), "Power user should not be able to rename the file.");
    }

    @Test
    public void testAdminCanUpdateUser() {
        User updatedUser = new User(adminUser.getUsername(), adminUser.getEmail(), "newAdminPassword", "Admin");
        ums.updateUser(adminUser.getUserID(), updatedUser);
        User retrievedUser = ums.viewUser(adminUser.getUserID());
        assertEquals("newAdminPassword", retrievedUser.getPassword(), "Admin should be able to update user information.");
    }

    @Test
    public void testAdminCanRenameFile() {
        ums.renameUserFile("NewUserFile.csv");
        assertTrue(new java.io.File("NewUserFile.csv").exists(), "Admin should be able to rename the file.");
    }

    @Test
    public void testUserDeletion() {
        ums.deleteUser(powerUser.getUserID());
        User deletedUser = ums.viewUser(powerUser.getUserID());
        assertNull(deletedUser, "User should be deleted successfully.");
    }
}

