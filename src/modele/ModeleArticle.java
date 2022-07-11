package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Article;

public class ModeleArticle {
	public static ArrayList<Article> selectAll() {
		ArrayList<Article> lesArticles = new ArrayList<Article>();
		String requete = "SELECT * FROM Article AS a INNER JOIN CategorieArticle AS ca ON a.idcategorie = ca.idcategorie;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int id = unRes.getInt("idarticle");
					String reference = unRes.getString("reference");
					int idcategorie = unRes.getInt("a.idcategorie");
					String categorie = unRes.getString("ca.libelle");
					String description = unRes.getString("description");
					String libelle = unRes.getString("a.libelle");
					int prix = unRes.getInt("prix");
					int qtestock = unRes.getInt("qtestock");	
					String image = unRes.getString("imagearticle");
					Article unArticle = new Article(id, reference, idcategorie, categorie, description, libelle, prix, qtestock, image);
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
		String requete = "SELECT * FROM Article AS a INNER JOIN CategorieArticle AS ca ON a.idcategorie = ca.idcategorie where reference='" + reference + "';";
		Article unArticle = null;
		try {
			BDD uneBDD = new BDD();
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id = unRes.getInt("idarticle");
				int idcategorie = unRes.getInt("a.idcategorie");
				String categorie = unRes.getString("ca.libelle");
				String description = unRes.getString("description");
				String libelle = unRes.getString("a.libelle");
				int prix = unRes.getInt("prix");
				int qtestock = unRes.getInt("qtestock");	
				String image = unRes.getString("imagearticle");
				unArticle = new Article(id, reference, idcategorie, categorie, description, libelle, prix, qtestock, image);
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
			+ unArticle.getidCategorie() + "', '"
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
		String valueidCategorie = String.valueOf(unArticle.getidCategorie());
		String valueDescription = unArticle.getDescription();
		String valueLibelle = unArticle.getLibelle();
		String valuePrix = String.valueOf(unArticle.getPrix());
		String valueQtestock = String.valueOf(unArticle.getQtestock());
		if (String.valueOf(unArticle.getidCategorie()).equals(0)) { valueidCategorie = ""; }
		else { valueidCategorie = " idcategorie = '"+ unArticle.getidCategorie() +"'"; }
		if (unArticle.getDescription().equals("")) { valueDescription = ""; }
		else { valueDescription = ", description = '"+ unArticle.getDescription() +"'"; }
		if (unArticle.getLibelle().equals("")) { valueLibelle = ""; }
			else { valueLibelle = ", libelle = '"+ unArticle.getLibelle() +"'"; }
		if (String.valueOf(unArticle.getPrix()).equals("")) { valuePrix = ""; }
			else { valuePrix = ", prix = "+ unArticle.getPrix(); }
		if (String.valueOf(unArticle.getQtestock()).equals("")) { valueQtestock = ""; }
			else { valueQtestock = ", qtestock = "+ unArticle.getQtestock(); }
		String requete = "update Article set " + valueidCategorie + valueDescription + valueLibelle + valuePrix + valueQtestock + " where reference='"+ reference +"';";
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
	public static ArrayList<Article> selectCategorie() {
		ArrayList<Article> lesCatgories = new ArrayList<Article>();
		String requete = "SELECT * FROM CategorieArticle;";
		try {
				BDD uneBDD = new BDD();
				uneBDD.seConnecter();
				Statement unStat = uneBDD.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				while(unRes.next()) {
					int idcategorie = unRes.getInt("idcategorie");
					String libelle = unRes.getString("libelle");
					Article uneCategorie = new Article(idcategorie, libelle);
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
	
	//extraire les Articles 
	public static Object [][] extraireArticles () {
		ArrayList <Article> lesArticles = ModeleArticle.selectAll();
		Object [][] donnees = new Object [lesArticles.size()][6];
		int i =0;
		for (Article unArticle : lesArticles) {
			donnees[i][0] = unArticle.getReference();
			donnees[i][1] = unArticle.getLibelle();
			donnees[i][2] = unArticle.getDescription();
			donnees[i][3] = unArticle.getCategorie();
			donnees[i][4] = unArticle.getPrix();
			donnees[i][5] = unArticle.getQtestock();
			i++;
		}

		return donnees;
	}
	public static Object [] extraireCategories () {
		ArrayList <Article> lesCategories = ModeleArticle.selectCategorie();
		Object [] donnees = new Object [lesCategories.size()+1];
		int i = 1;
		for (Article uneCategorie : lesCategories) {
			donnees[i] = uneCategorie.getidCategorie();
			donnees[i] = uneCategorie.getLibelle();
			i++;
		}
		return donnees;
	}
}