package HOTEL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1;

    public HotelManagementSystem() {
        // Square frame size
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 100);  // Changed to better fit new size

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
        l1.setBounds(0, 0, 900, 600);
        add(l1);

        // Title label
//        JLabel lid = new JLabel("HOTEL MANAGEMENT SYSTEM");
//        lid.setFont(new Font("serif", Font.BOLD, 28));
//        lid.setForeground(Color.RED);
//        lid.setBounds(50, 400, 500, 40);  // Adjusted to fit square frame
//        l1.add(lid);

        // Center the "Next" button
        b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        int buttonWidth = 150;
        int buttonHeight = 50;
        int buttonX = (750 - buttonWidth) ;  // Center X in 600 width frame
        int buttonY = 460;
        b1.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        l1.add(b1);

        b1.addActionListener(this);
        setVisible(true);

        // Title blinking effect
        while (true) {
//            lid.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
//            lid.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);  // Assuming Login.java exists
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
