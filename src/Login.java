import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {


    public static void login(String userInfo) throws FileNotFoundException{
        File file = new File("src\\emails-passwords.txt");

        Scanner scan = new Scanner(file);

        String regex = "[:]";
        System.out.println(userInfo);
        String[] userInfoCredentials = userInfo.split(regex);
            
        // Store the email and password in separate variables
        String userEmail = userInfoCredentials[0];
        String userPassword = userInfoCredentials[1];

        boolean isAuthenticated = userAuthentication(scan, userEmail, userPassword, regex);
        

        if (isAuthenticated){
            System.out.println("Succesfully logged in");
        }
    }

    public static  boolean userAuthentication(Scanner scan, String userEmail, String userPassword, String regex) {
        boolean isLoggedIn = false;
        while (scan.hasNextLine()) {
    
            
            // Read and print each line
            String line = scan.nextLine();
            
            String[] credentials = line.split(regex);
            
            // Store the email and password in separate variables
            String emailFromFile = credentials[0];
            String passwordFromFile = credentials[1];

            if (userEmail.equals(emailFromFile) && userPassword.equals(passwordFromFile)) {
                System.out.println("User is successfully logged in");
                isLoggedIn = true;
            }
            else{
                System.out.println("Wrong email or password!");
                isLoggedIn = false;
            }
            
        }
        return isLoggedIn;
    }
        
}
