package vue.Formulaire;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controleur.Cours;

public class FormCours extends JPanel
{
	private static final long serialVersionUID = 3315083316143792281L;
	public FormCours()
	{
		this.setBounds(30, 80, 720, 330);
		this.setBackground(new Color(222,220,203));
		this.setLayout(null);
		JLabel lbCours = new JLabel("Votre Profil");
		lbCours.setBounds(350, 5, 300, 50);
		lbCours.setFont(new Font(lbCours.getText(), Font.CENTER_BASELINE + Font.BOLD, 20));
		this.add(lbCours);
		JTextArea txtTitre = new JTextArea();
		txtTitre.setBounds(20, 50, 300, 400);
		//txtTitre.setBounds(x, y, width, height);
		txtTitre.setEditable(false);
		txtTitre.setBackground(new Color(222,220,203));
		txtTitre.setFont(new Font(txtTitre.getText(), Font.PLAIN, 20));
		// txtTitre.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		txtTitre.setText( "\n Date : A");
		this.add(txtTitre);
		this.setVisible(true);
	}
}