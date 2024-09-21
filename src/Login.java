import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    public static void login(String userInfo) throws FileNotFoundException{
        File file = new File("src\\userDetails.txt");

        Scanner scan = new Scanner(file);
        // split the line every where the ':' is
        String regex = "[:]";
        String[] userInfoCredentials = userInfo.split(regex);
            
        // Store the email and password in separate variables
        String userEmail = userInfoCredentials[0];
        String userPassword = userInfoCredentials[1];

        boolean isAuthenticated = userAuthentication(scan, userEmail, userPassword, regex);


        if (isAuthenticated){
            System.out.println("Succesfully logged in");
        }else{
            System.out.println("Wrong email or password");
        }
    }

    public static  boolean userAuthentication(Scanner scan, String userEmail, String userPassword, String regex) {
        boolean isLoggedIn = false;
        while (scan.hasNextLine()) {
    
            
            // read each line in the text file
            String line = scan.nextLine();
            
            String[] credentials = line.split(regex);
            
            String emailFromFile = credentials[0];
            String passwordFromFile = credentials[1];

            if (userEmail.equals(emailFromFile) && userPassword.equals(passwordFromFile)) {
                isLoggedIn = true;
                break;
            }
            else{
                isLoggedIn = false;
            }
            
        }
        return isLoggedIn;
    }
        
}
