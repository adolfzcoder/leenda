import java.io.FileWriter;
import java.io.IOException;

public class storeEmailPassword {
 
    public void writeToEmailPasswordFile(String userInfo){
        try {
            try (FileWriter writer = new FileWriter("src\\emails-passwords.txt")) {
                writer.write(userInfo+ "\n");
            }
    
    
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
