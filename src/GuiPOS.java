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
import javax.swing.table.*;

public class GuiPOS extends JFrame
{
	// POUR EVITER L'ERREUR
	// warning: [serial] serializable class GuiPOS has no definition of serialVersionUID
	private static final long serialVersionUID = 42L;
	
	private String user;
	private String pass;
	private int grp = 0;
	private POS POSfunc;
	BDD adem;
	
	
    GuiPOS(String user, String pass, int grp, BDD adem)
    {
		POSfunc = new POS(adem);
		this.grp = grp;
		this.user = user;
		this.pass = pass;
		this.adem = adem;
		initGUI();
    }
    
    private void initGUI()
    {
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon noIcon = new ImageIcon("img/no.gif", "NO_ICON");
		ImageIcon icon1 = new ImageIcon(new ImageIcon("../img/inscriptions.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon2 = new ImageIcon(new ImageIcon("../img/snacks.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon3 = new ImageIcon(new ImageIcon("../img/sandwichs.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon4 = new ImageIcon(new ImageIcon("../img/stocks.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon5 = new ImageIcon(new ImageIcon("../img/trez.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		ImageIcon icon6 = new ImageIcon(new ImageIcon("../img/list.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		
		// ------------------------- DATA -------------------------
		List<String> produitList = new ArrayList<String>();
		List<Snack> produitListDetails = new ArrayList<Snack>();
		List<String> sandwichsList = new ArrayList<String>();
		
		produitList = adem.getSnackList();
		produitListDetails = adem.getSnackListDetails();
		sandwichsList = adem.getSandwichsList();		// TODO
		
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
		final JLabel panel1label5 = new JLabel("Année Naissance :");
		final JTextField panel1naissance = new JTextField(84);
		final JLabel panel1label6 = new JLabel("Email :");
		final JTextField panel1email = new JTextField(84);
		panel1.add(panel1label1);
		panel1.add(panel1nom);
		panel1.add(panel1label2);
		panel1.add(panel1prenom);
		panel1.add(panel1label3);
		panel1.add(panel1annee);
		panel1.add(panel1label5);
		panel1.add(panel1naissance);
		panel1.add(panel1label6);
		panel1.add(panel1email);
		panel1.add(panel1label4);
		panel1.add(panel1valider);
		// Bouton de validation
		panel1valider.addActionListener(new ActionListener()
        {
            //@Override
            public void actionPerformed(ActionEvent event)
            {
				POSfunc.ajoutMembre(panel1nom.getText(), panel1prenom.getText(), panel1annee.getSelectedItem().toString(), panel1naissance.getText(), panel1email.getText());
				panel1nom.setText("");
				panel1prenom.setText("");
				panel1naissance.setText("");
				panel1email.setText("");
				panel1annee.setSelectedIndex(0);
            }
        });
		
		// ------------------------- PANEL 2 -------------------------
		final JPanel panel2 = new JPanel();
		final JPanel panel21 = new JPanel();
		final JPanel panel22 = new JPanel();
		// LISTE
		/*
		final String[] panel2tablecolNames = { " Noms ", " Prix / µ ", " Nombre " };
		final Object[][] panel2tabledata = {};
		final JTable panel2table = new JTable(panel2tabledata, panel2tablecolNames);
		* */
		final DefaultTableModel panel2model = new DefaultTableModel();
		JTable panel2table = new JTable(panel2model);
		panel2model.addColumn(" Noms ");
		panel2model.addColumn(" Prix / µ ");
		panel2model.addColumn(" Nombre ");
		
		final JPanel panel2l = new JPanel();
        panel2l.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel2l.setLayout(new BorderLayout());
		panel2l.add(panel2table.getTableHeader(), BorderLayout.NORTH);
		panel2l.add(panel2table, BorderLayout.SOUTH);
		
        panel2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel2.setLayout(new BorderLayout());
        panel21.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel22.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane(panel2table);
		panel2l.add(scrollPane);
        final List<JButton> panel2btn = new ArrayList<JButton>();
        
        panel21.setLayout(new GridLayout(produitList.size()/4, 4));
        panel22.setLayout(new GridLayout(1, 2));
		
        for(int i=0; i<produitList.size(); i++)
		{
			panel2btn.add(new JButton(produitList.get(i)));	
		}
        for(int i=0; i<panel2btn.size(); i++)
		{
			panel21.add(panel2btn.get(i));	
		}
        for(int i=0; i<panel2btn.size(); i++)
		{
			final int z = i;
			final Snack s = produitListDetails.get(i);
			panel2btn.get(i).addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					panel2model.addRow(new Object[] { panel2btn.get(z).getText(), s.prix, "1" });
				}
			});
		}

		final JButton panel2valider = new JButton("Valider");
		final JButton panel2clear = new JButton("Clear");
		panel2valider.addActionListener(new ActionListener()
        {
            //@Override
            public void actionPerformed(ActionEvent event)
            {
				while(panel2model.getRowCount()>0)
				{
					System.out.println(panel2model.getValueAt(0, 0));
					System.out.println(panel2model.getValueAt(0, 1));
					System.out.println(panel2model.getValueAt(0, 2));
					panel2model.removeRow(0);
				}
			}
        });
		panel2clear.addActionListener(new ActionListener()
        {
            //@Override
            public void actionPerformed(ActionEvent event)
            {
				while(panel2model.getRowCount()>0)
				{
					panel2model.removeRow(0);
				}
            }
        });
		panel22.add(panel2valider);
		panel22.add(panel2clear);
        
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel2l, BorderLayout.CENTER);
		panel2.add(panel22, BorderLayout.SOUTH);
		
		// ------------------------- PANEL 3 -------------------------
		final JPanel panel3 = new JPanel();
		final JPanel panel31 = new JPanel();
		final JPanel panel32 = new JPanel();
		
		panel3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel3.setLayout(new BorderLayout());
        panel31.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel32.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel31.setLayout(new GridLayout(sandwichsList.size(), 2));
        panel32.setLayout(new GridLayout(1, 1));
		
		final List<JLabel> panel3label = new ArrayList<JLabel>();
		final List<JTextField> panel3text = new ArrayList<JTextField>();
		final List<JComboBox<String>> panel3combo = new ArrayList<JComboBox<String>>();
		String[] panel3etat = {"", "Réservé", "Donné", "Vendu"};
			
        for(int i=0; i<sandwichsList.size(); i++)
		{
			panel3label.add(new JLabel(sandwichsList.get(i)));
			panel3combo.add(new JComboBox<String>(panel3etat));
			panel3text.add(new JTextField());
			
			final int z = i;
			//final Snack s = produitListDetails.get(i);
			panel3combo.get(i).addActionListener
				(
                new ActionListener()
					{
                    public void actionPerformed(ActionEvent e)
						{
							String s = (String) panel3combo.get(z).getSelectedItem();
							switch (s)
							{
								case "Vendu":
									panel3text.get(z).setText("Vendu");                           
									break;      
								case "Donné":
									panel3text.get(z).setText("Donné");                           
									break;                       
							}
						}
					}            
				);
		}
		for(int i=0; i<sandwichsList.size(); i++)
		{
			panel31.add(panel3label.get(i));
			panel31.add(panel3combo.get(i));
			panel31.add(panel3text.get(i));
		}
		
		final JButton panel3valider = new JButton("Valider");
		panel32.add(panel3valider);
		
		panel3.add(panel31, BorderLayout.NORTH);
		panel3.add(panel32, BorderLayout.SOUTH);
		
		
		// ------------------------- PANEL 4 --------------------------------------------------
		final JPanel panel4 = new JPanel();
		final JPanel panel41 = new JPanel();
		final JPanel panel42 = new JPanel();
		
		panel4.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel4.setLayout(new BorderLayout());
        panel41.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel42.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel41.setLayout(new GridLayout(produitList.size()/2, 4));
        panel42.setLayout(new GridLayout(1, 1));
		
		final List<JLabel> panel4label = new ArrayList<JLabel>();
		final List<JTextField> panel4text = new ArrayList<JTextField>();
		
        for(int i=0; i<produitList.size(); i++)
		{
			panel4label.add(new JLabel(produitList.get(i)));
			panel4text.add(new JTextField());
		}
		for(int i=0; i<produitList.size(); i++)
		{
			panel41.add(panel4label.get(i));
			panel41.add(panel4text.get(i));
		}
		
		final JButton panel4valider = new JButton("Valider");
		panel42.add(panel4valider);
		
		panel4.add(panel41, BorderLayout.NORTH);
		panel4.add(panel42, BorderLayout.SOUTH);
		// ------------------------- FIN PANEL 4 ----------------------------------------------
		// ------------------------- PANEL 5 --------------------------------------------------
		final JPanel panel5 = new JPanel();
		// ------------------------- FIN PANEL 5 ----------------------------------------------
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
