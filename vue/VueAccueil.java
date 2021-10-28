package vue;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controleur.Formateur;

public class VueAccueil extends JPanel
{
	private static final long serialVersionUID = -3549267272035293251L;
	public VueAccueil(Formateur unFormateur)
	{
		this.setBounds(30, 80, 720, 330);
		this.setBackground(new Color(222,220,203));
		this.setLayout(null);
		JLabel lbFormateur = new JLabel("Accueil / Votre Formateur");
		lbFormateur.setBounds(250, 0, 300, 50);
		lbFormateur.setFont(new Font(lbFormateur.getText(), Font.CENTER_BASELINE + Font.BOLD, 20));
		JTextArea txtTitre = new JTextArea();
		txtTitre.setBounds(30, 50, 660, 250);
		//txtTitre.setBounds(x, y, width, height);
		txtTitre.setEditable(false);
		txtTitre.setBackground(new Color(197,196,180));
		txtTitre.setFont(new Font(txtTitre.getText(), Font.PLAIN, 16));
		// txtTitre.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		txtTitre.setText( "\n Nom :          " + "" + unFormateur.getNom()
						+ "\n Prénom :     " + "" + unFormateur.getPrenom()
						+ "\n Age :        " + "" + unFormateur.getAge()
						+ "\n Sexe :       " + "" + unFormateur.getSexe()
						+ "\n Galop :      " + "" + unFormateur.getGalop()
						+ "\n Privilege :  " + "" + unFormateur.getPrivilege());
		this.add(lbFormateur);
		this.add(txtTitre);
		this.setVisible(true);
	}
}