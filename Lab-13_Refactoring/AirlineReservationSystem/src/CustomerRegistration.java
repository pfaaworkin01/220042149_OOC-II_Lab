import java.util.Objects;

public final class CustomerRegistration {
    private final String name;
    private final String email;
    private final String password;
    private final String phone;
    private final String address;
    private final int age;

    public CustomerRegistration(String name, String email, String password, String phone, String address, int age) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.email = ValidationHelper.validateAndFormatEmail(email);
        this.password = Objects.requireNonNull(password, "Password cannot be null");
        this.phone = ValidationHelper.validateAndFormatPhone(phone);
        this.address = Objects.requireNonNull(address, "Address cannot be null");
        this.age = ValidationHelper.validateAge(age);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public int getAge() { return age; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private int age;

        public Builder name(String name) { this.name = name; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder password(String password) { this.password = password; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder age(int age) { this.age = age; return this; }

        public CustomerRegistration build() {
            return new CustomerRegistration(name, email, password, phone, address, age);
        }
    }
}