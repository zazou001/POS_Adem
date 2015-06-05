/* ---------- ---------- ----------
 * 			  Login.java
 * 
 * Author : Cyril Meyer
 * 
 * Historical :
 * 		Creation   : 28/05/2015
 * 		Last Modif : 05/06/2015
 * 
 * Synopsis :
 * 	Interface utilisateur
 * permettant la connexion des users
 * et le lancement du POS
 * 
 * Database : 
 * 	Utilise table login dans la 
 * db adem.
 * ╔══════╦══════╦═════╗
 * ║ TEXT ║ TEXT ║ INT ║
 * ╠══════╬══════╬═════╣
 * ║ USER ║ PASS ║ GRP ║
 * ╚══════╩══════╩═════╝
 * ---------- ---------- ---------- */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame
{
	// POUR EVITER L'ERREUR
	// warning: [serial] serializable class Login has no definition of serialVersionUID
	private static final long serialVersionUID = 42L;
	
    Login()
    {
		initGUI();
		System.out.println("- LOGIN -");
    }
    
    /*
     * void initGUI()
     * Initialise la GUI
     * label, textbox, button
     */
    private void initGUI()
    {
        // PANEL
        final JPanel panel = new JPanel();
        final JPanel topPanel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.setLayout(new GridLayout(2, 2));
        
        // Label / TextField / Button
		final JLabel label1 = new JLabel("User :");
		final JTextField user = new JTextField("adem", 42);
		final JLabel label2 = new JLabel("Pass :");
		final JTextField pass = new JTextField("adem", 42);
		final JButton connexion = new JButton("Connexion");
		
		// Add to panel
		topPanel.add(label1);
		topPanel.add(user);
		topPanel.add(label2);
		topPanel.add(pass);
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(connexion, BorderLayout.SOUTH);
		add(panel);
		
		// ACTION DU BUTTON
		connexion.addActionListener(new ActionListener()
        {
            //@Override
            public void actionPerformed(ActionEvent event)
            {
				// VERIFICATION DU USER / PASS
				if(verif(user.getText(),pass.getText()))
				{
					JOptionPane.showMessageDialog(null, "User / Pass - Valid");
					
					// setVisible ne fonctionne pas < A VOIR !
					//this.setVisible(false);
					new GuiPOS(user.getText(),pass.getText(), getGroup(user.getText(),pass.getText()));
					//this.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "User / Pass - Invalid");
				}
            }
        });
        
		// Title / Size / Location
		setTitle("- ADEM POS CONNEXION -");
        setSize(300, 120);
        setLocationRelativeTo(null);
        
        // en quittant, il dispose la class
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}

	// --------- TODO ---------
	private boolean verif(String user, String pass)
	{
		if(user.equals(pass))
			return true;
		else
			return false;
	}
	private int getGroup(String user, String pass)
	{
		return 2;
	}
}
