import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnAllRows {

    /*
     * The match is the word you want to return from all rows.
     * The index is the index of the column to match against.
     * This method returns all rows where the match is found at the specified index.
     * 
     * Example usage: match 'Customer' in the 3rd column of the specified file
     *  String[] results = returnAllRows("Customer", 2, "src\\userDetails.csv");
     */
    public static List<String[]> returnAllRows(String match, int index, String filePath) throws FileNotFoundException {

        File file = new File(filePath);
        List<String[]> matchingRows = new ArrayList<>();

        // Open the file using a scanner
        try (Scanner scan = new Scanner(file)) {
            // Regex to split the line by commas
            String regex = "[,]";
            
            // Loop through each line in the file
            while (scan.hasNextLine()) {
                // Read the line
                String line = scan.nextLine();
                
                // Split the line into an array of values
                String[] userDetails = line.split(regex);

                // Ensure there are enough fields to check at the specified index
                if (userDetails.length > index) {
                    // Check if the value at the target index matches the input
                    String valueAtIndex = userDetails[index];
                    if (match.equals(valueAtIndex)) {
                        // If it matches, add the whole row (userDetails) to the list of matching rows
                        matchingRows.add(userDetails);
                    }
                }
            }
        }

        // Return the list of matching rows
        return matchingRows;
    }

   
            // Example usage: match 'Customer' in the 3rd column of the specified file
            // List<String[]> results = returnAllRows("Customer", 2, "src\\userDetails.csv");

            
    
}
