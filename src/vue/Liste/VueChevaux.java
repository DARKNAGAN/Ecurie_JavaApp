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
import controleur.Cheval;
import modele.ModeleCheval;

public class VueChevaux extends JPanel implements ActionListener
{
	private static final long serialVersionUID = -4880909934785926048L;
	private JLabel titre = new JLabel(" Liste des Chevaux ");
	private JTable tableChevaux;
	public VueChevaux () {
		this.setBounds(30, 80, 720, 330);
		this.setLayout(null);
		this.setBackground(new Color(222,220,203));
		this.titre.setBounds(250, 0, 300, 50);
		this.titre.setFont(new Font(this.titre.getText(), Font.CENTER_BASELINE, 20));
		String titres [] = {"ID", "Nom", "Sexe", "Robe", "Type", "Race", "Propriétaire", "Age", "Image"};
		this.tableChevaux = new JTable(this.extraireChevaux(), titres);
		JScrollPane uneScroll = new JScrollPane(this.tableChevaux);
		uneScroll.setBounds(10, 50, 700, 270);
		this.add(this.titre);
		this.add(uneScroll);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	//extraire les Chevaux 
	public Object [][] extraireChevaux () {
		ArrayList <Cheval> lesChevaux = ModeleCheval.selectAll();
		Object [][] donnees = new Object [lesChevaux.size()][9];
		int i =0;
		for (Cheval unCheval : lesChevaux) {
			donnees[i][0] = unCheval.getId();
			donnees[i][1] = unCheval.getNom();
			donnees[i][2] = unCheval.getSexe();
			donnees[i][3] = unCheval.getRobe();
			donnees[i][4] = unCheval.getType();
			donnees[i][5] = unCheval.getRace();
			donnees[i][6] = unCheval.getProprietaire();
			donnees[i][7] = unCheval.getAge();
			donnees[i][8] = unCheval.getImage();
			i++;
		}
		return donnees;
	}
}