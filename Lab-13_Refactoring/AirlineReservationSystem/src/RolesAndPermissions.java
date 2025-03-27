import java.util.Arrays;

public class RolesAndPermissions extends User {

    public int isPrivilegedUserOrNot(String username, String password) {
        if (!isValidAdmin(username)) {
            return -1;
        }
        else {
            return verifyAdminCredentials(username, password);
        }
    }

    private boolean isValidAdmin(String username) {
        return Arrays.stream(adminUserNameAndPassword).anyMatch(cred -> cred[0] != null && cred[0].equals(username));
    }

    private int verifyAdminCredentials(String username, String password) {
        for(int i = 0; i < adminUserNameAndPassword.length; i++) {
            if(username.equals(adminUserNameAndPassword[i][0]) && password.equals(adminUserNameAndPassword[i][1])) {
                return i;
            }
        }
        return -1;
    }
    
    public String isPassengerRegistered(String email, String password) {
        String isFound = "0";
        for (Customer c : Customer.customerCollection) {
            if (email.equals(c.getEmail())) {
                if (password.equals(c.getPassword())) {
                    isFound = "1-" + c.getUserID();
                    break;
                }
            }
        }
        return isFound;
    }
}
