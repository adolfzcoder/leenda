package models;

public class User{
    private static String email;
    private static String password;
    private  static String phoneNumber;
    private static String userType;

    public User(String email, String password, String phoneNumber) {
        User.email = email;
        User.password = password;
        User.phoneNumber = phoneNumber;
        //User.userType = userType;
    }

    // Getters
    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String userType() {
        return userType;
    }
}