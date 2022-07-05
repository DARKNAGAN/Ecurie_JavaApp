package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Cheval;

public class ModeleCheval {
	public static ArrayList<Cheval> selectAll()	{
		ArrayList<Cheval> lesChevaux = new ArrayList<Cheval>();
		String requete = "select * from Cheval;";
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				int id = unRes.getInt("idcheval");
				String nom = unRes.getString("nom");
				String sexe = unRes.getString("sexe");
				String robe = unRes.getString("robe");
				String type = unRes.getString("type");
				String race = unRes.getString("race");
				String proprietaire = unRes.getString("proprietaire");
				int age = unRes.getInt("age");
				String image = unRes.getString("imagecheval");
				Cheval unCheval = new Cheval(id, nom, sexe, robe, type, race, proprietaire, age, image);
				lesChevaux.add(unCheval);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return lesChevaux;
	}
	public static Cheval selectWhere(String nom) {
		String requete = "select * from Cheval where nom='" + nom + "';";
		Cheval unCheval = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("idcheval");	
				//Nom
				String sexe = unRes.getString("sexe");
				String robe = unRes.getString("robe");
				String type = unRes.getString("type");
				String race = unRes.getString("race");
				String proprietaire = unRes.getString("proprietaire");
				int age = unRes.getInt("age");
				String image = unRes.getString("imagecheval");
				unCheval = new Cheval(id, nom, sexe, robe, type, race, proprietaire, age, image);
				}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unCheval;
	}
	public static void insert(Cheval unCheval) {
		String requete = "insert into Cheval (nom, sexe, robe, type, race, proprietaire, age, imagecheval) values ('" 
				+ unCheval.getNom() + "', '" 
				+ unCheval.getSexe() + "', '" 
				+ unCheval.getRobe() + "', '" 
				+ unCheval.getType() + "', '" 
				+ unCheval.getRace() + "', '" 
				+ unCheval.getProprietaire() + "', '" 
				+ unCheval.getAge() + "', '"
				+ "/images/chevaux/img_cheval.jpg');";
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
	public static void delete(String nom) {
		String requete = "delete from Cheval where nom='" + nom + "';";
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
}