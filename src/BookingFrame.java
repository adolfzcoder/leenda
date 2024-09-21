import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingFrame extends JFrame {
	private JTextField bookingField;
	private JButton submitButton;

	public BookingFrame() {
		setTitle("Booking Module");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		// Create UI components
		JLabel bookingLabel = new JLabel("Enter Booking Details:");
		bookingLabel.setBounds(50, 50, 150, 25);
		add(bookingLabel);

		bookingField = new JTextField();
		bookingField.setBounds(200, 50, 150, 25);
		add(bookingField);

		submitButton = new JButton("Submit");
		submitButton.setBounds(150, 100, 80, 25);
		add(submitButton);

		// Add action listener to the button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleBooking();
			}
		});
	}

	private void handleBooking() {
		String bookingDetails = bookingField.getText();
		// Handle booking logic here
		JOptionPane.showMessageDialog(this, "Booking Submitted: " + bookingDetails);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BookingFrame().setVisible(true);
			}
		});
	}
}
