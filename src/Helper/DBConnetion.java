package Helper;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnetion {
	public static Connection getConnection() {
        final String username = "naitikraj";
        final String password = "naitikraj";
        Connection connection=null;
        
        try {
                if (connection == null) {
                        final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
                        connection = DriverManager.getConnection(JDBC_URL, username, password);
                        if (connection != null) {

                                System.out.println("Connected to Oracle Database.");
                        }
                }
       
        } catch (Exception exception) {
        }
return connection;
}

}
