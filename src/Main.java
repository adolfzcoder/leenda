import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    Login login = new Login();
    public static void main(String[] args) throws FileNotFoundException {
        storeEmailPassword storeEmailPassword = new storeEmailPassword();
        File file = new File("src\\emails-passwords.txt");
        

        String choice = loginOrSignIn();

        if (choice.equals("l")){
            Login.login(getUserCredentials());

        }else if(choice.equals("s")){
            // get user credentials

            String userInfo = getUserCredentials();
            // write user credentials to file
            storeEmailPassword.writeToEmailPasswordFile(userInfo);
        }else {
            System.out.println("Incorrect Character, please try again");
        }
        

       
        
        
    }
    public static String getUserCredentials(){

        System.out.println("Enter your email: ");
        
        String email = scan.nextLine();
        System.out.println("Enter your password: ");
        String password = scan.nextLine();

        return email+":"+ password;


    }

    public static String loginOrSignIn(){
        System.out.println("login or sign in: (l/s)");

        String choice = scan.nextLine();

        return choice;
    }
}
