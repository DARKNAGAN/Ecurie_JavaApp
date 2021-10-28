package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controleur.Gestion;
import controleur.Formateur;
import modele.ModeleFormateur;

public class VueConnexion extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 9053959881019676053L;
	private JTextField txtMail = new JTextField("sa@gmail.com");
	private JPasswordField txtMdp = new JPasswordField("P@ssword");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se connecter");
	public VueConnexion()
	{
		this.setBounds(60, 100, 350, 100);
		this.setLayout(new GridLayout(3, 2));
		this.setBackground(new Color(222,220,203));
		JLabel lbMail = new JLabel(" E-mail :");lbMail.setFont(new Font(lbMail.getText(), Font.CENTER_BASELINE, 16));
		JLabel lbMdp = new JLabel(" Mot de passe :");lbMdp.setFont(new Font(lbMdp.getText(), Font.CENTER_BASELINE, 16));
		this.btAnnuler.setIcon(new ImageIcon(new ImageIcon("src/images/choix1.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.setIcon(new ImageIcon(new ImageIcon("src/images/choix2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		this.btSeConnecter.addActionListener(this);
		this.add(lbMail);this.add(this.txtMail);
		this.add(lbMdp);this.add(this.txtMdp);
		this.add(this.btAnnuler);this.add(this.btSeConnecter);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btAnnuler) {
			this.txtMail.setText("");
			this.txtMdp.setText("");
		}
		else if(e.getSource() == this.btSeConnecter) {
			String email = this.txtMail.getText();
			String mdp = new String(this.txtMdp.getPassword());
			Formateur unFormateur = ModeleFormateur.selectWhere(email, mdp);
			if(unFormateur == null) {
				JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !");
			}
			else {
				JOptionPane.showMessageDialog(this, "Connexion réussie\n"
						+ "Bienvenue M./Mme\n" + "          " 
						+ unFormateur.getNom() + "     " 
						+ unFormateur.getPrenom());
							// ouvrir le menu général
							new Generale(unFormateur);
							this.txtMail.setText("");
							this.txtMdp.setText("");
							Gestion.rendreVisible(false);
			}
		}
	}
}