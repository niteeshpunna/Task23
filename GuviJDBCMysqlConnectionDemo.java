package GuviTask22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GuviJDBCMysqlConnectionDemo {
	public static void main(String[] args) {
		//Database connection details
		String url = "jdbc:mysql://localhost:3306/guvitask";
		String user = "root";
		String password = "root";
		
		try {
			
			// Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create a connection using the static getConnection method
			Connection conn =DriverManager.getConnection(url,user,password);
			
			if(conn!=null) {
				System.out.println("Connected to database Successfully");
				
			//Create a statement class to execute the SQL statement
			Statement stmt=conn.createStatement();
			
			//Write the Queries
			//1. Create a table in guvitask database
			String createTable = "CREATE TABLE jdbcguviemployees(empcode int, empname varchar(20), empage int, empsalary int)";
			stmt.executeUpdate(createTable);
			
			//2. Insert values 
			stmt.executeUpdate("INSERT INTO jdbcguviemployees(empcode, empname, empage, empsalary) VALUES('101','Jenny','25','10000')");
			stmt.executeUpdate("INSERT INTO jdbcguviemployees(empcode, empname, empage, empsalary) VALUES('102','Jacky','30','20000')");
			stmt.executeUpdate("INSERT INTO jdbcguviemployees(empcode, empname, empage, empsalary) VALUES('103','Jeo','20','40000')");
			stmt.executeUpdate("INSERT INTO jdbcguviemployees(empcode, empname, empage, empsalary) VALUES('104','John','40','80000')");
			stmt.executeUpdate("INSERT INTO jdbcguviemployees(empcode, empname, empage, empsalary) VALUES('105','Shameer','25','90000')");
			
			//3. Get the Result
			ResultSet rs= stmt.executeQuery("select * from jdbcguviemployees;");
			while(rs.next())
			{
				System.out.println(rs.getInt("empcode")+"||"+rs.getString("empname")+"||"+rs.getInt("empage")+"||"+rs.getInt("empsalary"));
				
			}
			}else {
				System.out.println("Failed to connect database");
			}
		}catch(SQLException e) {
			System.out.println("Database Connection Error");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("JDBC connection error");
			e.printStackTrace();
		}
	}
}

/*OUTPUT:
	101||Jenny||25||10000
	102||Jacky||30||20000
	103||Jeo||20||40000
	104||John||40||80000
	105||Shameer||25||90000*/
