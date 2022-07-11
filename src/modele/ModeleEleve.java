package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import controleur.Eleve;

public class ModeleEleve 
{
	public static ArrayList<Eleve> selectAll() {
		ArrayList<Eleve> lesEleves = new ArrayList<Eleve>();
		String requete = "select *, CONCAT(nom,' ', prenom) AS eleve from Eleve;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("ideleve");
					int privilege = unRes.getInt("privilege");
					Date record = unRes.getDate("dateenregistre");
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
					String eleve = unRes.getString("eleve");
					Eleve unEleve = new Eleve(id, privilege, record, pseudo, prenom, nom, sexe, age, adresse, mdp, mail, galop, image, eleve);
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
		String requete = "select *, CONCAT(nom,' ', prenom) AS eleve from Eleve where adressemail='" + mail + "';";
		Eleve unEleve = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("ideleve");
				int privilege = unRes.getInt("privilege");
				Date record = unRes.getDate("dateenregistre");
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
				String eleve = unRes.getString("eleve");
				unEleve = new Eleve(id, privilege, record, pseudo, prenom, nom, sexe, age, adresse, mdp, mail, galop, image, eleve);
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
			+ unEleve.getMdp() + "', '"
			+ unEleve.getMail() + "', "
			+ unEleve.getGalop() + ", '"
			+ "/images/avatars/img_user.jpg');";
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
	public static ArrayList<Eleve> selectChoose() {
		ArrayList<Eleve> lesEleves = new ArrayList<Eleve>();
		String requete = "select ideleve, CONCAT(nom,' ', prenom) AS eleve from Eleve;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("ideleve");
					String eleve = unRes.getString("eleve");
					Eleve unEleve = new Eleve(id, eleve);
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
	public static Object [] extraireEleves () {
		ArrayList <Eleve> lesEleves = selectChoose();
		Object [] donnees = new Object [lesEleves.size()+1];
		int i = 1;
		for (Eleve unEleve : lesEleves) {
			donnees[i] = unEleve.getId();
			donnees[i] = unEleve.getEleve();
			i++;
		}
		return donnees;
	}
	
	//extraire les Eleves 
	public static Object [][] extraireEleves2 () {
		ArrayList <Eleve> lesEleves = ModeleEleve.selectAll();
		Object [][] donnees = new Object [lesEleves.size()][7];
		int i =0;
		for (Eleve unEleve : lesEleves) {
			donnees[i][0] = unEleve.getPseudo();
			donnees[i][1] = unEleve.getMail();
			donnees[i][2] = unEleve.getEleve();
			donnees[i][3] = unEleve.getAdresse();
			donnees[i][4] = unEleve.getSexe();
			donnees[i][5] = unEleve.getAge();
			donnees[i][6] = unEleve.getGalop();
			i++;
		}
		return donnees;
	}
}