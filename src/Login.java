import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    
    public static void login(String userInfo) throws FileNotFoundException{
        File file = new File("src\\emails-passwords.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            // Read and print each line
            String line = scan.nextLine();
            System.out.println(line);
        }
        
        
    }
}
