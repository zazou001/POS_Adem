package pkg.data;

public class Snack{
	private int idType;
	private int idSnack;
	private String nom;
	//private File img;
	private float prix;
	
	
	Snack(int idType, int idSnack, String nom, float prix)
	{
		idType = idType;
		idSnack = idSnack;
		nom = nom;
		prix = prix;
	}
	
	int getIdType()
	{
		return idType;
	}
	
	int getIdSnack()
	{
		return idSnack;
	}
	
	String getnom()
	{
		return nom;
	}
	
	float getprix()
	{
		return prix;
	}
		
	void setIdType(int type)
	{
		type = type;
	}
	
	void setIdSnack(int idSnack)
	{
		idSnack = idSnack;
	}
	
	void setnom(String nom)
	{
		nom = nom;
	}
	
	void setprix(float prix)
	{
		prix = prix;
	}
	
	public String toString()
	{
		return "";
	}
	
}
	
