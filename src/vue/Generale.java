package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.Gestion;
import controleur.Formateur;

public class Generale extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = -4529974363596089889L;
	/*VARIABLE*/
	private JPanel contentPane = new JPanel();
		ImageIcon logo = new ImageIcon(new ImageIcon("src/images/favicon.png").getImage());
		 JMenuBar menuBar = new JMenuBar();
		 JMenu mnGestion = new JMenu(" Gestion ");
		 JMenu mnEcurie = new JMenu(" Centre ");
		 JMenuItem itemAccueil = new JMenuItem(" Accueil ");
		 JMenuItem itemList = new JMenuItem(" Listes ");
		 JMenuItem itemQuitter = new JMenuItem(" Quitter ");
		 JMenuItem itemFormsEleves = new JMenuItem(" Elèves ");
		 JMenuItem itemFormsChevaux = new JMenuItem(" Chevaux ");
		 JMenuItem itemFormsFormateurs = new JMenuItem(" Formateurs ");
		 JMenuItem itemFormsArticles = new JMenuItem(" Articles ");
		 JMenuItem itemFormsEvenements = new JMenuItem(" Evenements ");
		 JMenuItem itemFormsCours = new JMenuItem(" Cours ");
		 
		private final JPanel panel = new JPanel();
		private final JPanel panelCheval = new JPanel();
		private final FormFormateurs uneFormFormateur = new FormFormateurs();
		private final JPanel panelList = new JPanel();
		private final JPanel panelEleve = new JPanel();
		private final JPanel panelFormateur = new JPanel();
		private final JPanel panelArticle = new JPanel();
		private final JPanel panelEvenement = new JPanel();
		private final JPanel panelCour = new JPanel();
		private final JPanel panelAcceuil = new JPanel();
		private final VueList uneVueList = new VueList();
		private final VueAccueil uneVueAccueil;
		private final FormEleves uneFormEleve = new FormEleves();
		private final FormArticles uneFormArticle = new FormArticles();
		private final FormChevaux uneFormCheval = new FormChevaux();
		private final FormEvents uneFormEvent = new FormEvents();
		private final FormCours uneFormCour = new FormCours();
		JPanel[] panels=new JPanel[]{panelAcceuil,panelEleve,panelCheval,panelFormateur,panelArticle,panelEvenement,panelCour,panelList};


	/*AFFICHAGE GENERAL APPLI*/
	public Generale(Formateur unFormateur) {
		this.uneVueAccueil = new VueAccueil(unFormateur);
		this.setSize(1800, 1000);
		this.setLocationRelativeTo(null);			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setIconImage(logo.getImage());
		this.setTitle("Ecurie");		
		menuBar.setBackground(new Color(89, 137, 76));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setPreferredSize(new Dimension(0, 40));
		this.setJMenuBar(this.MenuBar()); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(222,220,203));	
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JLabel lbTitre = new JLabel(" Bienvenue  " + unFormateur.getPrenom() + "  " + unFormateur.getNom());
		lbTitre.setPreferredSize(new Dimension(250, 100));
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);lbTitre.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		getContentPane().add(lbTitre, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(panelFormateur, "");
		panelFormateur.setLayout(new CardLayout(0, 0));		
		panelFormateur.add(uneFormFormateur, "");
		uneFormFormateur.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelList, "");
		panelList.setLayout(new CardLayout(0, 0));		
		panelList.add(uneVueList, "");
		uneVueList.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelAcceuil, "");
		panelAcceuil.setLayout(new CardLayout(0, 0));		
		panelAcceuil.add(uneVueAccueil, "");
		uneVueAccueil.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelEleve, "");
		panelEleve.setLayout(new CardLayout(0, 0));		
		panelEleve.add(uneFormEleve, "");
		uneFormEleve.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelCheval, "");
		panelCheval.setLayout(new CardLayout(0, 0));		
		panelCheval.add(uneFormCheval, "");
		uneFormCheval.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelArticle, "");
		panelArticle.setLayout(new CardLayout(0, 0));		
		panelArticle.add(uneFormArticle, "");
		uneFormArticle.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelEvenement, "");
		panelEvenement.setLayout(new CardLayout(0, 0));		
		panelEvenement.add(uneFormEvent, "");
		uneFormEvent.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(panelCour, "");
		panelCour.setLayout(new CardLayout(0, 0));		
		panelCour.add(uneFormCour, "");
		uneFormCour.setLayout(new GridLayout(1, 0, 0, 0));
		panelAcceuil.setVisible(true);
		panelList.setVisible(false);
		panelFormateur.setVisible(false);
		panelEleve.setVisible(false);
		panelCheval.setVisible(false);		
		panelArticle.setVisible(false);
		panelEvenement.setVisible(false);
		panelCour.setVisible(false);
		this.setVisible(true);
	}
	
    public JMenuBar MenuBar() {
        /*BARRE MENU GROUPE*/
		mnEcurie.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		menuBar.add(this.mnEcurie);
		mnGestion.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		menuBar.add(this.mnGestion);
		/*BARRE MENU LISTE GROUPE*/
		itemAccueil.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnEcurie.add(this.itemAccueil);
		itemList.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnEcurie.add(this.itemList);
		itemQuitter.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnEcurie.add(this.itemQuitter);
		itemFormsFormateurs.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsFormateurs);
		itemFormsEleves.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsEleves);
		itemFormsChevaux.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsChevaux);
		itemFormsArticles.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsArticles);
		itemFormsEvenements.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsEvenements);
		itemFormsCours.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		this.mnGestion.add(this.itemFormsCours);
		this.itemQuitter.addActionListener(this);
		this.itemAccueil.addActionListener(this);
		this.itemList.addActionListener(this);
		this.itemFormsEleves.addActionListener(this);
		this.itemFormsChevaux.addActionListener(this);
		this.itemFormsArticles.addActionListener(this);
		this.itemFormsEvenements.addActionListener(this);
		this.itemFormsCours.addActionListener(this);
		this.itemFormsFormateurs.addActionListener(this);
		return menuBar; 
    }
   	/*ACTION GENERAL APPLI MenuBar*/
@Override
public void actionPerformed(ActionEvent e)
{
		if(e.getSource() == this.itemQuitter) {
			Gestion.rendreVisible(true);
			this.setVisible(false);
			}
			else if (e.getSource()==this.itemAccueil) {
				for (JPanel panel : panels) {
					panel.setVisible(false);
					panelAcceuil.setVisible(true);  
					}
			}
			else if (e.getSource()==this.itemFormsEleves) {
				for (JPanel panel : panels) {
					panel.setVisible(false);
					panelEleve.setVisible(true);    
					}
		}
		else if (e.getSource()==this.itemFormsChevaux) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelCheval.setVisible(true);    
				}
		}
		else if (e.getSource()==this.itemFormsFormateurs) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelFormateur.setVisible(true);    
				}
		}
		else if (e.getSource()==this.itemFormsArticles) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelArticle.setVisible(true);    
				}
		}
		else if (e.getSource()==this.itemFormsEvenements) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelEvenement.setVisible(true);    
				}
		}
		else if (e.getSource()==this.itemFormsCours) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelCour.setVisible(true);    
				}
		}
		else if (e.getSource()==this.itemList) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelList.setVisible(true);    
				}
		}
}
}