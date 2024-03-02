package oop_lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPage {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Help");
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
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Set the background color of the JTextPane
            setBackground(new Color(170, 220, 150)); // Light green color
        }
    };
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        textPane.setText("<html><div style='font-family: Arial; font-size: 16pt;'>" +
                "<h1 style='font-weight: bold;'>Help</h1>" +
                "<h2 style='font-weight: bold;'>Frequently Asked Questions (FAQs)</h2>" +
                "<p><strong>Q: How can I change or cancel my reservation?</strong><br/>A: You can change or cancel your reservation by contacting our customer support or through your account on our website.</p>" +
                "<p><strong>Q: Are there any additional fees for using your services?</strong><br/>A: No, our services are free to use. We do not charge any additional fees.</p>" +
                "<h2 style='font-weight: bold;'>Contact Support</h2>" +
                "<p>If you need further assistance, please feel free to contact our support team at:</p>" +
                "<p><strong>Email:</strong> support@exploreinn.com</p>" +
                "<p><strong>Phone:</strong> +1 (800) 123-4567</p>" +
                "</div></html>");
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

        frame.add(panel);
        frame.setVisible(true);
    }
}