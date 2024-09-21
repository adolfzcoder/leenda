import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    
    public static void login(String userInfo) throws FileNotFoundException{
        File file = new File("src\\emails-passwords.txt");
        Scanner scan = new Scanner(file);
        String regex = "[:]";
        while (scan.hasNextLine()) {
            
            // Read and print each line
            String line = scan.nextLine();
            
            String[] credentials = line.split(regex);
            
            // Store the email and password in separate variables
            String email = credentials[0];
            String password = credentials[1];

            System.out.println("Email: "+ email);
            System.out.println("Password: "+password);
        }
        
        
    }
}
