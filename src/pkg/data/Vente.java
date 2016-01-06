package pkg.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vente{
	private int idVente;
	private int idSnack;
	private String dateVente;
	
	Vente(int idVente, int idSnack)
	{
		idVente = idVente;
		idSnack = idSnack;
		dateVente = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	int getIdVente()
	{
		return idVente;
	}
	
	float getIdSnack()
	{
		return idSnack;
	}
	
	String getDateVente()
	{
		return dateVente;
	}
	
	void setIdVente(int id)
	{
		idVente = id;
	}
	
	void setIdSnack(int id)
	{
		idSnack = id;
	}
	
	void setDateVente(String vente)
	{
		dateVente = vente;
	}
	
	public String toString()
	{
		return "";
	}
}
