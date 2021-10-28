package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Eleve;

public class ModeleEleve 
{
	public static ArrayList<Eleve> selectAll() {
		ArrayList<Eleve> lesEleves = new ArrayList<Eleve>();
		String requete = "select * from Eleve;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("ideleve");
					int privilege = unRes.getInt("privilege");
					String record = unRes.getString("dateenregistre");
					String pseudo = unRes.getString("pseudo");
					String prenom = unRes.getString("prenom");
					String nom = unRes.getString("nom");
					String sexe = unRes.getString("sexe");
					int age = unRes.getInt("age");	
					String adresse = unRes.getString("adresse");
					String mdp = unRes.getString("mdp");
					String mail = unRes.getString("adressemail");
					int galop = unRes.getInt("galop");
					String image = unRes.getString("imageeleve");
					Eleve unEleve = new Eleve(id, privilege, record, pseudo, prenom, nom, sexe, age, adresse, mdp, mail, galop, image);
					lesEleves.add(unEleve);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesEleves;
	}
	public static Eleve selectWhere(String mail) {
		String requete = "select * from Eleve where adressemail='" + mail + "';";
		Eleve unEleve = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("ideleve");
				int privilege = unRes.getInt("privilege");
				String record = unRes.getString("dateenregistre");
				String pseudo = unRes.getString("pseudo");
				String prenom = unRes.getString("prenom");
				String nom = unRes.getString("nom");
				String sexe = unRes.getString("sexe");
				int age = unRes.getInt("age");	
				String adresse = unRes.getString("adresse");
				String mdp = unRes.getString("mdp");
				//adressemail
				int galop = unRes.getInt("galop");
				String image = unRes.getString("imageeleve");
				unEleve = new Eleve(id, privilege, record, pseudo, prenom, nom, sexe, age, adresse, mdp, mail, galop, image);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unEleve;
	}
	public static void insert(Eleve unEleve) {
		String requete = "insert into Eleve (privilege, dateenregistre, pseudo, prenom, nom, sexe, age, adresse, mdp, adressemail, galop, imageeleve) values ('" 
			+ "2', NOW(), 'NEW', '"
			+ unEleve.getPrenom() + "', '"
			+ unEleve.getNom() + "', '"
			+ unEleve.getSexe() + "', "
			+ unEleve.getAge() + ", '"
			+ unEleve.getAdresse() + "', '"
			+ "CCB', '"
			+ unEleve.getMail() + "', "
			+ unEleve.getGalop() + ", '"
			+ "./images/avatars/img_user.jpg');";
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
	public static void update(Eleve unEleve, String mail) {
		String valuePrenom = unEleve.getPrenom();
		String valueNom = unEleve.getNom();
		String valueSexe = unEleve.getSexe();
		String valueAge = String.valueOf(unEleve.getAge());
		String valueGalop = String.valueOf(unEleve.getGalop());
		String valueAdresse = unEleve.getAdresse();
		//adressemail
		if (unEleve.getPrenom().equals("")) { valuePrenom = ""; }
		else { valuePrenom = ", prenom = '"+ unEleve.getPrenom() +"'"; }
		if (unEleve.getNom().equals("")) { valueNom = ""; }
			else { valueNom = ", nom = '"+ unEleve.getNom() +"'"; }
		if (unEleve.getSexe().equals("")) { valueSexe = ""; }
			else { valueSexe = ", sexe = '"+ unEleve.getSexe() +"'"; }
		if (String.valueOf(unEleve.getAge()).equals("")) { valueAge = ""; }
			else { valueAge = ", age = "+ unEleve.getAge(); }
		if (unEleve.getAdresse().equals("")) { valueAdresse = ""; }
			else { valueAdresse = ", adresse = '"+ unEleve.getAdresse() +"'"; }
		if (String.valueOf(unEleve.getGalop()).equals("")) { valueGalop = ""; }	
			else { valueGalop = ", galop = "+ unEleve.getGalop(); }
		String requete = "update Eleve set adressemail ='"+ unEleve.getMail() +"'" + valuePrenom + valueNom + valueSexe + valueAge + valueAdresse + valueGalop + " where adressemail='"+ mail +"';";
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
		String requete = "delete from Eleve where adressemail='" + mail + "';";
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