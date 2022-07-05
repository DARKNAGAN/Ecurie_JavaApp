package controleur;

import vue.Connexion;

public class Gestion
{/*GESTION N EST PAS UTILISER CAR INCOMPREHENSIBLE POUR CCB - ALL IS IN Connexion*/
	private static Connexion uneConnexion;
	public Gestion()
	{
		uneConnexion = new Connexion();
		uneConnexion.rendreVisible(true);
	}
	
	public static void rendreVisible(boolean val)
	{
		uneConnexion.rendreVisible(val);
	}
	
	public static void main(String[] args)
	{
		new Gestion();
	}
	
}