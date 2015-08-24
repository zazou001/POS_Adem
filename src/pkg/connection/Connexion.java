package pkg.connection;

import java.sql.*;

public class Connexion {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://88.160.64.214:3306/adem";
	
	static final String USER = "adem";
	static final String PASS = "adem";
	
	Connection conn = null;
	Statement stmt = null;

	public Connexion() {
	   try{
		  //STEP 2: Register JDBC driver
		  Class.forName("com.mysql.jdbc.Driver");

		  //STEP 3: Open a connection
		  System.out.println("Connecting to database...");
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);

		  //STEP 4: Execute a query
		  System.out.println("Creating statement...");
		  stmt = conn.createStatement();
		  stmt.close();
		  conn.close();
	   }catch(SQLException se){
		  //Handle errors for JDBC
		  se.printStackTrace();
	   }catch(Exception e){
		  //Handle errors for Class.forName
		  e.printStackTrace();
	   }
		System.out.println("Goodbye!");
	}
	
 /*   public Connection connect() {
	}

	public void close() {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String requet) {
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(requet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requet : " + requet);
		}
		return resultat;

	}*/	
}
