import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dashboard extends JFrame {
    private JTable bookingTable;
    private static final String FILE_PATH = "bookings.csv";

    public Dashboard() {
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create UI components
        bookingTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(bookingTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load booking history
        loadBookingHistory();

        setVisible(true);
    }

    private void loadBookingHistory() {
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            List<String[]> data = lines.parallel()
                                       .map(line -> line.split(","))
                                       .collect(Collectors.toList());

            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No booking history found.");
                return;
            }

            String[] columnNames = data.get(0); // Assuming the first line contains column names
            Object[][] tableData = data.stream()
                                       .skip(1) // Skip the header row
                                       .map(row -> row)
                                       .toArray(Object[][]::new);

            // Set table model
            bookingTable.setModel(new javax.swing.table.DefaultTableModel(tableData, columnNames));
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load booking history: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}