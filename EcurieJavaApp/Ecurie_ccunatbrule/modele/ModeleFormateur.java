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
		String requete = "select * from Formateur;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int idformateur = unRes.getInt("idformateur");
					String login = unRes.getString("login");
					int privilege = unRes.getInt("privilege");
					String prenom = unRes.getString("prenom");
					String nom = unRes.getString("nom");
					int age = unRes.getInt("age");	
					int galop = unRes.getInt("galop");
					String sexe = unRes.getString("sexe");
					String mail = unRes.getString("adressemail");
					String mdp = unRes.getString("mdp");	
					Formateur unFormateur = new Formateur(idformateur, login, privilege, prenom, nom, age, galop, sexe, mail, mdp);
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
	public static Formateur selectWhere(String mail, String mdp) {
		String requete = "select * from Formateur where adressemail='" + mail + "' and mdp='" + mdp + "';";
		Formateur unFormateur = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next())
			{
				int idformateur = unRes.getInt("idformateur");
				String login = unRes.getString("login");
				int privilege = unRes.getInt("privilege");
				String prenom = unRes.getString("prenom");
				String nom = unRes.getString("nom");
				int age = unRes.getInt("age");
				int galop = unRes.getInt("galop");
				String sexe = unRes.getString("sexe");
				// adressemail & mdp
				unFormateur = new Formateur(idformateur, login, privilege, prenom, nom, age, galop, sexe, mail, mdp);
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
			String requete = "insert into Formateur (login, privilege, prenom, nom, age, galop, sexe, adressemail, mdp) values ('"
					+ unFormateur.getLogin() + "', '"
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
}