/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOTEL;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;

//import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public SearchRoom() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] tableheading=new String[] {"ROOM NUMBER","AVAILABILITY","CLEANING-STATUS","PRICE"," BED_TYPE"};
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		contentPane.add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
                
                JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(580, 162, 96, 14);
		contentPane.add(l1);
//		
//		JCheckBox checkRoom = new JCheckBox("Only display Available");
//		checkRoom.setBounds(400, 69, 205, 23);
//                checkRoom.setBackground(Color.WHITE);
//		contentPane.add(checkRoom);
//		
		
                c1 = new Choice();
                c1.add("Single Bed");
                c1.add("Double Bed");
                c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
				String SQL2 = "select * from Room where AVAILABILITY = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
			try{			
                
				rs=null;
				int row=0;
				conn c = new conn();
				
				rs = c.s.executeQuery(SQL);
				
				
				while(rs.next()) {
					row++;
				}
				Object[][] tableData=new Object[row][5];
				System.out.println();
				System.out.println("ROW : "+row);
				rs.close();
				rs = c.s.executeQuery(SQL);

				for(int i=0;i<row;i++) {
	        		rs.next();
	        		for(int j=0;j<5;j++) {
	        			tableData[i][j]=" "+rs.getString(j+1).toUpperCase();
	        			
	        		}
	        		System.out.println();
	        	}
	        	
			table.setModel(new DefaultTableModel(tableData,tableheading));
			
			rs.close();
				
				
//				if(checkRoom.isSelected())
//				{	rs.close();
//					rs = c.s.executeQuery(SQL2);
//					while(rs.next()) {
//						row++;
//					}
//					tableData=new Object[row][5];
//					System.out.println();
//					System.out.println("ROW : "+row);
//					rs.close();
//					rs = c.s.executeQuery(SQL2);
//
//					for(int i=0;i<row;i++) {
//		        		rs.next();
//		        		for(int j=0;j<5;j++) {
//		        			tableData[i][j]=" "+rs.getString(j+1).toUpperCase();
//		        			
//		        		}
//		        		System.out.println();
//		        	}
//		        	
//				table.setModel(new DefaultTableModel(tableData,tableheading));
//				
//				}
				
				
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.RED);
                btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblCleanStatus);
                
                getContentPane().setBackground(Color.WHITE);
	}
}