import java.io.FileWriter;
import java.io.IOException;

public class SignUp {
 
    public void writeToEmailPasswordFile(String userInfo){
        try {
            try (FileWriter writer = new FileWriter("src\\userDetails.csv", true)) {
                writer.append(userInfo+ "\n");
                writer.close();
                System.out.println("User created succesfully");
            }
    
    
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
