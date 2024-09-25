package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StorageFunctions {
    // Function to count the number of records in the CSV file
    public static int countRecords(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scan = new Scanner(file);

        int recordCount = 0;
        
        // Skip the first line if it's a header
        if (scan.hasNextLine()) {
            scan.nextLine();  // Skip the header line
        }

        // Loop through the file and count each record
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // You can add conditions to skip comment lines or empty lines if needed
            if (!line.startsWith("#") && !line.trim().isEmpty()) {
                recordCount++;
            }
        }
        
        scan.close();
        return recordCount;
    }
}
