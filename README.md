# Explore Inn - Hotel Management System

Welcome to the official repository of **Explore Inn**, a comprehensive hotel management system designed to streamline and automate hotel operations. This project aims to enhance efficiency and service quality for hotel staff and management by providing a robust, integrated solution.

## Features

### User Authentication and Access Control
- Secure login and role-based access management to ensure data privacy and integrity.

### Reservation Management
- Manage room bookings with ease, including check-in, check-out, and reservation tracking.

### Billing
- Automated billing and invoicing for guests, with support for various payment methods.

### Inventory Management
- Track and manage hotel inventory, including room availability and housekeeping supplies.

### Reporting and Analytics
- Generate detailed reports and analytics for better decision-making and performance monitoring.

### Online Booking and Payment
- Support for online reservations and payments, enhancing guest convenience and operational efficiency.

### Integration
- Seamless integration with third-party services and platforms for extended functionality.

### User Interfaces
- Intuitive and user-friendly interfaces designed using Swing components for both desktop and web environments.

### Database Management
- Efficient database management using HeidiSQL for streamlined data handling and storage.

### Error Handling and Logging
- Comprehensive error handling and logging mechanisms to ensure system reliability and ease of troubleshooting.

## Technical Details

### Swing GUI Components
- Utilizes Swing components like `JLabel`, `JTextField`, `JPasswordField`, `JButton`, `JFrame`, `JPanel`, `JTextPane`, and `JScrollPane` to create interactive and aesthetically pleasing user interfaces.

### Event Handling
- Implements event handling with the `ActionListener` interface for responsive and dynamic user interactions.

### Database Connectivity
- Connects to a MySQL database using JDBC to verify user login credentials and perform other database operations.

### Custom Painting
- Enhances GUI aesthetics with custom background images and styles using the `ImagePanel` class and overridden `paintComponent` methods.

### Layout Management
- Employs various layout managers like `BorderLayout` and `null layout` for precise and organized component positioning.

### Exception Handling
- Catches and manages errors during database operations and UI interactions to ensure smooth and uninterrupted user experience.

### Multi-Layered Application
- Organizes code into distinct layers for UI, event handling, and database interaction, promoting maintainability and scalability.

### Dynamic Window Creation
- Creates and configures `JFrame` windows for different application interfaces dynamically based on user actions.

### Additional Features
- Utilizes `JDateChooser`, `JSpinner`, `JComboBox` for enhanced user input options.
- Implements `SimpleDateFormat` for date formatting in SQL queries.
- Displays user feedback with `JOptionPane` pop-up messages.

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- MySQL Database
- HeidiSQL (or any other SQL management tool)

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/explore-inn.git
    ```
2. Navigate to the project directory:
    ```bash
    cd explore-inn
    ```
3. Set up the database:
    - Create a MySQL database and import the provided SQL scripts.
4. Compile and run the application:
    ```bash
    javac -d bin src/*.java
    java -cp bin Main
    ```

### Usage
- Run the application and log in using your credentials.
- Navigate through the various modules to manage reservations, billing, inventory, and more.
- Access reports and analytics to monitor hotel performance.

## Contributors
- **Sansita** 
- **Karthika** 

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Acknowledgements
Special thanks to all contributors and supporters of this project. Your efforts and dedication are greatly appreciated.

## Contact
For any queries or issues, please reach out to us at:
- sansitakarthik2005@gmail.com

Thank you for using Explore Inn!
