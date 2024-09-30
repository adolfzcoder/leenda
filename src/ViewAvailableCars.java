import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ViewAvailableCars {
    
    public static void viewAvailableCars(String userEmail) {
        File file = new File("src//storage//cars.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] carDetails = line.split(","); 
                String carName = carDetails[0];
                String status = carDetails[1];
                availableCars(carName, status);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void availableCars(String carName, String status) {
        if (status.equals("available")) {
            System.out.println(carName + " is " + status);
        } else {
            System.out.println(carName + " is not available.");
        }
    }
}
