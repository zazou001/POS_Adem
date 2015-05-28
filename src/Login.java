/* ---------- ---------- ----------
 * 			  Login.java
 * 
 * Author : Cyril Meyer
 * 
 * Historical :
 * 		Creation   : 28/05/2015
 * 		Last Modif : 28/05/2015
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
import javax.swing.*;

public class Login extends JFrame
{
    Login()
    {
		initGUI();
		System.out.println("- LOGIN -");
    }
    
    private void initGUI()
    {
		setTitle("- ADEM POS -");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}
    
}
