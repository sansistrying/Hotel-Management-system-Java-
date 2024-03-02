package oop_lab12;

import javax.swing.*;
import java.awt.*;

public class MapViewWindow extends JFrame {
    public MapViewWindow(String selectedCity) {
        super("Map View - " + selectedCity);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window, not the entire application
        setSize(500, 300);

        // Load and display the map image based on the selected city
        String mapImagePath = getMapImagePath(selectedCity);
        if (mapImagePath != null) {
            ImageIcon mapImage = new ImageIcon(mapImagePath);
            JLabel mapLabel = new JLabel(mapImage);
            mapLabel.setHorizontalAlignment(JLabel.CENTER);
            mapLabel.setVerticalAlignment(JLabel.CENTER);
            add(mapLabel);
        }

        setVisible(true);
    }

    // Helper method to get the map image path based on the selected city
    private String getMapImagePath(String selectedCity) {
        if (selectedCity.equals("Chennai")) {
            return "C:\\Users\\karth\\Downloads\\ch hotel map.jpg"; 
        } else if (selectedCity.equals("Mumbai")) {
            return "C:\\Users\\karth\\Downloads\\mum hotel map.jpg"; 
        }
        else if (selectedCity.equals("Delhi")) {
            return "C:\\Users\\karth\\Downloads\\del hotel map.jpg"; 
        }
        else if (selectedCity.equals("Hyderabad")) {
            return "C:\\Users\\karth\\Downloads\\hyd hotel map.jpg";
        }

        return null; // Return null if the selected city has no map
    }
}
