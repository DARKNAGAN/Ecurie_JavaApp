package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	private String serveur, nombdd, user, mdp;
	private Connection maConnexion;
	
	public BDD() {
		this.serveur = "serveur:port";
		this.nombdd = "Ecurie";
		this.user = "user";
		this.mdp = "mdp";
		this.maConnexion = null;
	}
	public void chargerPilote() {
		// v�rifie la pr�sence du pilote JDBC MySQL
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Abscence du pilote JDBC !");
			System.out.println("V�rifier Project -> Build Path -> Configure -> Libraries -> Add External JARs");
		}
	}
	public void seConnecter() {
		// connexion au serveur de la BDD
		this.chargerPilote();
		String url = "jdbc:mariadb://" + this.serveur + "/" + this.nombdd;
		try {
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch(SQLException exp) {
			System.out.println("Impossible de se connecter � " + url);
		}
	}
	public void seDeconnecter() {
		// d�connexion au serveur de la BDD
		try {
			if(this.maConnexion != null) this.maConnexion.close();
		}
		catch(SQLException exp) {
			System.out.println("La d�connexion a �chou� !");
		}
	}
	public Connection getMaConnexion()
	{
		return this.maConnexion;
	}
}