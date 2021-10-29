package vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.Gestion;
import controleur.Formateur;

public class Generale extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -4529974363596089889L;
	/*VARIABLE*/
	private VueAccueil uneVueAccueil;
	private JMenuBar uneBarre = new JMenuBar();
	private JMenu mnGestion = new JMenu("Gestion");
	private JMenu mnEcurie = new JMenu("Centre");
	private JMenuItem itemAccueil = new JMenuItem("Accueil");
	private JMenuItem itemList = new JMenuItem("List");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemFormsEleves = new JMenuItem("Formulaire pour élèves");
	private JMenuItem itemFormsChevaux = new JMenuItem("Formulaire pour chevaux");
	private JMenuItem itemFormsFormateurs = new JMenuItem("Formulaire pour formateurs");
	private JMenuItem itemFormsCours = new JMenuItem("Formulaire pour cours");
		private VueList uneVueList = new VueList();
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
		this.uneBarre.add(this.mnEcurie);
		this.uneBarre.add(this.mnGestion);
		/*BARRE MENU LISTE GROUPE*/
		this.mnEcurie.add(this.itemAccueil);
		this.mnEcurie.add(this.itemList);
		this.mnEcurie.add(this.itemQuitter);
		this.mnGestion.add(this.itemFormsEleves);
		this.mnGestion.add(this.itemFormsChevaux);
		this.mnGestion.add(this.itemFormsFormateurs);
		this.mnGestion.add(this.itemFormsCours);
		this.itemQuitter.addActionListener(this);
		this.itemAccueil.addActionListener(this);
		this.itemList.addActionListener(this);
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
		this.add(uneVueList);
		this.add(uneFormEleve);
		this.add(uneFormCheval);
		this.add(uneFormFormateur);
		this.add(uneFormCour);
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
			uneVueList.setVisible(false);
		}
			else if (e.getSource()==this.itemFormsEleves) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(true);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueList.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsChevaux) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(true);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueList.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsFormateurs) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(true);
				uneFormCour.setVisible(false);
				uneVueList.setVisible(false);
			}
			else if (e.getSource()==this.itemFormsCours) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(true);
				uneVueList.setVisible(false);
			}
			else if (e.getSource()==this.itemList) {
				uneVueAccueil.setVisible(false);
				uneFormEleve.setVisible(false);
				uneFormCheval.setVisible(false);
				uneFormFormateur.setVisible(false);
				uneFormCour.setVisible(false);
				uneVueList.setVisible(true);
			}
	}
}