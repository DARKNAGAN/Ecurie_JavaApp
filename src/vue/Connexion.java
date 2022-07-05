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
	JLabel lbLogo = new JLabel(new ImageIcon("src/images/logo.png"));
	VueConnexion vueConnexion = new VueConnexion();
	
	public Connexion()
	{
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("src/images/favicon.png").getImage());
		this.setTitle("Ecurie");
		this.setBackground(new Color(222,220,203));		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(header, BorderLayout.NORTH);
		header.setBackground(new Color(222,220,203));
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		header.add(lbLogo);		
		getContentPane().add(vueConnexion, BorderLayout.CENTER);	
		
		this.setVisible(true);
	}
	
	public void rendreVisible(boolean val)
	{
		this.setVisible(val);
	}
	
	public static void main(String[] args)
	{
		new Gestion();
	}
}
