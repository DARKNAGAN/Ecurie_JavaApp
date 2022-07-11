package controleur;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

import vue.Connexion;

public class Gestion
{
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
		/*FORMS Font*/
		UIManager.put("Label.font", new Font("Book Antiqua", Font.BOLD, 23));
		UIManager.put("Button.font",new Font("Book Antiqua", Font.BOLD, 20));
		UIManager.put("OptionPane.messageFont", new Font("Book Antiqua", Font.BOLD, 18));
		UIManager.put("OptionPane.buttonFont", new Font("Book Antiqua", Font.BOLD, 18));
		UIManager.put("TextField.font",new Font("Bodoni MT", Font.BOLD, 23));
		UIManager.put("ComboBox.font",new Font("Bodoni MT", Font.BOLD, 23));
		UIManager.put("TextPane.font",new Font("Bodoni MT", Font.BOLD, 23));
		UIManager.put("PasswordField.font",new Font("Bodoni MT", Font.BOLD, 23));
		UIManager.put("RadioButton.font",new Font("Bodoni MT", Font.BOLD, 23));
		/*JPANE & BACKGROUND*/
		UIManager.put("OptionPane.background", new Color(222,220,203));
		UIManager.put("OptionPane.messagebackground", new Color(222,220,203));
		UIManager.put("RadioButton.background",new Color(222,220,203));
		UIManager.put("Panel.background", new Color(222,220,203));
		/*JTABLE*/
		UIManager.put("TableHeader.font", new Font("Verdana", Font.PLAIN, 20));
		UIManager.put("Table.font", new Font("Arial Unicode MS", Font.PLAIN, 18));
		new Gestion();
	}
}