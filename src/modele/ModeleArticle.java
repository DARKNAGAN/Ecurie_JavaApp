package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Article;

public class ModeleArticle {
	public static ArrayList<Article> selectAll() {
		ArrayList<Article> lesArticles = new ArrayList<Article>();
		String requete = "select * from Article;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("idarticle");
					String reference = unRes.getString("reference");
					String categorie = unRes.getString("idcategorie");
					String description = unRes.getString("description");
					String libelle = unRes.getString("libelle");
					int prix = unRes.getInt("prix");
					int qtestock = unRes.getInt("qtestock");	
					String image = unRes.getString("imagearticle");
					Article unArticle = new Article(id, reference, categorie, description, libelle, prix, qtestock, image);
					lesArticles.add(unArticle);
				}
				unStat.close();
				unRes.close();
				uneBDD.seDeconnecter();
			}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
			}
		return lesArticles;
	}
	public static Article selectWhere(String reference) {
		String requete = "select * from Article where reference='" + reference + "';";
		Article unArticle = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("idarticle");
				String categorie = unRes.getString("idcategorie");
				String description = unRes.getString("description");
				String libelle = unRes.getString("libelle");
				int prix = unRes.getInt("prix");
				int qtestock = unRes.getInt("qtestock");	
				String image = unRes.getString("imagearticle");
				unArticle = new Article(id, reference, categorie, description, libelle, prix, qtestock, image);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete " + requete);
		}
		return unArticle;
	}
	public static void insert(Article unArticle) {
		String requete = "insert into Article (reference, idcategorie, description, libelle, prix, qtestock, imagearticle) values ('" 
			+ unArticle.getReference() + "', '"
			+ unArticle.getCategorie() + "', '"
			+ unArticle.getDescription() + "', '"
			+ unArticle.getLibelle() + "', "
			+ unArticle.getPrix() + ", "
			+ unArticle.getQtestock() + ", '"
			+ "/images/articles/img_shop.jpg');";
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
	public static void update(Article unArticle, String reference) {
		String valueCategorie = unArticle.getCategorie();
		String valueDescription = unArticle.getDescription();
		String valueLibelle = unArticle.getLibelle();
		String valuePrix = String.valueOf(unArticle.getPrix());
		String valueQtestock = String.valueOf(unArticle.getQtestock());
		if (unArticle.getCategorie().equals("")) { valueCategorie = ""; }
		else { valueCategorie = " idcategorie = '"+ unArticle.getCategorie() +"'"; }
		if (unArticle.getDescription().equals("")) { valueDescription = ""; }
		else { valueDescription = ", description = '"+ unArticle.getDescription() +"'"; }
		if (unArticle.getLibelle().equals("")) { valueLibelle = ""; }
			else { valueLibelle = ", libelle = '"+ unArticle.getLibelle() +"'"; }
		if (String.valueOf(unArticle.getPrix()).equals("")) { valuePrix = ""; }
			else { valuePrix = ", prix = "+ unArticle.getPrix(); }
		if (String.valueOf(unArticle.getQtestock()).equals("")) { valueQtestock = ""; }
			else { valueQtestock = ", qtestock = "+ unArticle.getQtestock(); }
		String requete = "update Article set " + valueCategorie + valueDescription + valueLibelle + valuePrix + valueQtestock + " where reference='"+ reference +"';";
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
		String requete = "delete from Article where reference='" + reference + "';";
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