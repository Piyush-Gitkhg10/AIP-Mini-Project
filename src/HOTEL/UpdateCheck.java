/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOTEL;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdateCheck extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Room;
	private JTextField txt_Status;
	private JTextField txt_Date;
	private JTextField txt_Time;
	private JTextField txt_Payment;

        Choice c1, c2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCheck frame = new UpdateCheck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdateCheck() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);
//                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,70,476,270);
                add(l1);
//		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    String sql="select PHONENUMBER from customer";
                    ResultSet rs = c.s.executeQuery(sql);
                    while(rs.next()){
                        c1.add(rs.getString(1));
                    	System.out.print(rs.getString(1));
                    }
                }catch(Exception e){ 
                	e.printStackTrace();
                }
                c1.setBounds(248, 85, 140, 20);
		contentPane.add(c1);
		
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);
                
                
                txt_ID = new JTextField();
                txt_ID.setBounds(248, 126, 140, 20);
		contentPane.add(txt_ID);
		
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Amount (Rs) : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);

		
		txt_Status = new JTextField();
		txt_Status.setBounds(248, 171, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		
		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 140, 20);
		contentPane.add(txt_Date);
		txt_Date.setColumns(10);
		
		txt_Time = new JTextField();
		txt_Time.setBounds(248, 258, 140, 20);
		contentPane.add(txt_Time);
		txt_Time.setColumns(10);
		
		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		contentPane.add(txt_Payment);
		txt_Payment.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { 
                            try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
                                String s2 = txt_ID.getText(); //room_number;    
                                String s3 = txt_Status.getText(); //name    
                                String s4 = txt_Date.getText(); //status;    
                                String s5 = txt_Time.getText(); //deposit    
				
                                c.s.executeUpdate("update customer set ROOM = '"+s2+"', name = '"+s3+"', CHECKINTIME = '"+s4+"', DEPOSIT = '"+s5+"' where PHONENUMBER = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
                            }				
				
				
				
			}
		});
		btnUpdate.setBounds(168, 378, 89, 23);
                btnUpdate.setBackground(Color.RED);
                btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(281, 378, 89, 23);
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JButton btnAdd = new JButton("Check");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
				String s1 = c1.getSelectedItem().trim();
				conn c = new conn();
                                ResultSet rs1 = c.s.executeQuery("select ROOM,NAME,CHECKINTIME,DEPOSIT from customer where PHONENUMBER = "+"'"+s1+"'");
                                
                                while(rs1.next()){
                                	int i=1;
                                    txt_ID.setText(rs1.getString(1));    
                                    System.out.println(rs1.getString(i));
                                    i++;
                                    txt_Status.setText(rs1.getString(2));    
                                    System.out.println(rs1.getString(i));
                                    i++;
                                    
                                    txt_Date.setText(rs1.getString(3));    
                                    System.out.println(rs1.getString(i));
                                    i++;
                                    
                                    txt_Time.setText(rs1.getString(4));
                                    System.out.println(rs1.getString(i));
                                    
                                    
                                    
;                                }
                            }catch(Exception ee){ee.printStackTrace();}
                            
                            try{
                                String total = "";
                                conn c  = new conn();
                                ResultSet rs2 = c.s.executeQuery("select PRICE from room where ROOMNUMBER = "+txt_ID.getText());
                                while(rs2.next()){
                                    total = rs2.getString(1); 
                                    
                                }
                                String paid = txt_Time.getText().trim();
                                int pending = Integer.parseInt(total)- Integer.parseInt(paid);
                                System.out.print(pending+" amount pending");
                                txt_Payment.setText(String.valueOf(pending));
                                
                            }catch(Exception ee){ee.printStackTrace();}
			}
		});
		btnAdd.setBounds(56, 378, 89, 23);
                btnAdd.setBackground(Color.RED);
                btnAdd.setForeground(Color.WHITE);
		contentPane.add(btnAdd);
                
                getContentPane().setBackground(Color.WHITE);
	}

}