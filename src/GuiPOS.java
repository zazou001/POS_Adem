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
import java.util.List;
import java.util.ArrayList;

public class GuiPOS extends JFrame
{
	// POUR EVITER L'ERREUR
	// warning: [serial] serializable class GuiPOS has no definition of serialVersionUID
	private static final long serialVersionUID = 42L;
	
	private int grp = 0;
	private POS POSfunc;
	
    GuiPOS(String user, String pass, int grp)
    {
		POSfunc = new POS();
		this.grp = grp;
		initGUI();
    }
    
    private void initGUI()
    {
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon noIcon = new ImageIcon("img/no.gif", "NO_ICON");
		ImageIcon icon1 = new ImageIcon(new ImageIcon("img/inscriptions.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon2 = new ImageIcon(new ImageIcon("img/snacks.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon3 = new ImageIcon(new ImageIcon("img/sandwichs.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon4 = new ImageIcon(new ImageIcon("img/stocks.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon5 = new ImageIcon(new ImageIcon("img/trez.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon6 = new ImageIcon(new ImageIcon("img/list.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		
		// ------------------------- PANEL 1 -------------------------
		final JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel1.setLayout(new GridLayout(16,1));
		
		final JLabel panel1label1 = new JLabel("Nom :");
		final JTextField panel1nom = new JTextField(42);
		final JLabel panel1label2 = new JLabel("Prenom :");
		final JTextField panel1prenom = new JTextField(42);
		final JLabel panel1label3 = new JLabel("Année D’études :");
		String[] panel1anneeStrings = { "L1", "L2MATH", "L3MATH", "L2INFO", "L3INFO", "AUTRES"};
		final JComboBox<String> panel1annee = new JComboBox<String>(panel1anneeStrings);
		final JLabel panel1label4 = new JLabel("");
		final JButton panel1valider = new JButton("Valider");
		panel1.add(panel1label1);
		panel1.add(panel1nom);
		panel1.add(panel1label2);
		panel1.add(panel1prenom);
		panel1.add(panel1label3);
		panel1.add(panel1annee);
		panel1.add(panel1label4);
		panel1.add(panel1valider);
		// Bouton de validation
		panel1valider.addActionListener(new ActionListener()
        {
            //@Override
            public void actionPerformed(ActionEvent event)
            {
				POSfunc.ajoutMembre(panel1nom.getText(), panel1prenom.getText(), panel1annee.getSelectedItem().toString());
            }
        });
		
		// ------------------------- PANEL 2 -------------------------
		final JPanel panel2 = new JPanel();
		final JPanel panel21 = new JPanel();
		final JPanel panel22 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel2.setLayout(new BorderLayout());
        panel21.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel22.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel21.setLayout(new GridLayout(16, 4));
        panel22.setLayout(new GridLayout(1, 1));
        
        List<JButton> panel2btn = new ArrayList<JButton>();
        List<String> produitList = new ArrayList<String>();
        // POUR TEST
        for(int i=0; i<42; i++)
		{
			produitList.add("PRODUIT" + i);	
		}
        for(int i=0; i<produitList.size(); i++)
		{
			panel2btn.add(new JButton(produitList.get(i)));	
		}
        for(int i=0; i<panel2btn.size(); i++)
		{
			panel21.add(panel2btn.get(i));	
		}
        /*
        JList<String> panel2list = new JList<String>();
		panel2list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		panel2list.setLayoutOrientation(JList.VERTICAL_WRAP);
		panel2list.setVisibleRowCount(5);
        panel21.add(panel2list);*/

		final JButton panel2valider = new JButton("Valider");
		panel22.add(panel2valider);
        
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.SOUTH);
		
		
		final JPanel panel3 = new JPanel();
		final JPanel panel4 = new JPanel();
		final JPanel panel5 = new JPanel();
		final JPanel panel6 = new JPanel();
		
		// A VOIR > tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
		// PANEL 1
		tabbedPane.addTab("Inscription", icon1, panel1,"Inscriptions de Membres");
		// PANEL 2
		tabbedPane.addTab("Snacks / Boisson", icon2, panel2,"Ventes de Snacks et Boissons et Autres");
		// PANEL 3
		tabbedPane.addTab("Sandwichs", icon3, panel3,"Ventes de Sandwichs");
		// PANEL 4
		if(grp > 0)
		{
			tabbedPane.addTab("Stocks", icon4, panel4,"Gestion des Stocks");
		}
		if(grp > 1)
		{
			// PANEL 5
			tabbedPane.addTab("Caisse", icon5, panel5,"Gestion de la Caisse");
			// PANEL 6		
			tabbedPane.addTab("Produits", icon6, panel6,"Gestion des Produits en vente");
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
