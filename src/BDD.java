import java.sql.*;

public class BDD
{
	private String jdbc_driver = "com.mysql.jdbc.Driver";  
	private String db_url = "jdbc:mysql://88.160.64.214:3306/adem";
	private String user = "adem";
	private String pass = "adem";
	
	private Connection conn = null;
	private Statement stmt = null;
    private ResultSet resultat = null;

	BDD()
	{
		
	}
	BDD(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}
	
	public int connect()
	{
		try
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("Connecting to database...");
		  conn = DriverManager.getConnection(db_url,user,pass);
		  System.out.println("Creating statement...");
		  stmt = conn.createStatement();
		}
		catch(SQLException se)
		{
		  se.printStackTrace();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		
		return 0;
	}
	
	public int disconnect()
	{
		try
		{
			stmt.close();
			conn.close();
			System.out.println("Disconnected...");
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int request(String rq)
	{
		int columnsNumber = 0;
		int ret = 0;
		System.out.println("Request : " + rq);
		try
		{
			resultat = stmt.executeQuery(rq);
			ResultSetMetaData rsmd = resultat.getMetaData();
			columnsNumber = rsmd.getColumnCount();
			int i = 0;
			while ( resultat.next() )
			{
				ret++;
				for(i=1;i<=columnsNumber;i++)
					System.out.print(" | " + resultat.getString(i));
				System.out.print("\n");
			
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}	
}

