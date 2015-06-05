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
    {/*
		JTabbedPane tabbedPane = new JTabbedPane();
		//ImageIcon icon = createImageIcon("img/no.gif");
		JComponent panel1 = makeTextPanel("Panel #1");
		tabbedPane.addTab("Tab 1",panel);*/

		// Title / Size / Location
		setTitle("- ADEM POS -");
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // en quittant, il dispose la class
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}
}
