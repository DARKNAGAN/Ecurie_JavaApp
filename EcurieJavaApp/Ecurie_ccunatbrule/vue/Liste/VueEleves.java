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
import controleur.Eleve;
import modele.ModeleEleve;

public class VueEleves extends JPanel implements ActionListener
{
	private static final long serialVersionUID = -3553328743149224396L;
	private JLabel titre = new JLabel(" Liste des élèves ");
	private JTable tableEleves;
	public VueEleves () {
		this.setBounds(30, 80, 720, 330);
		this.setLayout(null);
		this.setBackground(new Color(222,220,203));
		this.titre.setBounds(250, 0, 300, 50);
		this.add(this.titre);
		this.titre.setFont(new Font(this.titre.getText(), Font.CENTER_BASELINE, 20));
		String titres [] = {"ID", "Privilege", "Record", "Pseudo", "Prénom", "Nom", "Sexe", "Âge", "Adresse", "MDP", "Email", "Galop", "Image"};
		this.tableEleves = new JTable(this.extraireEleves(), titres);
		JScrollPane uneScroll  = new JScrollPane(this.tableEleves);
		uneScroll.setBounds(10, 50, 700, 270);
		this.add(uneScroll);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	//extraire les Eleves 
	public Object [][] extraireEleves () {
		ArrayList <Eleve> lesEleves = ModeleEleve.selectAll();
		Object [][] donnees = new Object [lesEleves.size()][13];
		int i =0;
		for (Eleve unEleve : lesEleves) {
			donnees[i][0] = unEleve.getId();
			donnees[i][1] = unEleve.getPrivilege();
			donnees[i][2] = unEleve.getRecord();
			donnees[i][3] = unEleve.getPseudo();
			donnees[i][4] = unEleve.getPrenom();
			donnees[i][5] = unEleve.getNom();
			donnees[i][6] = unEleve.getSexe();
			donnees[i][7] = unEleve.getAge();
			donnees[i][8] = unEleve.getAdresse();
			donnees[i][9] = unEleve.getMdp();
			donnees[i][10] = unEleve.getMail();
			donnees[i][11] = unEleve.getGalop();
			donnees[i][12] = unEleve.getImageEleve();
			i++;
		}
		return donnees;
	}
}