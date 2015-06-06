/* ---------- ---------- ----------
 * 			  POS.java
 * 
 * Author : Cyril Meyer
 * 
 * Historical :
 * 		Creation   : 05/06/2015
 * 		Last Modif : 05/06/2015
 * 
 * Synopsis :
 * 	Fonctions Spécifique du POS
 * ---------- ---------- ---------- */

import javax.swing.*;

public class POS
{
	POS()
	{
		
	}
	
	/*
	 * Permet l'ajout de membres dans la base de donnée
	 */
	public int ajoutMembre(String nom, String prenom, String annee)
	{
		JOptionPane.showMessageDialog(null, "Ajout du membre " + nom + " " + prenom + " etudiant en " + annee);
		return 0;
	}
}
