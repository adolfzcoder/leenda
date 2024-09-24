import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    Login login = new Login();
    static String userEmail = "";
    public static void main(String[] args) throws FileNotFoundException {
        SignUp signup = new SignUp();
        // File file = new File("src\\storage\\userDetails.csv");
        
        
        String choice = loginOrSignIn();

        if (choice.equals("l")){
            Login.login(getUserEmailAndPassword());

        }else if(choice.equals("s")){
            // get user credentials

            String userInfo = getUserCredentials();
            // write user credentials to file
            signup.writeToEmailPasswordFile(userInfo);
        }else {
            System.out.println("Incorrect Character, please try again. l or s");
        }
        

       
        
        
    }
    private static String getUserEmailAndPassword() {
        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        email = email.toLowerCase();
        userEmail = email;
        System.out.println("Enter your password: ");
        String password = scan.nextLine();
        
        return email+","+ password;
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

    public static String loginOrSignIn(){
        System.out.println("login or sign up: (l/s)");

        String choice = scan.nextLine();

        return choice.toLowerCase();
    }
}
