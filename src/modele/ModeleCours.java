package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Cours;

public class ModeleCours 
{
	public static ArrayList<Cours> selectAll()
	{
		ArrayList<Cours> lesCours = new ArrayList<Cours>();
		String requete = "SELECT GestionCours.*, Cours.*, CONCAT(Cours.heuredebut,' - ',Cours.heurefin) AS heure , CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur, CONCAT(Eleve.nom,' ', Eleve.prenom) AS eleve,Cheval.nom AS cheval FROM GestionCours\n"
				+ "INNER JOIN Eleve ON GestionCours.ideleve = Eleve.ideleve INNER JOIN Cheval ON GestionCours.idcheval = Cheval.idcheval\n"
				+ "INNER JOIN Cours ON GestionCours.idcours = Cours.idcours INNER JOIN Formateur ON Cours.idformateur = Formateur.idformateur;";
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				int idcours = unRes.getInt("GestionCours.idcours");
				int ideleve = unRes.getInt("ideleve");
				int idcheval = unRes.getInt("idcheval");
				int idformateur = unRes.getInt("idformateur");
				String note = unRes.getString("note");
				String heuredebut = unRes.getString("heuredebut");
				String heurefin = unRes.getString("heurefin");
				String datecours = unRes.getString("datecours");
				String heure = unRes.getString("heure");
				String formateur = unRes.getString("formateur");
				String eleve = unRes.getString("eleve");
				String nomcheval = unRes.getString("cheval");
				Cours unCours = new Cours(idcours, ideleve, idcheval, idformateur, datecours, note, heuredebut, heurefin, heure, formateur, eleve, nomcheval);
				lesCours.add(unCours);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return lesCours;
	}
public static void insert(Cours unCours)
{
	String requete = "insert into Cours (datecours, heuredebut, heurefin ) values ('" 
			+ unCours.getDateCours() + "', '" 
			+ unCours.getHeureDebut() + "', '" 
			+ unCours.getHeureFin() + "');";
	try {
		BDD uneBDD = new BDD();
		uneBDD.seConnecter();
		
		Statement unStat = uneBDD.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		uneBDD.seDeconnecter();
	}
	catch(SQLException exp)
	{
		System.out.println("Erreur d'execution de la requete " + requete);
	}
}
public static void delete(String datecours, String heuredebut) {
	String requete = "delete from Cours where datecours='" + datecours + "AND heuredebut='" + heuredebut + "';";
	try {
		BDD uneBDD = new BDD();
		uneBDD.seConnecter();
		
		Statement unStat = uneBDD.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		uneBDD.seDeconnecter();
	}
	catch(SQLException exp) {
		System.out.println("Erreur d'execution de la requete " + requete);
	}
}
public static Cours selectWhere(String datecours/*, String heuredebut, String heurefin*/)
{
	String requete = "SELECT GestionCours.*, Cours.*, CONCAT(Cours.heuredebut,' - ',Cours.heurefin) AS heure , CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur, CONCAT(Eleve.nom,' ', Eleve.prenom) AS eleve,Cheval.nom AS cheval FROM GestionCours\n"
			+ "INNER JOIN Eleve ON GestionCours.ideleve = Eleve.ideleve INNER JOIN Cheval ON GestionCours.idcheval = Cheval.idcheval\n"
			+ "INNER JOIN Cours ON GestionCours.idcours = Cours.idcours INNER JOIN Formateur ON Cours.idformateur = Formateur.idformateur\n"
			+ "WHERE datecours='" + datecours + "';";
	Cours unCours = null;
	try {
		BDD uneBDD = new BDD();
		uneBDD.seConnecter();
		Statement unStat = uneBDD.getMaConnexion().createStatement();
		ResultSet unRes = unStat.executeQuery(requete);
		if(unRes.next())
		{
			int idcours = unRes.getInt("GestionCours.idcours");
			int ideleve = unRes.getInt("ideleve");
			int idcheval = unRes.getInt("idcheval");
			int idformateur = unRes.getInt("idformateur");
			//datecours
			String note = unRes.getString("note");
			String heuredebut = unRes.getString("heuredebut");
			String heurefin = unRes.getString("heurefin");
			String heure = unRes.getString("heure");
			String formateur = unRes.getString("formateur");
			String eleve = unRes.getString("eleve");
			String nomcheval = unRes.getString("cheval");
			unCours = new Cours(idcours, ideleve, idcheval, idformateur, datecours, note, heuredebut, heurefin, heure, formateur, eleve, nomcheval);
		}
		unStat.close();
		unRes.close();
		uneBDD.seDeconnecter();
	}
	catch(SQLException exp) {
		System.out.println("Erreur d'execution de la requete " + requete);
	}
	return unCours;
	}

//Extraire les Cours
public static Object [][] extraireCours ()
{
	ArrayList <Cours> lesCours = ModeleCours.selectAll();
	Object [][] donnees = new Object [lesCours.size()][5];
	int i =0;
	for (Cours unCours : lesCours)
	{
		donnees[i][0] = unCours.getDateCours();
		donnees[i][1] = unCours.getHeure();
		donnees[i][2] = unCours.getFormateur();
		donnees[i][3] = unCours.getEleve();
		donnees[i][4] = unCours.getnomCheval();
		i++;
	}
	return donnees;
}
}