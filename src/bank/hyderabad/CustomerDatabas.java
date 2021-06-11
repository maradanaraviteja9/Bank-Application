package bank.hyderabad;
import java.sql.Connection;
import java.sql.DriverManager;

public class CustomerDatabas{
	
	
		public static Connection getConnection()
		{
			String className="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/company";
			String username="root";
			String password="Arjun@1234";
			
			Connection con=null;
			
			
			if(con==null)
			{
				try 
				{
					Class.forName(className);
					con=DriverManager.getConnection(url, username, password);
				} 
				catch (Exception e)
				{
					System.out.println(e);
					e.printStackTrace();
				}
				
			}
			return con;
		}
		}