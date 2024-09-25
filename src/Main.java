import java.io.FileNotFoundException;
import java.util.Scanner;
import auth.SplashScreen;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static String userEmail = "";
    public static void main(String[] args) throws FileNotFoundException {
        new SplashScreen();
        
        /*SignUp signup = new SignUp();
        // File file = new File("src\\storage\\userDetails.csv");
        
   if(choice.equals("s")){
            // get user credentials

            String userInfo = getUserCredentials();
            // write user credentials to file
            signup.writeToEmailPasswordFile(userInfo);
        }else {
            System.out.println("Incorrect Character, please try again. l or s");
        }*/
    }
  
    public static String getUserCredentials(){

        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        email = email.toLowerCase();

        System.out.println("Enter your password: ");
        String password = scan.nextLine();

        System.out.println("Enter Phone number: ");
        String phoneNumber = scan.nextLine();
        System.out.println("Enter your user type Car Owner, Customer: (co/c)");
        String userType = scan.nextLine();
        userType = userType.toLowerCase();

        if (userType.equals("co")){
            userType = "Car owner";

        } else if(userType.equals("c")){
            userType = "Customer";
        }
        return email+","+ password+","+phoneNumber+","+userType;
    }
}
