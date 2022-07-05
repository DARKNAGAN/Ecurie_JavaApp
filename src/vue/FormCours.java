package vue;

import java.awt.*;
import javax.swing.*;

public class FormCours extends JPanel
{
	private static final long serialVersionUID = 3315083316143792281L;
	JPanel panel = new JPanel();
	JLabel lbCours = new JLabel("Votre Profil");
	JTextArea txtTitre = new JTextArea();


	public FormCours()
	{
		this.setPreferredSize(new Dimension(500, 300));
		this.setBackground(new Color(222,220,203));
		this.setLayout(null);
		lbCours.setFont(new Font(lbCours.getText(), Font.CENTER_BASELINE + Font.BOLD, 20));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(lbCours);
		txtTitre.setText("\n Date : A");
		txtTitre.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtTitre.setEditable(false);
		txtTitre.setBackground(new Color(222, 220, 203));		
		panel.add(txtTitre);
		
		this.setVisible(true);
	}
}