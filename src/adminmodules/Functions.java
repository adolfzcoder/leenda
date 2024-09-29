package adminmodules;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author: <edande - 223134902/>
 */
public class Functions {
    public static void changeColorOfTheLabelOfTheHeaderWhenEntering(JLabel label) {
        label.setForeground(new Color(237, 223, 205));
    }

    public static void changeColorOfTheLabelOfTheHeaderWhenExiting(JLabel label) {
        label.setForeground(Color.BLACK);
    }

    // Date and time functions

    /**
     * This function displays the current date in the specified JLabel.
     * The date is formatted as "Sunday, 22th September 2024".
     * 
     * @param dateLabel The JLabel where the date will be displayed.
     */
    public static void showDate(JLabel dateLabel) {
        // Create a SimpleDateFormat object to format the date as "Day, d'th' Month
        // Year"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, d'th' MMMM yyyy");

        // Get the current date from the system
        Calendar calendar = Calendar.getInstance();

        // Format the current date using the specified pattern
        String currentDate = simpleDateFormat.format(calendar.getTime());

        // Set the formatted date text to the JLabel
        dateLabel.setText(currentDate);
    }

    /**
     * This function displays the current time in the specified JLabel and
     * continuously updates it every second (1000 milliseconds).
     * The time is formatted as "12:34:56 PM".
     * 
     * @param timeLabel The JLabel where the time will be displayed and updated.
     */
    public static void showTime(JLabel timeLabel) {
        // Create a Timer object to update the time every second (1000 milliseconds)
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            // Create a SimpleDateFormat object to format the time as "hh:mm:ss a"
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");

            // Get the current time from the system
            Calendar calendar = Calendar.getInstance();

            // Format the current time using the specified pattern
            String currentTime = timeFormat.format(calendar.getTime());

            // Set the formatted time text to the JLabel
            timeLabel.setText(currentTime);
        });

        // Start the Timer to continuously update the time
        timer.start();
    }
}
