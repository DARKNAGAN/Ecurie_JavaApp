package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Event;

public class ModeleEvent {
	public static ArrayList<Event> selectAll() {
		ArrayList<Event> lesEvents = new ArrayList<Event>();
		String requete = "select * from Event;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("idevent");
					String reference = unRes.getString("reference");
					String categorie = unRes.getString("idtype");
					String description = unRes.getString("description");
					String libelle = unRes.getString("nom");
					int prix = unRes.getInt("prix");
					String lieu = unRes.getString("lieu");
					String date = unRes.getString("dateevent");
					String image = unRes.getString("imageevent");
					Event unEvent = new Event(id, reference, categorie, description, libelle, prix, lieu, date, image);
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
		String requete = "select * from Event where reference='" + reference + "';";
		Event unEvent = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("idevent");
				String categorie = unRes.getString("idtype");
				String description = unRes.getString("description");
				String libelle = unRes.getString("nom");
				int prix = unRes.getInt("prix");
				String lieu = unRes.getString("lieu");
				String date = unRes.getString("dateevent");
				String image = unRes.getString("imageevent");
				unEvent = new Event(id, reference, categorie, description, libelle, prix, lieu, date, image);
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
		String requete = "insert into Event (dateevent, reference, idtype, description, nom, lieu, prix, imageevent) values (" 
			+ "NOW(), '"
			+ unEvent.getReference() + "', '"
			+ unEvent.getCategorie() + "', '"
			+ unEvent.getDescription() + "', '"
			+ unEvent.getLibelle() + "', '"
			+ unEvent.getLieu() + "', "
			+ unEvent.getPrix() + ", '"
			+ "/images/evenements/img_event.jpg');";
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
		String valueCategorie = unEvent.getCategorie();
		String valueDescription = unEvent.getDescription();
		String valueLibelle = unEvent.getLibelle();
		String valuePrix = String.valueOf(unEvent.getPrix());
		String valueLieu = unEvent.getLieu();
		String valueDate = unEvent.getDate();
		if (unEvent.getCategorie().equals("")) { valueCategorie = ""; }
		else { valueCategorie = " idtype = '"+ unEvent.getCategorie() +"'"; }
		if (unEvent.getDescription().equals("")) { valueDescription = ""; }
		else { valueDescription = ", description = '"+ unEvent.getDescription() +"'"; }
		if (unEvent.getLibelle().equals("")) { valueLibelle = ""; }
			else { valueLibelle = ", nom = '"+ unEvent.getLibelle() +"'"; }
		if (String.valueOf(unEvent.getPrix()).equals("")) { valuePrix = ""; }
			else { valuePrix = ", prix = "+ unEvent.getPrix(); }
		if (String.valueOf(unEvent.getLieu()).equals("")) { valueLieu = ""; }
			else { valueLieu = ", lieu = '"+ unEvent.getLieu() + "'";}
		if (String.valueOf(unEvent.getDate()).equals("")) { valueDate = ""; }
		else { valueDate = ", dateevent = Now()"; }
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
}