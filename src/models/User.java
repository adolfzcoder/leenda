package models;

public class User {
    private String email;
    private String password;
    private String phoneNumber;
    private String userType;
    private String firstName;
    private String lastName;
    private String driversLicense;
    private String userID;

    // Constructor
    public User(String email, String password, String phoneNumber, String userType, String firstName, String lastName, String driversLicense, String userID) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driversLicense = driversLicense;
        this.userID = userID;
    }

    // Getter methods
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getUserType() { return userType; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDriversLicense() { return driversLicense; }
    public String getUserID() { return userID; }
    

}
