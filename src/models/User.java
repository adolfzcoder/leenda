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
    private String userStatus;

    // Constructor
    public User(String email, String password, String phoneNumber, String userType, String firstName, String lastName, String driversLicense, String userID, String userStatus) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driversLicense = driversLicense;
        this.userID = userID;
        this.userStatus = userStatus;
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
    public String getUserStatus() { return userStatus; }
    
    // Setter methods
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setUserType(String userType) { this.userType = userType; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDriversLicense(String driversLicense) { this.driversLicense = driversLicense; }
    public void setUserID(String userID) { this.userID = userID; }
    public void setUserStatus(String userStatus) { this.userStatus = userStatus; }
}
