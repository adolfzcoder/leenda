import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * This method accepts the userEmail and index, then it splits the line in the csv, and stores it in array (userDetails)
 * It then splits it and returns the array at the provided index.
 */
public class SplitByIndex {

    public static String splitByIndex(String userEmail, int index) throws FileNotFoundException {
        File file = new File("src\\userDetails.csv");

        try (Scanner scan = new Scanner(file)) {
            // split the line wherever the ',' is
            String regex = "[,]";
            String targetIndexValue = null;
            
            while (scan.hasNextLine()) {
                // read each line in the text file
                String line = scan.nextLine();
                String[] userDetails = line.split(regex);

                if (userDetails.length > index) { // Ensure there are enough fields
                    String emailFromFile = userDetails[0];
                    if (userEmail.equals(emailFromFile)) {
                        targetIndexValue = userDetails[index]; // retrieve the value at target index
                        break; // stop scanning once the user is found
                    }
                }
            }

            // After scanning, check if the user was found
            if (targetIndexValue == null) {
                System.out.println("User does not exist");
            }

            return targetIndexValue; // can be null if not found
        }
    }
}
