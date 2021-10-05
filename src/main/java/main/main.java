package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.cj.xdevapi.Statement;

public class main {
	
	private static Connection conn;
	private static java.sql.Statement st;
	private static ResultSet rs;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// TODO : connect to Mysql Database

		try {
			// Declare Connectio Properties
//			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3307/test";
			String dbUser = "root";
			String dbPassword = "root";
//			Class.forName(myDriver);
			// create our mysql database connection
			conn = DriverManager.getConnection(myUrl, dbUser, dbPassword);
			
			// get data from mysql database
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM users";

			// create the java statement
			st = conn.createStatement();
			
			
		//insert into database
			  //st.execute("insert into users values(3,\"khaled\",\"khaled\",\"khaled\")");
		//update data in database
			 //st.execute("update users set name='mohamed',user='mohamed',password='mohamed' where id=3");
		//delete from database 
			//st.execute("delete from users where id=2");
			

			// execute the query, and get a java resultset
			rs = ((java.sql.Statement) st).executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String user = rs.getString("user");
				String password = rs.getString("password");
				// print the results
				System.out.println(id+" "+ name+" "+ user+" "+ password);
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
	}

}
