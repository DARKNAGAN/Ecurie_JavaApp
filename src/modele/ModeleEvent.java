package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Event;

public class ModeleEvent {
	public static ArrayList<Event> selectAll() {
		ArrayList<Event> lesEvents = new ArrayList<Event>();
		String requete = "SELECT * FROM Event AS e INNER JOIN TypeEvent AS te ON e.idtype = te.idtype;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("idevent");
					String reference = unRes.getString("reference");
					int idcategorie = unRes.getInt("e.idtype");
					String categorie = unRes.getString("te.libelle");
					String description = unRes.getString("description");
					String libelle = unRes.getString("nom");
					int prix = unRes.getInt("prix");
					String lieu = unRes.getString("lieu");
					String date = unRes.getString("dateevent");
					String image = unRes.getString("imageevent");
					Event unEvent = new Event(id, reference, idcategorie, categorie, description, libelle, prix, lieu, date, image);
					lesEvents.add(unEvent);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesEvents;
	}
	public static Event selectWhere(String reference) {
		String requete = "SELECT * FROM Event AS e INNER JOIN TypeEvent AS te ON e.idtype = te.idtype where reference='" + reference + "';";
		Event unEvent = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("idevent");
				int idcategorie = unRes.getInt("e.idtype");
				String categorie = unRes.getString("te.libelle");
				String description = unRes.getString("description");
				String libelle = unRes.getString("nom");
				int prix = unRes.getInt("prix");
				String lieu = unRes.getString("lieu");
				String date = unRes.getString("dateevent");
				String image = unRes.getString("imageevent");
				unEvent = new Event(id, reference, idcategorie, categorie, description, libelle, prix, lieu, date, image);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unEvent;
	}
	public static void insert(Event unEvent) {
		String requete = "insert into Event (reference, idtype, description, nom, lieu, prix, dateevent, imageevent) values ('"
			+ unEvent.getReference() + "', '"
			+ unEvent.getidCategorie() + "', '"
			+ unEvent.getDescription() + "', '"
			+ unEvent.getLibelle() + "', '"
			+ unEvent.getLieu() + "', "
			+ unEvent.getPrix() + ",'"
			+ unEvent.getDate() + "',"
			+ "'/images/evenements/img_event.jpg');";
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
	public static void update(Event unEvent, String reference) {
		String valueCategorie = String.valueOf(unEvent.getidCategorie());
		String valueDescription = unEvent.getDescription();
		String valueLibelle = unEvent.getLibelle();
		String valuePrix = String.valueOf(unEvent.getPrix());
		String valueLieu = unEvent.getLieu();
		String valueDate =  String.valueOf(unEvent.getDate());
		if (String.valueOf(unEvent.getidCategorie()).equals(0)) { valueCategorie = ""; }
		else { valueCategorie = " idtype = '"+ String.valueOf(unEvent.getidCategorie()) +"'"; }
		if (unEvent.getDescription().equals("")) { valueDescription = ""; }
		else { valueDescription = ", description = '"+ unEvent.getDescription() +"'"; }
		if (unEvent.getLibelle().equals("")) { valueLibelle = ""; }
			else { valueLibelle = ", nom = '"+ unEvent.getLibelle() +"'"; }
		if (String.valueOf(unEvent.getPrix()).equals("")) { valuePrix = ""; }
			else { valuePrix = ", prix = "+ unEvent.getPrix(); }
		if (String.valueOf(unEvent.getLieu()).equals("")) { valueLieu = ""; }
			else { valueLieu = ", lieu = '"+ unEvent.getLieu() + "'";}
		if (String.valueOf(unEvent.getDate()).equals("")) { valueDate = ""; }
		else { valueDate = ", dateevent = '"+ unEvent.getDate() + "'";}
		String requete = "update Event set " + valueCategorie + valueDescription + valueLibelle + valuePrix + valueLieu + valueDate + " where reference='"+ reference +"';";
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
	public static void delete(String reference) {
		String requete = "delete from Event where reference='" + reference + "';";
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
	public static ArrayList<Event> selectCategorie() {
		ArrayList<Event> lesCatgories = new ArrayList<Event>();
		String requete = "SELECT * FROM TypeEvent;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int idcategorie = unRes.getInt("idtype");
					String libelle = unRes.getString("libelle");
					Event uneCategorie = new Event(idcategorie, libelle);
					lesCatgories.add(uneCategorie);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesCatgories;
	}
	//extraire les Events 
	public static Object [][] extraireEvents () {
		ArrayList <Event> lesEvents = ModeleEvent.selectAll();
		Object [][] donnees = new Object [lesEvents.size()][7];
		int i =0;
		for (Event unEvent : lesEvents) {
			donnees[i][0] = unEvent.getReference();
			donnees[i][1] = unEvent.getLibelle();
			donnees[i][2] = unEvent.getDescription();
			donnees[i][3] = unEvent.getPrix();
			donnees[i][4] = unEvent.getLieu();
			donnees[i][5] = unEvent.getDate();
			donnees[i][6] = unEvent.getCategorie();
			i++;
		}
		return donnees;
	}
	public static Object [] extraireCategories () {
		ArrayList <Event> lesCategories = ModeleEvent.selectCategorie();
		Object [] donnees = new Object [lesCategories.size()+1];
		int i = 1;
		for (Event uneCategorie : lesCategories) {
			donnees[i] = uneCategorie.getidCategorie();
			donnees[i] = uneCategorie.getLibelle();
			i++;
		}
		return donnees;
	}
}