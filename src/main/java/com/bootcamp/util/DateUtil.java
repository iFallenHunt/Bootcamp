package com.bootcamp.util;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {

    public static LocalDateTime selectDateTime(String message) {
        JPanel panel = new JPanel();

        // Create a SpinnerDateModel with current date and time
        SpinnerDateModel dateModel = new SpinnerDateModel();

        // Create a JSpinner with the SpinnerDateModel
        JSpinner spinner = new JSpinner(dateModel);

        // Set the format of the date and time editor
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy HH:mm");
        spinner.setEditor(dateEditor);

        // Add the spinner to the panel
        panel.add(new JLabel(message));
        panel.add(spinner);

        // Show the option dialog
        int option = JOptionPane.showOptionDialog(null, panel, "Select Date and Time",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        // Check if the user confirmed the selection
        if (option == JOptionPane.OK_OPTION) {
            return LocalDateTime.of(dateModel.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate(), dateModel.getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalTime());
        }

        // Return current date and time if user canceled
        return LocalDateTime.now();
    }
}
