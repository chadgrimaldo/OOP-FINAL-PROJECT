public class User {
    private final String name;
    private final String email;
    private final String school;
    private final String phone;

    public User(String name, String email, String school, String phone) {
        this.name = name;
        this.email = email;
        this.school = school;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public String getPhone() {
        return phone;
    }
}
