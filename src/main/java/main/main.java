package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.user;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

//import com.mysql.cj.xdevapi.Statement;

public class main {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static List<user> userList = new ArrayList();

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// TODO : connect to Mysql Database

		try {
			// Declare Connection Properties
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

			// insert into database
			// st.execute("insert into users values(3,\"khaled\",\"khaled\",\"khaled\")");
			// update data in database
			// st.execute("update users set name='mohamed',user='mohamed',password='mohamed'
			// where id=3");
			// delete from database
			// st.execute("delete from users where id=2");

			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

//			// iterate through the java resultset
			while (rs.next()) {
				user user = new user();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUser(rs.getString("user"));
				user.setPassword(rs.getString("password"));
				userList.add(user);

//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String user = rs.getString("user");
//				String password = rs.getString("password");
//				// print the results
//				System.out.println(id+" "+ name+" "+ user+" "+ password);
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}

				if (st != null) {
					st.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

		// Check if data retreived successfully
		System.out.println(Integer.toString(userList.get(0).getId()));

	}

}
