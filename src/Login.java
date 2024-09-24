import adminmodules.AdminDashboard;
import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Login {

    public static void login(String userInfo) throws FileNotFoundException{
        File file = new File("src\\storage\\userDetails.csv");

        Scanner scan = new Scanner(file);
        // split the line every where the ',' is
        String regex = "[,]";
        String[] userInfoCredentials = userInfo.split(regex);
            
        // store user submitted email and password in userEmail & userPassword
        String userEmail = userInfoCredentials[0];
        String userPassword = userInfoCredentials[1];
        //String phoneNumber = userInfoCredentials[2];
        User loggedInUser = userAuthentication(scan, userEmail, userPassword, ",");


        if (loggedInUser != null){
            System.out.println("Succesfully logged in");
            new AdminDashboard(userEmail);
            //Dashboard dashboard = new Dashboard();
            
            //dashboard.displayUserData(userEmail);

        }else{
            System.out.println("Wrong email or password");
        }
    }

    public static User userAuthentication(Scanner scan, String userEmail, String userPassword, String regex) {
    while (scan.hasNextLine()) {
        // Read each line in the text file
        String line = scan.nextLine();
        String[] credentials = line.split(regex);
        
        // Assuming the CSV format is: email,password,phoneNumber,role
        String emailFromFile = credentials[0];
        String passwordFromFile = credentials[1];
        String phoneNumber = credentials[2];
        //String role = credentials[3];

        // Check for matching email and password
        if (userEmail.equals(emailFromFile) && userPassword.equals(passwordFromFile)) {
            return new User(emailFromFile, passwordFromFile, phoneNumber); // Return user details
        }
    }
    return null; // Return null if authentication fails
}

        
}
