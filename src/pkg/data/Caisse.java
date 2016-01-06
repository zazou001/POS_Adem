package pkg.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Caisse {
    private int idCaisse;
    private float value;
	private String dateCaisse;

	Caisse(int idCaisse, float value)
	{
		idCaisse = idCaisse;
		value = value;
		dateCaisse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
	}
	
	Caisse(float value)
	{
		idCaisse = 0;
		value = value;
		dateCaisse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
	}
	
	int getIdCaisse()
	{
		return idCaisse;
	}
	
	float getValue()
	{
		return value;
	}
	
	String getDateCaisse()
	{
		return dateCaisse;
	}
	
	void setIdCaisse(int id)
	{
		idCaisse = id;
	}
	
	void setValue(float valeur)
	{
		value = valeur;
	}
	
	void setDateCaisse(String dateCaisse)
	{
		dateCaisse = dateCaisse;
	}
	
	public String toString()
	{
		return "";
	}

}
	
	
