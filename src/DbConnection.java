import java.sql.*;
public class DbConnection {
	public static Connection dbconnect()throws Exception
	{
		String url="jdbc:mysql://localhost:3306/employeemanagement";
		String username="root";
		String password="karthiika";
	    Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
	
}
