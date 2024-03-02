package oop_lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectHotel {
	private static String selectedCity;
    public static void main(String[] args) {
        final JFrame window = new JFrame("Select Hotel");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 800);
        window.setLocation(350, 30);

        // Create a panel with a solid color background
        final JPanel panel = new JPanel() {
                    private Image backgroundImage;

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        // Load and draw the background image
                        if (backgroundImage == null) {
                            backgroundImage = new ImageIcon("C:\\Users\\karth\\Downloads\\green bg2.png").getImage();
                        }
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                // Set the background color
                setBackground(new Color(170,220 , 150));
            }
        };

        // Set the panel's layout to null to position components freely
        panel.setLayout(null);

        // Add a label for the heading
        JLabel headingLabel = new JLabel("Pick Your Hotel!");
        headingLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
        headingLabel.setBounds(280, 30, 400, 30);
        panel.add(headingLabel);
        
        // Create a "View Map" button
        JButton viewMapButton = new JButton("View Map");
        viewMapButton.setBounds(600, 50, 90, 30);
        panel.add(viewMapButton);

        // Add an action listener for the "View Map" button
        viewMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "View Map" button click event here
                // You can open a map view or perform any desired action.
                System.out.println("View Map button clicked");
            }
        });

        // Create arrays of hotel images and associated data for different cities
        String[] chennaiHotelImagePaths = {
            "C:\\Users\\karth\\Downloads\\ch hotel1.jpg", "C:\\Users\\karth\\Downloads\\ch hotel2.jpg", "C:\\Users\\karth\\Downloads\\ch hotel3.jpg", "C:\\Users\\karth\\Downloads\\ch hotel4.jpg"
        };
        double[] chennaiRatings = {4.2, 4.5, 3.8, 4.1};
        String[] chennaiReviews = {"Excellent", "Nice", "Good", "Excellent"};
        String[] chennaiFeatures = {"Pool, Spa", "Direct Beach Access, Pool", "Pool", "Direct Beach Access, Pool"};
        String[] chennaiHotelNames = {"Hotel 1", "Hotel 2", "Hotel 3", "Hotel 4"};
        

        String[] mumbaiHotelImagePaths = {
            "C:\\Users\\karth\\Downloads\\mum hotel1.jpg", "C:\\Users\\karth\\Downloads\\mum hotel2.jpg", "C:\\Users\\karth\\downloads\\mum hotel3.jpg", "C:\\Users\\karth\\downloads\\mum hotel4.jpg"
        };
        double[] mumbaiRatings = {4.0, 4.2, 4.3, 3.9};
        String[] mumbaiReviews = {"Nice", "Excellent", "Good", "Nice"};
        String[] mumbaiFeatures = {"Direct Beach Access", "Pool, Spa", "Pool, Spa", "Pool"};
        String[] mumbaiHotelNames = {"Hotel 1", "Hotel 2", "Hotel 3", "Hotel 4"};
        

        String[] delhiHotelImagePaths = {
            "C:\\Users\\karth\\downloads\\Delhi hotel1.jpg", "C:\\Users\\karth\\downloads\\Delhi hotel2.jpg", "C:\\Users\\karth\\downloads\\Delhi hotel 3.jpg", "C:\\Users\\karth\\downloads\\Delhi hotel 4.jpg"
        };
        double[] delhiRatings = {4.5, 4.8, 4.2, 4.1};
        String[] delhiReviews = {"Excellent", "Excellent", "Nice", "Good"};
        String[] delhiFeatures = {"Pool, Spa", "Direct Beach Access, Pool, Spa", "Pool", "Pool, Spa"};
        String[] delhiHotelNames = {"Hotel 1", "Hotel 2", "Hotel 3", "Hotel 4"};
        

        String[] hyderabadHotelImagePaths = {
            "C:\\Users\\karth\\downloads\\Hyd hotel1.jpg", "C:\\Users\\karth\\downloads\\Hyd hotel2.jpg", "C:\\Users\\karth\\downloads\\Hyd hotel3.jpg", "C:\\Users\\karth\\downloads\\Hyd hotel4.jpg"
        };
        double[] hyderabadRatings = {3.7, 4.0, 4.2, 4.3};
        String[] hyderabadReviews = {"Good", "Nice", "Excellent", "Excellent"};
        String[] hyderabadFeatures = {"Pool, Spa", "Direct Beach Access, Pool", "Pool, Spa", "Direct Beach Access, Pool"};
        String[] hyderabadHotelNames = {"Hotel 1", "Hotel 2", "Hotel 3", "Hotel 4"};

        final JLabel[] chennaiHotelLabels = new JLabel[chennaiHotelImagePaths.length];
        final JLabel[] mumbaiHotelLabels = new JLabel[mumbaiHotelImagePaths.length];
        final JLabel[] delhiHotelLabels = new JLabel[delhiHotelImagePaths.length];
        final JLabel[] hyderabadHotelLabels = new JLabel[hyderabadHotelImagePaths.length];

        final JLabel[] chennaiRatingLabels = new JLabel[chennaiRatings.length];
        final JLabel[] mumbaiRatingLabels = new JLabel[mumbaiRatings.length];
        final JLabel[] delhiRatingLabels = new JLabel[delhiRatings.length];
        final JLabel[] hyderabadRatingLabels = new JLabel[hyderabadRatings.length];

        final JLabel[] chennaiReviewLabels = new JLabel[chennaiReviews.length];
        final JLabel[] mumbaiReviewLabels = new JLabel[mumbaiReviews.length];
        final JLabel[] delhiReviewLabels = new JLabel[delhiReviews.length];
        final JLabel[] hyderabadReviewLabels = new JLabel[hyderabadReviews.length];

        final JLabel[] chennaiFeaturesLabels = new JLabel[chennaiFeatures.length];
        final JLabel[] mumbaiFeaturesLabels = new JLabel[mumbaiFeatures.length];
        final JLabel[] delhiFeaturesLabels = new JLabel[delhiFeatures.length];
        final JLabel[] hyderabadFeaturesLabels = new JLabel[hyderabadFeatures.length];
        
        final JButton[] chennaiBookButtons = new JButton[chennaiHotelImagePaths.length];
        final JButton[] mumbaiBookButtons = new JButton[mumbaiHotelImagePaths.length];
        final JButton[] delhiBookButtons = new JButton[delhiHotelImagePaths.length];
        final JButton[] hyderabadBookButtons = new JButton[hyderabadHotelImagePaths.length];

        
        int xOffset = 50;
        int yOffset = 100;

        for (int i = 0; i < chennaiHotelImagePaths.length; i++) {
            // Load hotel images for Chennai
            ImageIcon hotelImage = new ImageIcon(chennaiHotelImagePaths[i]);
            chennaiHotelLabels[i] = new JLabel(hotelImage);
            // Set the initial visibility to false
            chennaiHotelLabels[i].setVisible(false);
            // Position the hotel images in two rows, two in each row
            int x = xOffset + (i % 2) * 400; // Alternates between xOffset and xOffset + 400
            int y = yOffset + (i / 2) * 300; // Adjust the yOffset for the second row
            chennaiHotelLabels[i].setBounds(x, y, 200, 200);
            panel.add(chennaiHotelLabels[i]);
            
            JLabel hotelNameLabel = new JLabel(chennaiHotelNames[i]);
            hotelNameLabel.setBounds(x+90,y+ 180, 200, 20);
            panel.add(hotelNameLabel);

            // Create labels for ratings and set text
            chennaiRatingLabels[i] = new JLabel("Rating: " + chennaiRatings[i]);
            chennaiRatingLabels[i].setBounds(x, y + 210, 200, 20);
            panel.add(chennaiRatingLabels[i]);

            // Create labels for reviews and set text
            chennaiReviewLabels[i] = new JLabel("Review: " + chennaiReviews[i]);
            chennaiReviewLabels[i].setBounds(x+90, y + 210, 200, 20);
            panel.add(chennaiReviewLabels[i]);

            // Create labels for features and set text
            chennaiFeaturesLabels[i] = new JLabel(chennaiFeatures[i]);
            chennaiFeaturesLabels[i].setBounds(x, y + 230, 200, 40); // Adjusting the height to fit features
            panel.add(chennaiFeaturesLabels[i]);
            
         // Create a "Book" button
            chennaiBookButtons[i] = new JButton("Book");
            chennaiBookButtons[i].setBounds(x+50, y + 260, 100, 30);
            panel.add(chennaiBookButtons[i]);
        }
        
     // Repeat the above block for Mumbai, Delhi, and Hyderabad images
        
        for (int i = 0; i < mumbaiHotelImagePaths.length; i++) {
            // Load hotel images for mumbai
            ImageIcon hotelImage = new ImageIcon(mumbaiHotelImagePaths[i]);
            mumbaiHotelLabels[i] = new JLabel(hotelImage);
            // Set the initial visibility to false
            mumbaiHotelLabels[i].setVisible(false);
            // Position the hotel images in two rows, two in each row
            int x = xOffset + (i % 2) * 400; // Alternates between xOffset and xOffset + 400
            int y = yOffset + (i / 2) * 300; // Adjust the yOffset for the second row
            mumbaiHotelLabels[i].setBounds(x, y, 200, 200);
            panel.add(mumbaiHotelLabels[i]);

            JLabel hotelNameLabel = new JLabel(mumbaiHotelNames[i]);
            hotelNameLabel.setBounds(x+90, y + 180, 200, 20);
            panel.add(hotelNameLabel);
            
            // Create labels for ratings and set text
            mumbaiRatingLabels[i] = new JLabel("Rating: " + mumbaiRatings[i]);
            mumbaiRatingLabels[i].setBounds(x, y + 210, 200, 20);
            panel.add(mumbaiRatingLabels[i]);

            // Create labels for reviews and set text
            mumbaiReviewLabels[i] = new JLabel("Review: " + mumbaiReviews[i]);
            mumbaiReviewLabels[i].setBounds(x+90, y + 210, 200, 20);
            panel.add(mumbaiReviewLabels[i]);

            // Create labels for features and set text
            mumbaiFeaturesLabels[i] = new JLabel(mumbaiFeatures[i]);
            mumbaiFeaturesLabels[i].setBounds(x, y + 230, 200, 40); // Adjusting the height to fit features
            panel.add(mumbaiFeaturesLabels[i]);
            
            // Create a "Book" button
            mumbaiBookButtons[i] = new JButton("Book");
            mumbaiBookButtons[i].setBounds(x+50, y + 260, 100, 30);
            panel.add(mumbaiBookButtons[i]);
        }
        
        for (int i = 0; i < delhiHotelImagePaths.length; i++) {
            // Load hotel images for delhi
            ImageIcon hotelImage = new ImageIcon(delhiHotelImagePaths[i]);
            delhiHotelLabels[i] = new JLabel(hotelImage);
            // Set the initial visibility to false
            delhiHotelLabels[i].setVisible(false);
            // Position the hotel images in two rows, two in each row
            int x = xOffset + (i % 2) * 400; // Alternates between xOffset and xOffset + 400
            int y = yOffset + (i / 2) * 300; // Adjust the yOffset for the second row
            delhiHotelLabels[i].setBounds(x, y, 200, 200);
            panel.add(delhiHotelLabels[i]);
            
            JLabel hotelNameLabel = new JLabel(delhiHotelNames[i]);
            hotelNameLabel.setBounds(x+90, y + 180, 200, 20);
            panel.add(hotelNameLabel);

            // Create labels for ratings and set text
            delhiRatingLabels[i] = new JLabel("Rating: " + delhiRatings[i]);
            delhiRatingLabels[i].setBounds(x, y + 210, 200, 20);
            panel.add(delhiRatingLabels[i]);

            // Create labels for reviews and set text
            delhiReviewLabels[i] = new JLabel("Review: " + delhiReviews[i]);
            delhiReviewLabels[i].setBounds(x+90, y + 210, 200, 20);
            panel.add(delhiReviewLabels[i]);

            // Create labels for features and set text
            delhiFeaturesLabels[i] = new JLabel(delhiFeatures[i]);
            delhiFeaturesLabels[i].setBounds(x, y + 230, 200, 40); // Adjusting the height to fit features
            panel.add(delhiFeaturesLabels[i]);
            
            // Create a "Book" button
            delhiBookButtons[i] = new JButton("Book");
            delhiBookButtons[i].setBounds(x+50, y + 260, 100, 30);
            panel.add(delhiBookButtons[i]);
        }
        
        for (int i = 0; i < hyderabadHotelImagePaths.length; i++) {
            // Load hotel images for hyderabad
            ImageIcon hotelImage = new ImageIcon(hyderabadHotelImagePaths[i]);
            hyderabadHotelLabels[i] = new JLabel(hotelImage);
            // Set the initial visibility to false
            hyderabadHotelLabels[i].setVisible(false);
            // Position the hotel images in two rows, two in each row
            int x = xOffset + (i % 2) * 400; // Alternates between xOffset and xOffset + 400
            int y = yOffset + (i / 2) * 300; // Adjust the yOffset for the second row
            hyderabadHotelLabels[i].setBounds(x, y, 200, 200);
            panel.add(hyderabadHotelLabels[i]);
            
            JLabel hotelNameLabel = new JLabel(hyderabadHotelNames[i]);
            hotelNameLabel.setBounds(x+90, y + 180, 200, 20);
            panel.add(hotelNameLabel);

            // Create labels for ratings and set text
            hyderabadRatingLabels[i] = new JLabel("Rating: " + hyderabadRatings[i]);
            hyderabadRatingLabels[i].setBounds(x, y + 210, 200, 20);
            panel.add(hyderabadRatingLabels[i]);

            // Create labels for reviews and set text
            hyderabadReviewLabels[i] = new JLabel("Review: " + hyderabadReviews[i]);
            hyderabadReviewLabels[i].setBounds(x+90, y + 210, 200, 20);
            panel.add(hyderabadReviewLabels[i]);

            // Create labels for features and set text
            hyderabadFeaturesLabels[i] = new JLabel(hyderabadFeatures[i]);
            hyderabadFeaturesLabels[i].setBounds(x, y + 230, 200, 40); // Adjusting the height to fit features
            panel.add(hyderabadFeaturesLabels[i]);
            
            // Create a "Book" button
            hyderabadBookButtons[i] = new JButton("Book");
            hyderabadBookButtons[i].setBounds(x+50, y + 260, 100, 30);
            panel.add(hyderabadBookButtons[i]);
        }

        for (int i = 0; i < chennaiBookButtons.length; i++) {
            final int index = i; // Create a final variable to capture the current index
            chennaiBookButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	chennaiBookButtons[index].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	window.dispose(); // Close the current window
                            BookingWindow1.main(new String[]{});
                        }   
                	});
                }
            });
        }
        
        for (int i = 0; i < mumbaiBookButtons.length; i++) {
            final int index = i; // Create a final variable to capture the current index
            mumbaiBookButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	mumbaiBookButtons[index].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	window.dispose(); // Close the current window
                            BookingWindow2.main(new String[]{});
                        }   
                	});
                }
            });
        }

        for (int i = 0; i < delhiBookButtons.length; i++) {
            final int index = i; // Create a final variable to capture the current index
            delhiBookButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	delhiBookButtons[index].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	window.dispose(); // Close the current window
                            BookingWindow3.main(new String[]{});
                        }   
                	});
                }
            });
        }

        for (int i = 0; i < hyderabadBookButtons.length; i++) {
            final int index = i; // Create a final variable to capture the current index
            hyderabadBookButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	hyderabadBookButtons[index].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	window.dispose(); // Close the current window
                            BookingWindow4.main(new String[]{});
                        }   
                	});
                }
            });
        }


        

        // Create a JComboBox for city selection
        String[] options = {"Select City","Chennai", "Mumbai", "Delhi", "Hyderabad"};
        final JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(50, 50, 150, 30);
        panel.add(comboBox);

        // Add an ActionListener to the JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String selectedCity = comboBox.getSelectedItem().toString();

                // Hide all hotel images, rating labels, review labels, and feature labels by default
                hideAllHotelImages(chennaiHotelLabels);
                hideAllHotelImages(mumbaiHotelLabels);
                hideAllHotelImages(delhiHotelLabels);
                hideAllHotelImages(hyderabadHotelLabels);
                hideAllRatingLabels(chennaiRatingLabels);
                hideAllRatingLabels(mumbaiRatingLabels);
                hideAllRatingLabels(delhiRatingLabels);
                hideAllRatingLabels(hyderabadRatingLabels);
                hideAllReviewLabels(chennaiReviewLabels);
                hideAllReviewLabels(mumbaiReviewLabels);
                hideAllReviewLabels(delhiReviewLabels);
                hideAllReviewLabels(hyderabadReviewLabels);
                hideAllFeaturesLabels(chennaiFeaturesLabels);
                hideAllFeaturesLabels(mumbaiFeaturesLabels);
                hideAllFeaturesLabels(delhiFeaturesLabels);
                hideAllFeaturesLabels(hyderabadFeaturesLabels);
                
                if (selectedCity.equals("Chennai")) {
                    // Show Chennai hotel images, rating labels, review labels, and feature labels when "Chennai" is selected
                    showHotelImages(chennaiHotelLabels);
                    showRatingLabels(chennaiRatingLabels);
                    showReviewLabels(chennaiReviewLabels);
                    showFeaturesLabels(chennaiFeaturesLabels);
                    
                } else if (selectedCity.equals("Mumbai")) {
                    // Show Mumbai hotel images, rating labels, review labels, and feature labels when "Mumbai" is selected
                    showHotelImages(mumbaiHotelLabels);
                    showRatingLabels(mumbaiRatingLabels);
                    showReviewLabels(mumbaiReviewLabels);
                    showFeaturesLabels(mumbaiFeaturesLabels);
                    
                } else if (selectedCity.equals("Delhi")) {
                    // Show Delhi hotel images, rating labels, review labels, and feature labels when "Delhi" is selected
                    showHotelImages(delhiHotelLabels);
                    showRatingLabels(delhiRatingLabels);
                    showReviewLabels(delhiReviewLabels);
                    showFeaturesLabels(delhiFeaturesLabels);
                    
                } else if (selectedCity.equals("Hyderabad")) {
                    // Show Hyderabad hotel images, rating labels, review labels, and feature labels when "Hyderabad" is selected
                    showHotelImages(hyderabadHotelLabels);
                    showRatingLabels(hyderabadRatingLabels);
                    showReviewLabels(hyderabadReviewLabels);
                    showFeaturesLabels(hyderabadFeaturesLabels);
                    
                }
            }
        });
        
     // Inside the SelectHotel class
        viewMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "View Map" button click event here
                //System.out.println("View Map button clicked");

                final String selectedCity = comboBox.getSelectedItem().toString();
                if (!selectedCity.equals("Select City")) {
                    // Open the map window for the selected city
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new MapViewWindow(selectedCity);
                        }
                    });
                }
            }
        });



        // Add the panel to the frame
        window.add(panel);

        window.setVisible(true);
    }
    
    
    
    
     // Helper method to hide all hotel images
    private static void hideAllHotelImages(JLabel[] hotelLabels) {
        for (JLabel label : hotelLabels) {
            label.setVisible(false);
        }
    }

    // Helper method to show hotel images
    private static void showHotelImages(JLabel[] hotelLabels) {
        for (JLabel label : hotelLabels) {
            label.setVisible(true);
        }
    }

    // Helper method to hide all rating labels
    private static void hideAllRatingLabels(JLabel[] ratingLabels) {
        for (JLabel label : ratingLabels) {
            label.setVisible(false);
        }
    }

    // Helper method to show rating labels
    private static void showRatingLabels(JLabel[] ratingLabels) {
        for (JLabel label : ratingLabels) {
            label.setVisible(true);
        }
    }

    // Helper method to hide all review labels
    private static void hideAllReviewLabels(JLabel[] reviewLabels) {
        for (JLabel label : reviewLabels) {
            label.setVisible(false);
        }
    }

    // Helper method to show review labels
    private static void showReviewLabels(JLabel[] reviewLabels) {
        for (JLabel label : reviewLabels) {
            label.setVisible(true);
        }
    }

    // Helper method to hide all feature labels
    private static void hideAllFeaturesLabels(JLabel[] featureLabels) {
        for (JLabel label : featureLabels) {
            label.setVisible(false);
        }
    }

    // Helper method to show feature labels
    private static void showFeaturesLabels(JLabel[] featureLabels) {
        for (JLabel label : featureLabels) {
            label.setVisible(true);
        }
    }
}
