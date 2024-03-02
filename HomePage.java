package oop_lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class HomePage {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocation(350,130);
        

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\karth\\Downloads\\background img.png"); // Provide the path to your image
        JLabel backgroundLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT)));
        frame.setContentPane(backgroundLabel);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Explore Inn");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 120)); // Increased font size for the logo
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(800, 200)); // Adjusted the size of the logo
        titleLabel.setBorder(new EmptyBorder(-130, 0, 0, 0)); // Adjusted the position of the text

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                ULogin1.main(new String[]{});
            }
        });
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(100, 30)); // Adjusted the size of the button
        loginButton.setMargin(new Insets(5, 10, 5, 10)); // Adjusted the margin of the button

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BorderLayout());

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose(); // Close the current window
                HelpPage.main(new String[]{});
            }
        });

        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose(); // Close the current window
                 AboutPage.main(new String[]{});
            }
        });

        JPanel buttonContainerPanel = new JPanel();
        buttonContainerPanel.setOpaque(false);
        buttonContainerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonContainerPanel.add(helpButton);
        buttonContainerPanel.add(aboutButton);

        buttonPanel.add(buttonContainerPanel, BorderLayout.NORTH);

        panel.add(titleLabel, BorderLayout.CENTER); // Changed the position of the logo to the center
        panel.add(loginButton, BorderLayout.SOUTH); // Changed the position of the button to the bottom
        panel.add(buttonPanel, BorderLayout.NORTH); // Added the button panel to the top

        frame.add(panel);
        frame.setVisible(true);
    }
}
