package oop_lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutPage {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("About Us");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocation(350,130);

        final JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color
                setBackground(new Color(170, 220, 150)); // Light green color
            }
        };
        panel.setLayout(new BorderLayout());

        JTextPane textPane = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the background color of the JTextPane
                setBackground(new Color(170, 220, 150)); // Light green color
            }
        };
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        textPane.setText("<html><div style='font-family: Arial; font-size: 16pt;'>" +
                "<h1 style='font-weight: bold;'>About Us</h1>" +
                "<p>Welcome to our hotel management system, your go-to platform for finding the best hotel deals and accommodations for your travel needs.</p>" +
                "<h2 style='font-weight: bold;'>Our Mission</h2>" +
                "<p>We strive to simplify the process of finding top-value hotel offers by consolidating hotel listings and pricing data from various booking websites and online travel agencies.</p>" +
                "<h2 style='font-weight: bold;'>What We Offer</h2>" +
                "<ul>" +
                "<li><strong>Extensive Hotel Listings:</strong> Explore a wide range of hotels, from budget-friendly options to luxurious accommodations.</li>" +
                "<li><strong>Competitive Pricing:</strong> Enjoy access to the most competitive rates available, making it easier to find the best deals for your stay.</li>" +
                "<li><strong>Detailed Hotel Information:</strong> Access comprehensive details about each hotel, including amenities, location information, and room types.</li>" +
                "<li><strong>User Reviews and Ratings:</strong> Make informed decisions with authentic user reviews and ratings to guide your choice of accommodation.</li>" +
                "</ul></p></div></html>");

        JScrollPane scrollPane = new JScrollPane(textPane);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Home Page");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                HomePage.main(new String[]{});
            }
        });
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        panel.setBackground(new Color(170, 220, 150)); // Light green color

        frame.add(panel);
        frame.setVisible(true);
    }
}
