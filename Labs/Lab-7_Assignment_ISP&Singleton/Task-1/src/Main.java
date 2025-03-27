public class Main {
    public static void main(String[] args) {

        UserManagementSystem ums = UserManagementSystem.getInstance();
        User testUser = new User("testUser", "test@example.com", "password", "Power");

        ums.addUser(testUser);
        User viewedUser = ums.viewUser(testUser.getUserID());
        assert viewedUser != null && viewedUser.getUsername().equals("testUser") : "View user test failed";

        ums.deleteUser(testUser.getUserID());
        System.out.println("All test cases passed.");

    }
}