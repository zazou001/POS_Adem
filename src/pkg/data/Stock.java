package pkg.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock{
	private int idSnack;
	private int quantite;
	private String dateStock;
	
	Stock(int idSnack, int quantite)
	{
		idSnack = idSnack;
		quantite = quantite;
		dateStock = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	int getIdSnack()
	{
		return idSnack;
	}
	
	int getQuantite()
	{
		return quantite;
	}
	
	String getDateStock()
	{
		return dateStock;
	}
	
	void setIdSnack(int id)
	{
		idSnack = id;
	}
	
	void setQuantite(int quantite)
	{
		quantite = quantite;
	}
	
	void setDateStock(String dateStock)
	{
		dateStock = dateStock;
	}
	
	public String toString()
	{
		return "";
	}
	
}				
