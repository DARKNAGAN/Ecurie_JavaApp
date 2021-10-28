package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controleur.Gestion;
import controleur.Formateur;
import vue.Formulaire.*;
import vue.Liste.VueChevaux;
import vue.Liste.VueCours;
import vue.Liste.VueEleves;
import vue.Liste.VueFormateurs;

public class Generale extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -4529974363596089889L;
	/*VARIABLE*/
	private VueAccueil uneVueAccueil;
	private JMenuBar uneBarre = new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnGestion = new JMenu("Gestion");
	private JMenu mnCentre = new JMenu("Centre");
	private JMenuItem itemAccueil = new JMenuItem("Accueil");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemFormsEleves = new JMenuItem("Formulaire pour élèves");
	private JMenuItem itemFormsChevaux = new JMenuItem("Formulaire pour chevaux");
	private JMenuItem itemFormsFormateurs = new JMenuItem("Formulaire pour formateurs");
	private JMenuItem itemFormsCours = new JMenuItem("Formulaire pour cours");
	private JMenuItem itemCours = new JMenuItem("Liste des cours");	
	private JMenuItem itemEleves = new JMenuItem("Liste des élèves");	
	private JMenuItem itemChevaux = new JMenuItem("Liste des chevaux");	
	private JMenuItem itemFormateurs= new JMenuItem("Liste des formateurs");
		private VueEleves uneVueEleve = new VueEleves();
		private VueCours uneVueCours = new VueCours();
		private VueChevaux uneVueCheval = new VueChevaux();
		private VueFormateurs uneVueFormateur = new VueFormateurs();
		private FormEleves uneFormEleve = new FormEleves();
		private FormChevaux uneFormCheval = new FormChevaux();
		private FormFormateurs uneFormFormateur = new FormFormateurs();
		private FormCours uneFormCour = new FormCours();
	/*AFFICHAGE GENERAL APPLI*/
	public Generale(Formateur unFormateur) {
		ImageIcon logo = new ImageIcon(new ImageIcon("src/images/favicon.png").getImage());
		this.setIconImage(logo.getImage());
		this.setTitle("Ecurie");
		this.setBounds(300, 150, 800, 500);
		this.getContentPane().setBackground(new Color(247,245,226));
		this.setLayout(null);
		this.setResizable(true);
	this.uneVueAccueil = new VueAccueil(unFormateur);
		/*BARRE MENU GROUPE*/
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnCentre);
		this.uneBarre.add(this.mnGestion);
		/*BARRE MENU LISTE GROUPE*/
		this.mnFichier.add(this.itemAccueil);
		this.mnFichier.add(this.itemQuitter);
		this.mnCentre.add(this.itemEleves);
		this.mnCentre.add(this.itemChevaux);
		this.mnCentre.add(this.itemCours);
		this.mnCentre.add(this.itemEleves);	
		this.mnCentre.add(this.itemFormateurs);	
		this.mnGestion.add(this.itemFormsEleves);
		this.mnGestion.add(this.itemFormsChevaux);
		this.mnGestion.add(this.itemFormsFormateurs);
		this.mnGestion.add(this.itemFormsCours);
		this.itemQuitter.addActionListener(this);
		this.itemAccueil.addActionListener(this);
			this.itemEleves.addActionListener(this);
			this.itemChevaux.addActionListener(this);
			this.itemCours.addActionListener(this);
			this.itemFormateurs.addActionListener(this);
				this.itemFormsEleves.addActionListener(this);
				this.itemFormsChevaux.addActionListener(this);
				this.itemFormsCours.addActionListener(this);
				this.itemFormsFormateurs.addActionListener(this);
		this.setJMenuBar(this.uneBarre);
		JLabel lbTitre = new JLabel("Connecté en tant que : " + unFormateur.getPrenom() + "  " + unFormateur.getNom());
		lbTitre.setBounds(250, 0, 300, 100);lbTitre.setFont(new Font(lbTitre.getText(), Font.PLAIN, 20));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(lbTitre) ;
		this.add(uneVueAccueil);
		this.add(uneFormEleve);
		this.add(uneFormCheval);
		this.add(uneFormFormateur);
		this.add(uneFormCour);
		this.add(uneVueCheval);
		this.add(uneVueEleve);
		this.add(uneVueCours);	
		this.add(uneVueFormateur);
		this.setVisible(true);
	}
	/*ACTION GENERAL APPLI*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.itemQuitter) {
			Gestion.rendreVisible(true);
			this.setVisible(false);
		}
		else if (e.getSource()==this.itemAccueil) {
			JLabel lbTitre = new JLabel("Accueil");
			lbTitre.setBounds(250, 0, 300, 100);
			uneVueAccueil.setVisible(true);
			uneFormEleve.setVisible(false);
			uneFormCheval.setVisible(false);
			uneFormFormateur.setVisible(false);
			uneFormCour.setVisible(false);
			uneVueCours.setVisible(false);
			uneVueEleve.setVisible(false);
			uneVueCheval.setVisible(false);
			uneVueFormateur.setVisible(false);
		}
			else if (e.getSource()==this.itemFormsEleves) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(true);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsChevaux) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(true);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsFormateurs) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(true);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsCours) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(true);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}
			else if (e.getSource()==this.itemCours) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(true);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}
			else if (e.getSource()==this.itemEleves) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(true);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(false);
			}					
			else if (e.getSource()==this.itemChevaux) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(true);
			}
			else if (e.getSource()==this.itemFormateurs) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueCours.setVisible(false);
				uneVueEleve.setVisible(false);
				uneVueCheval.setVisible(false);
				uneVueFormateur.setVisible(true);
			}
	}
}