package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Connexion extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 370051638025645700L;

	public Connexion()
	{	
		this.setIconImage(new ImageIcon("src/images//favicon.png").getImage());//logo fenetre
		this.setTitle("Ecurie");//titre fenetre
		this.setBounds(400, 300, 500, 300);//format fenetre 
		this.getContentPane().setBackground(new Color(247,245,226));//Couleur fenetre RGB

		
		this.setLayout(null); // pas de grille
		this.setResizable(false); // la fenètre ne pourra pas être redimensionnée
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon logo = new ImageIcon(new ImageIcon("src/images/logo.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT));//logo page L/l
		JLabel lbLogo = new JLabel(logo); 	
		lbLogo.setBounds(170, 10, 350, 100);//position logo page  GuaucheBasLargeurHauteur
		this.add(lbLogo);
		JLabel lbTitre = new JLabel("Connexion");//titre page
		lbTitre.setBounds(170, 10, 350, 50);// position titre page
		lbTitre.setFont(new Font(lbTitre.getText(), Font.CENTER_BASELINE, 20));// taille titre page
		this.add(lbTitre);
		
		this.add(new VueConnexion());//insertion VueConnexion
		
		this.setVisible(true);
	}
	
	public void rendreVisible(boolean val)
	{
		this.setVisible(val);
	}
}
