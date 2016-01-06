package pkg.data;

public class Sandwich{
	private int idSandwich;
	private String nom;
	
	Sandwich(int idSandwich, String nom)
	{
		idSandwich = idSandwich;
		nom = nom;
	}
	
	int getIdSandwich()
	{
		return idSandwich;
	}
	
	String getnom()
	{
		return nom;
	}
	
	void setIdSandwich(int id)
	{
		idSandwich = id;
	}
	
	void setNom(String nom)
	{
		nom = nom;
	}
}
