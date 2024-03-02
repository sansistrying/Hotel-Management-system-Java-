package oop_lab12;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class BookingWindow4 {
    public static void main(String[] args) {
        // Database connection parameters
        String dbURL = "jdbc:mysql://localhost:3306/hms";
        String username = "root";
        String password = "root";

        // Initialize the database connection
        final Connection[] connection = new Connection[1];
        try {
            connection[0] = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        final JFrame window = new JFrame("Booking Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocation(350, 130);

        // Remove GridBagLayout and set absolute positioning
        window.setLayout(null);

        JLabel bookLabel = new JLabel("Book Here!");
        bookLabel.setFont(new Font("sitka text", Font.BOLD, 40));
        bookLabel.setBounds(300, 10, 300, 40);
        window.add(bookLabel);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("sitka text", Font.BOLD, 20));
        exitButton.setBounds(700, 10, 80, 40);
        window.add(exitButton);

        // Create a label to display the selected destination
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Sitka text", Font.BOLD, 20));
        destinationLabel.setBounds(20, 60, 200, 30);
        window.add(destinationLabel);

        // Create a label and date picker for check-in date
        JLabel checkInLabel = new JLabel("Check-In Date:");
        checkInLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        checkInLabel.setBounds(20, 100, 200, 30);
        window.add(checkInLabel);

        // Create a JDateChooser for check-in date
        final JDateChooser checkInDatePicker = new JDateChooser();
        checkInDatePicker.setBounds(250, 100, 200, 30);
        window.add(checkInDatePicker);

        // Create a label and date picker for check-out date
        JLabel checkOutLabel = new JLabel("Check-Out Date:");
        checkOutLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        checkOutLabel.setBounds(20, 140, 200, 30);
        window.add(checkOutLabel);

        // Create a JDateChooser for check-out date
        final JDateChooser checkOutDatePicker = new JDateChooser();
        checkOutDatePicker.setBounds(250, 140, 200, 30);
        window.add(checkOutDatePicker);

        // Create a label for the number of rooms
        JLabel roomsLabel = new JLabel("Rooms:");
        roomsLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        roomsLabel.setBounds(20, 180, 200, 30);
        window.add(roomsLabel);

        // Create a spin box for the number of rooms
        SpinnerModel roomsSpinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
        final JSpinner roomsSpinner = new JSpinner(roomsSpinnerModel);
        roomsSpinner.setBounds(250, 180, 200, 30);
        window.add(roomsSpinner);

        // Create a label for adults
        JLabel adultsLabel = new JLabel("Adults:");
        adultsLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        adultsLabel.setBounds(20, 220, 200, 30);
        window.add(adultsLabel);

        // Create a spin box for adults
        SpinnerModel adultSpinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
        final JSpinner adultSpinner = new JSpinner(adultSpinnerModel);
        adultSpinner.setBounds(250, 220, 200, 30);
        window.add(adultSpinner);

        // Create a label for children
        JLabel childrenLabel = new JLabel("Children:");
        childrenLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        childrenLabel.setBounds(20, 260, 200, 30);
        window.add(childrenLabel);

        // Create a spin box for children
        SpinnerModel childrenSpinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
        final JSpinner childrenSpinner = new JSpinner(childrenSpinnerModel);
        childrenSpinner.setBounds(250, 260, 200, 30);
        window.add(childrenSpinner);

        // Create a label for room type
        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        roomTypeLabel.setBounds(20, 300, 200, 30);
        window.add(roomTypeLabel);

        // Create a label for the selected destination (assuming a variable selectedDestination is available)
        String selectedDestination = "Hyderabad"; // Replace with the selected destination
        JLabel destinationText = new JLabel(selectedDestination);
        destinationText.setFont(new Font("sitka text", Font.PLAIN, 20));
        destinationText.setBounds(250, 60, 200, 30);
        window.add(destinationText);

        // Create a dropdown for room type
        String[] roomTypeOptions = {"Single", "Double", "Suite"};
        final JComboBox<String> roomTypeDropdown = new JComboBox<>(roomTypeOptions);
        roomTypeDropdown.setBounds(250, 300, 200, 30);
        window.add(roomTypeDropdown);

        // Create a "Book Now" button
        JButton bookNowButton = new JButton("Book Now");
        bookNowButton.setFont(new Font("sitka text", Font.BOLD, 20));
        bookNowButton.setBounds(20, 340, 200, 40);
        window.add(bookNowButton);

        // Create a label to display the total cost
        JLabel billLabel = new JLabel("BILL");
        billLabel.setFont(new Font("sitka text", Font.BOLD, 26));
        billLabel.setBounds(360, 390, 200, 30);
        window.add(billLabel);

        // Create a JLabel to display the total cost
        final JLabel totalCostLabel = new JLabel("Total Cost: $0.00");
        totalCostLabel.setFont(new Font("sitka text", Font.BOLD, 20));
        totalCostLabel.setBounds(310, 430, 200, 30);
        window.add(totalCostLabel);

        // Create a "Pay Now" button and place it at the bottom center
        final JButton payNowButton = new JButton("Pay Now");
        payNowButton.setFont(new Font("sitka text", Font.BOLD, 20));
        // Center the button horizontally and place it at the bottom
        payNowButton.setBounds((window.getWidth() - 200) / 2, 490, 200, 40);
        window.add(payNowButton);
        
        final JLabel roomTypeImageLabel = new JLabel();
        roomTypeImageLabel.setBounds(500, 160, 250, 250); // Adjust the bounds as needed
        window.add(roomTypeImageLabel);

        // Add an action listener for the room type dropdown
        roomTypeDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRoomType = (String) roomTypeDropdown.getSelectedItem();
                // Set the image based on the selected room type
                if (selectedRoomType.equals("Single")) {
                    // Load the image for the Single room type (you should have the image file)
                    ImageIcon roomTypeImage = new ImageIcon("C:\\Users\\karth\\Downloads\\single_room_image.png");
                    roomTypeImageLabel.setIcon(roomTypeImage);
                } else if (selectedRoomType.equals("Double")) {
                    // Load the image for the Double room type
                    ImageIcon roomTypeImage = new ImageIcon("C:\\Users\\karth\\Downloads\\double_room_image.png");
                    roomTypeImageLabel.setIcon(roomTypeImage);
                } else if (selectedRoomType.equals("Suite")) {
                    // Load the image for the Suite room type
                    ImageIcon roomTypeImage = new ImageIcon("C:\\Users\\karth\\Downloads\\suite_room_images.png");
                    roomTypeImageLabel.setIcon(roomTypeImage);
                } else {
                    // Clear the image if no room type is selected
                    roomTypeImageLabel.setIcon(null);
                }
            }
        });
        
        // Add an action listener for the "Book Now" button
        bookNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    // Calculate the total cost based on the selected options
                    int rooms = (int) roomsSpinner.getValue();
                    int adults = (int) adultSpinner.getValue();
                    int children = (int) childrenSpinner.getValue();
                    // You can adjust the cost calculation based on your pricing model
                    double roomCost = 10000.0; // Example cost per room
                    double totalCost = (rooms * roomCost) + (adults * roomCost) + (children * roomCost);
                    totalCostLabel.setText("Total Cost: $" + String.format("%.2f", totalCost));
                    
                    
                    
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String checkInDate = sdf.format(checkInDatePicker.getDate());
                        String checkOutDate = sdf.format(checkOutDatePicker.getDate());
                        String roomType = (String) roomTypeDropdown.getSelectedItem();

                        // SQL query to insert booking details into a table (adjust the table name)
                        String insertQuery = "INSERT INTO booking_details (`Check-In_Date`, `Check-Out_Date`, Adults, Children, `Room_Type`, `No._of_Rooms`) VALUES (?, ?, ?, ?, ?, ?)";

                        
                        PreparedStatement preparedStatement = connection[0].prepareStatement(insertQuery);
                        preparedStatement.setString(1, checkInDate);
                        preparedStatement.setString(2, checkOutDate);
                        preparedStatement.setInt(3, adults);
                        preparedStatement.setInt(4, children);
                        preparedStatement.setString(5, roomType);
                        preparedStatement.setInt(6, rooms);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(window, "Booking successful!");
                        } else {
                            JOptionPane.showMessageDialog(window, "Booking failed.");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                
           
                    // After successful booking, enable the "Pay Now" button
                    payNowButton.setEnabled(true);
            }
        });

        // Add an action listener for the "Pay Now" button
        payNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(window, "Payment successful!");

                // Optionally, you can reset the total cost label and other fields
                totalCostLabel.setText("Total Cost: $0.00");
                roomsSpinner.setValue(1);
                adultSpinner.setValue(1);
                childrenSpinner.setValue(0);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        window.setBackground(new Color(170, 220, 150));

        window.setVisible(true);
    }
}
