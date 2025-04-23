/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOTEL;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  

public class conn{
    public static Connection c=null;
    public static Statement s;
    public conn(){  
        try{  
        	
            c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","naitikraj","naitikraj"); 
            s =c.createStatement();  
            System.out.print(s);
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }
    public static void main(String args[]) {
    	new conn();
    }
}  

