package pkg.data;

public class Etudiant{
	
	private int idEtudiant;
	private String nom;
	private String prenom;
	private String daten;
	private String email;
	private String annee;
	
	Etudiant(int idEtudiant, String nom, String prenom, String daten, String email, String annee)
	{
		idEtudiant = idEtudiant;
		nom = nom;
		prenom = prenom;
		daten = daten;
		email = email;
		annee = annee;		
	}
	
	int getIdEtudiant()
	{
			return idEtudiant;
	}
	
	String getNom()
	{
		return nom;
	}
	
	String getPrenom()
	{
		return prenom;
	}
	
	String getDaten()
	{
		return daten;
	}
	
	String getEmail()
	{
		return email;
	}
	
	String getAnnee()
	{
		return annee;
	}
	
	
	void setIdEtudiant(int id)
	{
		idEtudiant = id;
	}
	
	void setNom(String nom)
	{
		nom = nom;
	}
	
	void setPrenom(String prenom)
	{
		prenom = prenom;
	}
	
	void setDaten(String daten)
	{
		daten = daten;
	}
	
	void setEmail(String email)
	{
		email = email;
	}
	
	void setAnnee(String annee)
	{
		annee = annee;
	}
	
	public String toString()
	{
		return "";
	}
}
