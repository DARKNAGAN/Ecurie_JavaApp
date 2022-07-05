package vue;
import java.awt.*;
import javax.swing.*;

import controleur.Formateur;
import controleur.Gestion;
import modele.ModeleFormateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueConnexion extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 9053959881019676053L;
	private final JPanel panel = new JPanel();
	private final JPanel header = new JPanel();
	private final JPanel content = new JPanel();
	private final JPanel forms = new JPanel();
	private final JPanel mail = new JPanel();
	private final JPanel mdp = new JPanel();
	private final JPanel footer = new JPanel();
	private final JLabel lbTitre = new JLabel(" Connexion ");
	private final JLabel lbMail = new JLabel(" E-mail : ");
	private final JLabel lbMdp = new JLabel(" Mot de passe :  ");
	private final JTextField mailField = new JTextField("sa@gmail.com");
	private final JPasswordField mdpField = new JPasswordField("P@ssword");
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btSeConnecter = new JButton(" Connexion ");
	
	public VueConnexion()
	{
		this.setBackground(new Color(222,220,203));
		this.add(panel);
		panel.setBackground(new Color(222,220,203));		
		panel.setLayout(new BorderLayout(0, 30));
		panel.add(header, BorderLayout.NORTH);
		header.setLayout(new GridLayout(0, 1, 0, 0));
		header.setBackground(new Color(222,220,203));
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));		
		header.add(lbTitre);		
		panel.add(content, BorderLayout.CENTER);
		content.setLayout(new GridLayout(0, 1, 0, 0));
		content.setBackground(new Color(222,220,203));
		content.add(forms);
		forms.setLayout(new GridLayout(0, 1, 0, 20));
		forms.setBackground(new Color(222,220,203));		
		mail.setPreferredSize(new Dimension(10, 40));
		mail.setBackground(new Color(222,220,203));
		forms.add(mail);
			lbMail.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
			mailField.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			mail.setLayout(new BoxLayout(mail, BoxLayout.X_AXIS));
			mail.add(lbMail);
			mail.add(mailField);
		mdp.setBackground(Color.YELLOW);
		mdp.setPreferredSize(new Dimension(10, 40));
		mdp.setBackground(new Color(222,220,203));
		forms.add(mdp);
			mdp.setLayout(new BoxLayout(mdp, BoxLayout.X_AXIS));
			lbMdp.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
			mdp.add(lbMdp);
			mdpField.setFont(new Font("Dialog", Font.PLAIN, 15));
			mdp.add(mdpField);
		footer.setBackground(new Color(222,220,203));		
		panel.add(footer, BorderLayout.SOUTH);
		btAnnuler.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		btSeConnecter.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		footer.setLayout(new GridLayout(1, 2, 30, 0));
		btAnnuler.setBackground(new Color(222,220,203));
		footer.add(btAnnuler);
		btSeConnecter.setBackground(new Color(222,220,203));
		footer.add(btSeConnecter);
		btAnnuler.addActionListener(this);
		btSeConnecter.addActionListener(this);

		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btAnnuler) {
			this.mailField.setText("");
			this.mdpField.setText("");
		}
		else if(e.getSource() == this.btSeConnecter) {
			Formateur unFormateur = ModeleFormateur.selectCompte(this.mailField.getText(), new String(this.mdpField.getPassword()));
			if(unFormateur == null) {
				JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !"," Connexion refusé ",JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this,	"Bienvenue  " + unFormateur.getNom() +"   " + unFormateur.getPrenom()," Connexion réussie ",JOptionPane.INFORMATION_MESSAGE);
							// ouvrir le menu général
							new Generale(unFormateur);
							this.mailField.setText("");
							this.mdpField.setText("");
							Gestion.rendreVisible(false);
			}
		}
	}
}