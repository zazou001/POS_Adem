package pkg.data;

public class Utilisateur{
	private int idUser;
	private int groupe;
	private String user;
	private String passwd;

	Utilisateur(int idUser, int group, String user, String passwd)
	{
		idUser = idUser;
		group = group;
		user = user;
		passwd = passwd;
	}
	
	int getIdUser()
	{
		return idUser;
	}
	
	int getGoupe()
	{
		return groupe;
	}
	
	String getUser()
	{
		return user;
	}
	
	String getPasswd()
	{
		return passwd;
	}
	
	void setIdUser(int id)
	{
		idUser = id;
	}
	
	void setGoupe(int groupe)
	{
		groupe = groupe;
	}
	
	void setUser(String user)
	{
		user = user;
	}
	
	void setPasswd(String passwd)
	{
		passwd = passwd;
	}
	
	public String toString()
	{
		return "";
	}
	
}
