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
import controleur.Cours;
import modele.ModeleCours;

public class VueCours extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 8159114212204714346L;
	private JLabel titre = new JLabel(" Liste des Cours ");
	private JTable tableCours;
	public VueCours ()
	{
		this.setBounds(30, 80, 720, 330);
		this.setLayout(null);
		this.setBackground(new Color(222,220,203));
		this.titre.setBounds(250, 0, 300, 50);
		this.add(this.titre);
		this.titre.setFont(new Font(this.titre.getText(), Font.CENTER_BASELINE, 20));
		String titres [] = {"ID du cours", "Date du cours", "Début à", "Fin à","Nombre élèves"};
		this.tableCours = new JTable(this.extraireCours(), titres);
		JScrollPane uneScroll  = new JScrollPane(this.tableCours);
		uneScroll.setBounds(10, 50, 700, 270);
		this.add(uneScroll);
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	//Extraire les Cours
	public Object [][] extraireCours ()
	{
		ArrayList <Cours> lesCours = ModeleCours.selectAll();
		Object [][] donnees = new Object [lesCours.size()][5];
		int i =0;
		for (Cours unCours : lesCours)
		{
			donnees[i][0] = unCours.getIdCours();
			donnees[i][1] = unCours.getDateCours();
			donnees[i][2] = unCours.getHeureDebut();
			donnees[i][3] = unCours.getHeureFin();
			i++;
		}
		return donnees;
	}
}