import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

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
	public int getGroup(String user, String pass)
	{
		int ret = 0;
		try
		{
			resultat = stmt.executeQuery("SELECT idUser FROM utilisateurs WHERE username = '" + user + "' AND password = MD5('" + pass + "');");
			ResultSetMetaData rsmd = resultat.getMetaData();
			while ( resultat.next() )
			{
				ret = resultat.getInt("idUser");
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
	
	public ArrayList<String> getSnackList()
	{
		ArrayList<String> ret = new ArrayList<String>();
		try
		{
			resultat = stmt.executeQuery("SELECT nom FROM produit;");
			ResultSetMetaData rsmd = resultat.getMetaData();
			while ( resultat.next() )
			{
				ret.add(resultat.getString("nom"));
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
	
	public ArrayList<Snack> getSnackListDetails()
	{
		ArrayList<Snack> ret = new ArrayList<Snack>();
		try
		{
			resultat = stmt.executeQuery("SELECT * FROM produit;");
			ResultSetMetaData rsmd = resultat.getMetaData();
			while ( resultat.next() )
			{
				Snack tmp = new Snack();
				tmp.nom = resultat.getString("nom");
				tmp.idSnack = resultat.getInt("idProduit");
				tmp.idType = resultat.getInt("type");
				tmp.prix = resultat.getFloat("prix");
				ret.add(tmp);
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
	
	public int ajoutMembreBDD(String nom, String prenom, String annee, String naissance, String email)
	{
		int r = 0;
		try
		{
			String query = "INSERT INTO etudiants (nom, prenom, naissance, email, annee) VALUES ('"  
																	 + nom + "','"
																	 + prenom + "','" 
																	 + naissance + "','" 
																	 + email + "','" 
																	 + annee
																	 +"');";
			System.out.println(query);
			r = stmt.executeUpdate(query);
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
	};
	
	public ArrayList<String> getSandwichsList()
	{
		ArrayList<String> ret = new ArrayList<String>();
		try
		{
			resultat = stmt.executeQuery("SELECT nom FROM sandwichs;");
			ResultSetMetaData rsmd = resultat.getMetaData();
			while ( resultat.next() )
			{
				ret.add(resultat.getString("nom"));
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

class Snack
{
	public String nom; 
	public float prix;  
	public int idType; 
	public int idSnack;
};
