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
		String requete = "select * from Cours;";
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				int idcours = unRes.getInt("idcours");	
				String datecours = unRes.getString("datecours");
				String heuredebut = unRes.getString("heuredebut");
				String heurefin = unRes.getString("heurefin");
				Cours unCours = new Cours(idcours, datecours, heuredebut, heurefin);
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
public static Cours selectWhere(String datecours, String heuredebut)
{
	String requete = "select * from Cours where datecours='" + datecours + "' and heuredebut='" + heuredebut + "';";
	Cours unCours = null;
	try {
		BDD uneBDD = new BDD();
		uneBDD.seConnecter();
		Statement unStat = uneBDD.getMaConnexion().createStatement();
		ResultSet unRes = unStat.executeQuery(requete);
		if(unRes.next())
		{
			String heurefin = unRes.getString("heurefin");
			unCours = new Cours(datecours, heuredebut, heurefin);
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
}