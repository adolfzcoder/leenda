import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddCar {
    
    public static void addCar(String userEmail) throws FileNotFoundException{
        File file = new File("src\\cars.csv");
        Scanner userInput = new Scanner(System.in);
        Scanner scan = new Scanner(file);
        getCarDetails(userEmail, userInput);

    }

    private static String getCarDetails(String userEmail, Scanner userInput) {
        System.out.println("Enter car");
        return " ";
    }

    

    
}
