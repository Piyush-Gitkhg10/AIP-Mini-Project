package HOTEL;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class AddEmployee extends JFrame {

    JTextField textField, textField_1, textField_3, textField_4, textField_5, textField_6;
    JRadioButton maleButton, femaleButton;
    JComboBox<String> comboBox;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 600);
        setLocation(530, 200);
        getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nameLabel.setBounds(60, 30, 150, 27);
        add(nameLabel);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        ageLabel.setBounds(60, 80, 150, 27);
        add(ageLabel);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        genderLabel.setBounds(60, 120, 150, 27);
        add(genderLabel);

        maleButton = new JRadioButton("MALE");
        maleButton.setBackground(Color.WHITE);
        maleButton.setBounds(200, 120, 70, 27);
        add(maleButton);

        femaleButton = new JRadioButton("FEMALE");
        femaleButton.setBackground(Color.WHITE);
        femaleButton.setBounds(280, 120, 100, 27);
        add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel jobLabel = new JLabel("JOB");
        jobLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jobLabel.setBounds(60, 170, 150, 27);
        add(jobLabel);

        comboBox = new JComboBox<>(new String[] {
            "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff",
            "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"
        });
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(200, 170, 150, 30);
        add(comboBox);

        JLabel salaryLabel = new JLabel("SALARY");
        salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salaryLabel.setBounds(60, 220, 150, 27);
        add(salaryLabel);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phoneLabel.setBounds(60, 270, 150, 27);
        add(phoneLabel);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel aadharLabel = new JLabel("AADHAR");
        aadharLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        aadharLabel.setBounds(60, 320, 150, 27);
        add(aadharLabel);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        emailLabel.setBounds(60, 370, 150, 27);
        add(emailLabel);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(200, 420, 150, 30);
        saveButton.setBackground(Color.RED);
        saveButton.setForeground(Color.WHITE);
        add(saveButton);

        JLabel title = new JLabel("ADD EMPLOYEE DETAILS");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Tahoma", Font.PLAIN, 31));
        title.setBounds(450, 24, 442, 35);
        add(title);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = textField.getText();
                String age = textField_1.getText();
                String gender = null;
                if (maleButton.isSelected()) gender = "male";
                else if (femaleButton.isSelected()) gender = "female";
                String job = (String) comboBox.getSelectedItem();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String aadhar = textField_5.getText();
                String email = textField_6.getText();

                try {
                    conn c = new conn();
                    String query = "INSERT INTO employee values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + aadhar + "', '" + email + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
