/* ---------- ---------- ----------
 * 			  GuiPOS.java
 * 
 * Author : Cyril Meyer
 * 
 * Historical :
 * 		Creation   : 05/06/2015
 * 		Last Modif : 05/06/2015
 * 
 * Synopsis :
 * 	Interface du POS
 * 1. Inscription membres
 * 2. Ventes Snacks
 * 3. Ventes Sandwichs
 * GROUPE > 0	// Resp Stock
 * 4. Gestion Stock
 * Groupe > 1	// Trez / Prez / Root
 * 5. Gestion Caisse
 * 6. Ajouts Produits
 * ---------- ---------- ---------- */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import javax.swing.ImageIcon;

public class GuiPOS extends JFrame
{
	// POUR EVITER L'ERREUR
	// warning: [serial] serializable class GuiPOS has no definition of serialVersionUID
	private static final long serialVersionUID = 42L;
	
	private int grp = 0;
	
    GuiPOS(String user, String pass, int grp)
    {
		this.grp = grp;
		initGUI();
		System.out.println("- LOGIN -");
    }
    
    private void initGUI()
    {
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon noIcon = new ImageIcon("img/no.gif", "NO_ICON");
		final JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		final JPanel panel3 = new JPanel();
		final JPanel panel4 = new JPanel();
		final JPanel panel5 = new JPanel();
		final JPanel panel6 = new JPanel();
		
		// A VOIR > tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
		// PANEL 1
		tabbedPane.addTab("Inscription", noIcon, panel1,"Inscriptions de Membres");
		// PANEL 2
		tabbedPane.addTab("Snacks / Boisson", noIcon, panel2,"Ventes de Snacks et Boissons et Autres");
		// PANEL 3
		tabbedPane.addTab("Sandwichs", noIcon, panel3,"Ventes de Sandwichs");
		// PANEL 4
		if(grp > 0)
		{
			tabbedPane.addTab("Stocks", noIcon, panel4,"Gestion des Stocks");
		}
		if(grp > 1)
		{
			// PANEL 5
			tabbedPane.addTab("Caisse", noIcon, panel5,"Gestion de la Caisse");
			// PANEL 6		
			tabbedPane.addTab("Produits", noIcon, panel6,"Gestion des Produits en vente");
		}

		add(tabbedPane);

		// Title / Size / Location
		setTitle("- ADEM POS -");
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // en quittant, il dispose la class
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}
}
