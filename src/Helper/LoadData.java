package Helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class LoadData {
	public static Object[][] loadData(String tableName,int rowCount,int colCount){
		
		Object[][] tabledata;
		String sql="select * from "+tableName;

		try {
				Connection connection = DBConnetion.getConnection();
	        	Statement statement = connection.createStatement();
	        	ResultSet rs = statement.executeQuery(sql);
	        		
	        	
	        	rs.close();
	        	rs=statement.executeQuery(sql);
	        	
	        	tabledata=new Object[rowCount][colCount];
		        
	        	for(int i=0;i<rowCount;i++) {
	        		rs.next();
	        		for(int j=0;j<colCount;j++) {
	        			tabledata[i][j]="  "+rs.getString(j+1).toUpperCase();
	        			System.out.print(" "+tabledata[i][j]);
	        		}
	        		System.out.println();
	        	}
	        return tabledata;
	        	        					
		}catch(Exception e){
			
			System.out.println(e);
			
		}
				
		
		
		return null;
		}

	
	
public static int tableRowCount(String tableName){
		
		int rows=0;
		Connection connection ;
    	Statement statement;
    	ResultSet rs ;
    	
		try {
			
			 connection = DBConnetion.getConnection();
			 statement = connection.createStatement();
			 rs = statement.executeQuery("select * from "+tableName);
	    	
			while(rs.next()){
	    		rows++;
	    		     		        		        	
	    	}
			
			rs.close();
			statement.close();
			connection.close();		
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
    
		
	return rows;
	}

	
}
