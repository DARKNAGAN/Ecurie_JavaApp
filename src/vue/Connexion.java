package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controleur.Gestion;

public class Connexion extends JFrame
{
	private static final long serialVersionUID = 370051638025645700L;
	JFrame frame = new JFrame();
	JPanel contentPane = new JPanel();
	JPanel header = new JPanel();
	JLabel lbLogo = new JLabel(new ImageIcon(Connexion.class.getResource("/image/logo.png")));
	VueConnexion vueConnexion = new VueConnexion();
	
	public Connexion()
	{
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(Connexion.class.getResource("/image/favicon.png")).getImage());
		this.setTitle("Ecurie");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		header.add(lbLogo);
		getContentPane().add(vueConnexion, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void rendreVisible(boolean val)
	{ this.setVisible(val); }
	
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