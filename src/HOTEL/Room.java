/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOTEL;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class Room extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room frame = new Room();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public Room() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//  ADD IMAGE What Ever YOU WANT              

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
                Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,0,600,600);
                add(l1);
//                
		
		String[] tableheading=new String[] {"ROOM-NUMBER","AVAIBILITY","CLEANING STATUS","PRICE","BED-TYPE"};
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int row=0;
                    conn c = new conn();
					String displayCustomersql = "select * from Room";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
//					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) {
						row++;
					}
					Object[][] tableData=new Object[row][5];
					System.out.println();
					System.out.println("ROW : "+row);
					rs.close();
					rs = c.s.executeQuery(displayCustomersql);

					for(int i=0;i<row;i++) {
		        		rs.next();
		        		for(int j=0;j<5;j++) {
		        			tableData[i][j]=" "+rs.getString(j+1).toUpperCase();
		        			
		        		}
		        		System.out.println();
		        	}
		        	
				table.setModel(new DefaultTableModel(tableData,tableheading));
				
					

					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 470, 120, 30);
                btnLoadData.setBackground(Color.RED);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(290, 470, 120, 30);
                btnNewButton.setBackground(Color.RED);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		contentPane.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(330, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(417, 15, 76, 14);
		contentPane.add(lblNewLabel_1);

		
		lblId = new JLabel("Room Number");
		lblId.setBounds(12, 15, 90, 14);
		contentPane.add(lblId);
                
                getContentPane().setBackground(Color.WHITE);
                
            
            this.setResizable(false);
	}

}