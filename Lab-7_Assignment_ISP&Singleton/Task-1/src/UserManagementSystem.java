class UserManager {
    private List<User> users = new ArrayList<>();
    private final String userFile = "User.csv";
    private final String adminFile = "Admin.csv";
    private User currentUser;

    public UserManager() {
        loadUsers();
    }

    // Load users from CSV files
    public void loadUsers() {
        users.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2], data[3], data[4]));
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }

    // Authenticate a user based on username and password
    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }

    // Check if current user is admin
    private boolean isAdmin() {
        return currentUser != null && "Admin".equals(currentUser.getUserType());
    }

    // Rename the user file (Admin-only)
    public boolean renameFile(String oldName, String newName) {
        if (isAdmin()) {
            File oldFile = new File(oldName);
            File newFile = new File(newName);
            return oldFile.renameTo(newFile);
        }
        System.out.println("Access denied: Only Admin can rename files.");
        return false;
    }

    // Update user privileges (Admin-only)
    public boolean updateUserPrivileges(String username, String newPrivilege) {
        if (isAdmin()) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    // Updating in-memory and simulating privilege change in CSV file
                    user = new User(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword(), newPrivilege);
                    saveUsersToFile();
                    return true;
                }
            }
        }
        System.out.println("Access denied: Only Admin can update privileges.");
        return false;
    }

    // Delete a user (Admin-only)
    public boolean deleteUser(String username) {
        if (isAdmin()) {
            users


