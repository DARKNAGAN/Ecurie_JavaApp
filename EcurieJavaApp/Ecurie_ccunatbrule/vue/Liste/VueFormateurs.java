package vue.Liste;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controleur.Formateur;
import modele.ModeleFormateur;

public class VueFormateurs extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 7809272439139152072L;
	private JLabel titre = new JLabel(" Liste des Formateurs ");
	private JTable tableFormateurs;
	public VueFormateurs ()
	{
		this.setBounds(30, 80, 720, 330);
		this.setLayout(null);
		this.setBackground(new Color(222,220,203));
		this.titre.setBounds(250, 0, 300, 50);
		this.titre.setFont(new Font(this.titre.getText(), Font.CENTER_BASELINE, 20));
		String titres [] = {"ID","Login", "Privilege", "Prénom", "Nom", "Age", "Galop", "Sexe", "Email", "MDP"};
		this.tableFormateurs = new JTable(this.extraireFormateurs(), titres);
		JScrollPane uneScroll  = new JScrollPane(this.tableFormateurs);
		uneScroll.setBounds(10, 50, 700, 270);
		this.add(this.titre);
		this.add(uneScroll);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	//extraire les Formateurs 
	public Object [][] extraireFormateurs () {
		ArrayList <Formateur> lesFormateurs = ModeleFormateur.selectAll();
		Object [][] donnees = new Object [lesFormateurs.size()][10];
		int i =0;
		for (Formateur unFormateur : lesFormateurs)
		{
			donnees[i][0] = unFormateur.getId();
			donnees[i][1] = unFormateur.getLogin();
			donnees[i][2] = unFormateur.getPrivilege();
			donnees[i][3] = unFormateur.getPrenom();
			donnees[i][4] = unFormateur.getNom();
			donnees[i][5] = unFormateur.getAge();
			donnees[i][6] = unFormateur.getGalop();
			donnees[i][7] = unFormateur.getSexe();
			donnees[i][8] = unFormateur.getMail();
			donnees[i][9] = unFormateur.getMdp();
			i++;
		}
		return donnees;
	}
}