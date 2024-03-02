package oop_lab12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ULogin1 extends JFrame implements ActionListener {

    private static final long serialVersionUID = 2L;
    JLabel l,l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    JFrame window;

    ULogin1() {
    	window = new JFrame("Login");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        // Background Image
        ImagePanel background = new ImagePanel("C:\\Users\\karth\\Downloads\\green bg2.png");
        background.setBounds(0, 0, 800, 800);
        window.add(background);

        l = new JLabel("LOG IN");
        l.setBounds(330, 50, 190, 40);
        l.setForeground(Color.BLACK);
        l.setFont(new Font("sitka text", Font.BOLD, 42));
        background.add(l);
        
        l1 = new JLabel("Username");
        l1.setBounds(250, 170, 100, 30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("sitka text", Font.BOLD, 18));
        background.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(250, 260, 100, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("sitka text", Font.BOLD, 18));
        background.add(l2);

        t1 = new JTextField();
        t1.setBounds(390, 170, 150, 30);
        background.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(390, 260, 150, 30);
        background.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(230, 400, 120, 40);
        b1.setFont(new Font("sitka text", Font.BOLD, 18));
        b1.addActionListener(this);
        background.add(b1);

        b2 = new JButton("Home");
        b2.setBounds(430, 400, 120, 40);
        b2.setFont(new Font("sitka text", Font.BOLD, 18));
        b2.addActionListener(this);
        background.add(b2);

        getContentPane().setBackground(Color.WHITE);

        window.setVisible(true);
        window.setLocation(350,130);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String password = new String(t2.getPassword());

            if (checkLogin(username, password)) {
            	b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	window.dispose(); // Close the current window
                        SelectHotel.main(new String[]{});
                    }
               

            }); 
            }else {
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        } else if (ae.getSource() == b2) {
        	window.dispose(); // Close the current window
            HomePage.main(new String[]{});
        }
    }
    
    
    
    private boolean checkLogin(String username, String password) {
        // Database connection and SQL query
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");

            s = c.createStatement();
            String query = "SELECT * FROM user_login WHERE username='" + username + "' AND password='" + password + "'";
            rs = s.executeQuery(query);

            return rs.next(); // If a matching record is found, return true
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (s != null) {
                    s.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ULogin1();
    }
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}