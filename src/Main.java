import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    Login login = new Login();
    public static void main(String[] args) throws FileNotFoundException {
        storeEmailPassword storeEmailPassword = new storeEmailPassword();
        File file = new File("src\\emails-passwords.txt");
        
        Scanner reader = new Scanner(file);
        // get user credentials

        String userInfo = getUserCredentials();
        // write user credentials to file
        storeEmailPassword.writeToEmailPasswordFile(userInfo);

        Login.login(userInfo);
        System.out.println(userInfo);
        
        
    }
    public static String getUserCredentials(){

        System.out.println("Enter your email: ");
        
        String email = scan.nextLine();
        System.out.println("Enter your password: ");
        String password = scan.nextLine();

        return email + " " + password;


    }
}
