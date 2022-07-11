package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Formateur;

public class ModeleFormateur 
{
	public static ArrayList<Formateur> selectAll() {
		ArrayList<Formateur> lesFormateurs = new ArrayList<Formateur>();
		String requete = "select *,CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur from Formateur;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int idformateur = unRes.getInt("idformateur");
					int privilege = unRes.getInt("privilege");
					String prenom = unRes.getString("prenom");
					String nom = unRes.getString("nom");
					int age = unRes.getInt("age");	
					int galop = unRes.getInt("galop");
					String sexe = unRes.getString("sexe");
					String mail = unRes.getString("adressemail");
					String mdp = unRes.getString("mdp");
					String formateur = unRes.getString("formateur");
					Formateur unFormateur = new Formateur(idformateur, privilege, prenom, nom, age, galop, sexe, mail, mdp, formateur);
					lesFormateurs.add(unFormateur);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesFormateurs;
	}
	public static Formateur selectWhere(String mail) {
		String requete = "select *,CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur from Formateur where adressemail='" + mail + "';";
		Formateur unFormateur = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idformateur = unRes.getInt("idformateur");
				int privilege = unRes.getInt("privilege");
				String prenom = unRes.getString("prenom");
				String nom = unRes.getString("nom");
				int age = unRes.getInt("age");
				int galop = unRes.getInt("galop");
				String sexe = unRes.getString("sexe");
				String mdp = unRes.getString("mdp");
				String formateur = unRes.getString("formateur");
				// adressemail
				unFormateur = new Formateur(idformateur, privilege, prenom, nom, age, galop, sexe, mail, mdp, formateur);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unFormateur;
	}
	public static Formateur selectCompte(String mail, String mdp) {
		String requete = "select *,CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur from Formateur where adressemail='" + mail + "' and mdp='" + mdp + "';";
		Formateur unFormateur = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idformateur = unRes.getInt("idformateur");
				int privilege = unRes.getInt("privilege");
				String prenom = unRes.getString("prenom");
				String nom = unRes.getString("nom");
				int age = unRes.getInt("age");
				int galop = unRes.getInt("galop");
				String sexe = unRes.getString("sexe");
				String formateur = unRes.getString("formateur");
				// adressemail & mdp
				unFormateur = new Formateur(idformateur, privilege, prenom, nom, age, galop, sexe, mail, mdp, formateur);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unFormateur;
	}
	public static void insert(Formateur unFormateur) {
			String requete = "insert into Formateur (privilege, prenom, nom, age, galop, sexe, adressemail, mdp) values ('"
					+ unFormateur.getPrivilege() + "', '"
					+ unFormateur.getPrenom() + "', '"
					+ unFormateur.getNom() + "', '"
					+ unFormateur.getAge() + "', '"
					+ unFormateur.getGalop() + "', '"
					+ unFormateur.getSexe() + "', '"
					+ unFormateur.getMail() + "', '"
					+ unFormateur.getMdp() + "');";
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
	public static void delete(String mail) {
			String requete = "delete from Formateur where adressemail='" + mail + "';";
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
	
	public static ArrayList<Formateur> selectChoose() {
		ArrayList<Formateur> lesFormateurs = new ArrayList<Formateur>();
		String requete = "select *,CONCAT(Formateur.nom,' ', Formateur.prenom) AS formateur from Formateur;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int idformateur = unRes.getInt("idformateur");
					int privilege = unRes.getInt("privilege");
					String prenom = unRes.getString("prenom");
					String nom = unRes.getString("nom");
					int age = unRes.getInt("age");	
					int galop = unRes.getInt("galop");
					String sexe = unRes.getString("sexe");
					String mail = unRes.getString("adressemail");
					String mdp = unRes.getString("mdp");
					String formateur = unRes.getString("formateur");
					Formateur unFormateur = new Formateur(idformateur, privilege, prenom, nom, age, galop, sexe, mail, mdp, formateur);
					lesFormateurs.add(unFormateur);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesFormateurs;
	}
	
	public static Object [] extraireFormateurs () {
		ArrayList <Formateur> lesFormateurs = selectChoose();
		Object [] donnees = new Object [lesFormateurs.size()+1];
		int i = 1;
		for (Formateur unFormateur : lesFormateurs) {
			donnees[i] = unFormateur.getId();
			donnees[i] = unFormateur.getFormateur();
			i++;
		}
		return donnees;
}
	//extraire les Formateurs 
	public static Object [][] extraireFormateurs2() {
		ArrayList <Formateur> lesFormateurs = ModeleFormateur.selectAll();
		Object [][] donnees = new Object [lesFormateurs.size()][5];
		int i =0;
		for (Formateur unFormateur : lesFormateurs)
		{
			donnees[i][0] = unFormateur.getMail();
			donnees[i][1] = unFormateur.getFormateur();
			donnees[i][2] = unFormateur.getSexe();
			donnees[i][3] = unFormateur.getAge();
			donnees[i][4] = unFormateur.getGalop();
			i++;
		}
		return donnees;
	}
}