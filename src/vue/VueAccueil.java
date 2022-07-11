package vue;
import java.awt.*;
import javax.swing.*;
import controleur.Formateur;

public class VueAccueil extends JPanel
{
	private static final long serialVersionUID = -3549267272035293251L;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel title = new JLabel(" Vos informations personnelles ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbPrivilege = new JLabel(" Privilège : ");
	private final JLabel lbMail = new JLabel(" E-mail : ");
	private final JLabel lbFormateur = new JLabel(" Nom, Prénom : ");
	private final JLabel lbAge = new JLabel(" Age : ");
	private final JLabel lbSexe = new JLabel(" Sexe : ");
	private final JLabel lbGalop = new JLabel(" Galop : ");	
	private final JLabel textId = new JLabel();
	private final JLabel textPrivilege = new JLabel();
	private final JLabel textMail = new JLabel();
	private final JLabel textFormateur = new JLabel();
	private final JLabel textAge = new JLabel();
	private final JLabel textSexe = new JLabel();
	private final JLabel textGalop = new JLabel();
	public VueAccueil(Formateur unFormateur)
	{
		this.setLayout(new BorderLayout(0, 0));
		this.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 30));
		panel.add(panel_1, BorderLayout.NORTH);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		JLabel lbTitre = new JLabel("Bonjour  " + unFormateur.getFormateur());
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitre.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		panel_1.add(lbTitre, BorderLayout.NORTH);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Book Antiqua", Font.BOLD, 35));
		panel_1.add(title, BorderLayout.CENTER);
		textId.setHorizontalAlignment(SwingConstants.LEFT);
		this.textId.setText(String.valueOf(unFormateur.getId()));
		textPrivilege.setHorizontalAlignment(SwingConstants.LEFT);
		this.textPrivilege.setText(String.valueOf(unFormateur.getPrivilege()));
		textMail.setHorizontalAlignment(SwingConstants.LEFT);
		this.textMail.setText(unFormateur.getMail());
		textFormateur.setHorizontalAlignment(SwingConstants.LEFT);
		this.textFormateur.setText(unFormateur.getFormateur());
		textAge.setHorizontalAlignment(SwingConstants.LEFT);
		this.textAge.setText(String.valueOf(unFormateur.getAge()));
		textSexe.setHorizontalAlignment(SwingConstants.LEFT);
		this.textSexe.setText(unFormateur.getSexe());
		textGalop.setHorizontalAlignment(SwingConstants.LEFT);
		this.textGalop.setText(String.valueOf(unFormateur.getGalop()));	
		panel_2.setLayout(new GridLayout(9, 2, 40, 0));
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbId);panel_2.add(textId);
		lbPrivilege.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbPrivilege);panel_2.add(textPrivilege);
		lbMail.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbMail);panel_2.add(textMail);
		lbFormateur.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbFormateur);panel_2.add(textFormateur);
		lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbAge);panel_2.add(textAge);
		lbSexe.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbSexe);panel_2.add(textSexe);
		lbGalop.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lbGalop);panel_2.add(textGalop);
	}
}