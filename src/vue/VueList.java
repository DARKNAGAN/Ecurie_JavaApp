package vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controleur.Cheval;
import controleur.Cours;
import controleur.Eleve;
import controleur.Formateur;
import modele.ModeleCheval;
import modele.ModeleCours;
import modele.ModeleEleve;
import modele.ModeleFormateur;

public class VueList extends JPanel implements ActionListener
{
	private static final long serialVersionUID = -3553328743149224396L;
	private JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
	private JPanel elevesTab = new JPanel();
	private JPanel formateursTab = new JPanel();
	private JPanel chevauxTab = new JPanel();
	private JPanel coursTab = new JPanel();
	private JLabel titreEleve = new JLabel(" Liste des élèves ");
	private JTable tableEleves;
	private JLabel titreFormateur= new JLabel(" Liste des Formateurs ");
	private JTable tableFormateurs;
	private JLabel titreCheval = new JLabel(" Liste des Chevaux ");
	private JTable tableChevaux;
	private JLabel titreCour = new JLabel(" Liste des Cours ");
	private JTable tableCours;
	public VueList () {
		this.setBounds(30, 80, 720, 330);
		this.setBackground(new Color(222,220,203));
		this.add(onglets);
		onglets.setOpaque(true);
		onglets.setPreferredSize(new Dimension(700, 300));
		//Tab1	
		onglets.addTab("Liste Eleves", elevesTab);
		elevesTab.setBounds(30, 80, 720, 330);
		elevesTab.setLayout(null);
		elevesTab.setBackground(new Color(222,220,203));
		this.titreEleve.setBounds(250, 0, 300, 50);
		this.titreEleve.setFont(new Font(this.titreEleve.getText(), Font.CENTER_BASELINE, 20));
		String titresEleve [] = {"ID", "Privilege", "Record", "Pseudo", "Prénom", "Nom", "Sexe", "Âge", "Adresse", "MDP", "Email", "Galop", "Image"};
		this.tableEleves = new JTable(this.extraireEleves(), titresEleve);
		JScrollPane uneScrollEleve  = new JScrollPane(this.tableEleves);
		uneScrollEleve.setBounds(10, 50, 670, 200);
		elevesTab.add(this.titreEleve);
		elevesTab.add(uneScrollEleve);
		//Tab2
		onglets.addTab("Liste Formateurs", formateursTab);
		formateursTab.setBounds(30, 80, 720, 330);
		formateursTab.setLayout(null);
		formateursTab.setBackground(new Color(222,220,203));
		this.titreFormateur.setBounds(250, 0, 300, 50);
		this.titreFormateur.setFont(new Font(this.titreFormateur.getText(), Font.CENTER_BASELINE, 20));
		String titresFormateur [] = {"ID","Login", "Privilege", "Prénom", "Nom", "Age", "Galop", "Sexe", "Email", "MDP"};
		this.tableFormateurs = new JTable(this.extraireFormateurs(), titresFormateur);
		JScrollPane uneScrollFormateur  = new JScrollPane(this.tableFormateurs);
		uneScrollFormateur.setBounds(10, 50, 670, 200);
		formateursTab.add(this.titreFormateur);
		formateursTab.add(uneScrollFormateur);
		//Tab3
		onglets.addTab("Liste Chevaux", chevauxTab);
		chevauxTab.setBounds(30, 80, 720, 330);
		chevauxTab.setLayout(null);
		chevauxTab.setBackground(new Color(222,220,203));
		this.titreCheval.setBounds(250, 0, 300, 50);
		this.titreCheval.setFont(new Font(this.titreCheval.getText(), Font.CENTER_BASELINE, 20));
		String titresCheval [] = {"ID", "Nom", "Sexe", "Robe", "Type", "Race", "Propriétaire", "Age", "Image"};
		this.tableChevaux = new JTable(this.extraireChevaux(), titresCheval);
		JScrollPane uneScrollCheval = new JScrollPane(this.tableChevaux);
		uneScrollCheval.setBounds(10, 50, 670, 200);
		chevauxTab.add(this.titreCheval);
		chevauxTab.add(uneScrollCheval);
		//Tab4
		onglets.addTab("Liste Cours", coursTab);
		coursTab.setBounds(30, 80, 720, 330);
		coursTab.setLayout(null);
		coursTab.setBackground(new Color(222,220,203));
		this.titreCour.setBounds(250, 0, 300, 50);
		this.titreCour.setFont(new Font(this.titreCour.getText(), Font.CENTER_BASELINE, 20));
		String titresCour [] = {"ID du cours", "Date du cours", "Début à", "Fin à","Nombre élèves"};
		this.tableCours = new JTable(this.extraireCours(), titresCour);
		JScrollPane uneScrollCour  = new JScrollPane(this.tableCours);
		uneScrollCour.setBounds(10, 50, 670, 200);
		coursTab.add(this.titreCour);
		coursTab.add(uneScrollCour);
		//Fin Tab
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