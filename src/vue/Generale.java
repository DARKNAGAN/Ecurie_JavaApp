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
		ImageIcon logo = new ImageIcon(new ImageIcon(Generale.class.getResource("/image/favicon.png")).getImage());
		JMenuBar menuBar = new JMenuBar();
		JMenu mnEcurie = new JMenu(" Fichier ");
		JMenuItem itemAccueil = new JMenuItem(" Accueil ");
		JMenuItem itemQuitter = new JMenuItem(" Quitter ");
		JMenuItem itemFormsCours = new JMenuItem(" Cours ");
		JToolBar toolBar = new JToolBar();
		JButton btnCheval = new JButton(new ImageIcon(Generale.class.getResource("/image/cheval.png")));
		JButton btnFormateur = new JButton(new ImageIcon(Generale.class.getResource("/image/formateur.png")));
		JButton btnEleve = new JButton(new ImageIcon(Generale.class.getResource("/image/eleve.png")));
		JButton btnEvent = new JButton(new ImageIcon(Generale.class.getResource("/image/event.png")));
		JButton btnArticle = new JButton(new ImageIcon(Generale.class.getResource("/image/article.png")));
		JButton btnCours = new JButton(new ImageIcon(Generale.class.getResource("/image/cours.png")));

		private final JPanel panel = new JPanel();
		private final JPanel panel_2 = new JPanel();
		private final JPanel panelCheval = new JPanel();
		private final JPanel panelEleve = new JPanel();
		private final JPanel panelFormateur = new JPanel();
		private final JPanel panelArticle = new JPanel();
		private final JPanel panelEvenement = new JPanel();
		private final JPanel panelCour = new JPanel();
		private final JPanel panelAcceuil = new JPanel();
		private final VueAccueil uneVueAccueil;
		private final FormFormateurs uneFormFormateur = new FormFormateurs();
		private final FormEleves uneFormEleve = new FormEleves();
		private final FormArticles uneFormArticle = new FormArticles();
		private final FormChevaux uneFormCheval = new FormChevaux();
		private final FormEvents uneFormEvent = new FormEvents();
		private final FormCours uneFormCour = new FormCours();
		JPanel[] panels=new JPanel[]{panelAcceuil,panelEleve,panelCheval,panelFormateur,panelArticle,panelEvenement,panelCour};



		public Generale(Formateur unFormateur) {
		this.uneVueAccueil = new VueAccueil(unFormateur);
		this.setSize(1800, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		this.setTitle("Ecurie");
		menuBar.setBackground(new Color(89, 137, 76));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setPreferredSize(new Dimension(0, 60));
		this.setJMenuBar(this.MenuBar());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		toolBar.setPreferredSize(new Dimension(80, 100));
		getContentPane().add(this.createToolBar(), BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		panel_2.add(panel, BorderLayout.CENTER);
		panel.add(panelFormateur, "");
		panelFormateur.setLayout(new CardLayout(0, 0));
		panelFormateur.add(uneFormFormateur, "");
		uneFormFormateur.setLayout(new GridLayout(1, 0, 0, 0));
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
		mnEcurie.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 22));
		menuBar.add(this.mnEcurie);
		/*BARRE MENU LISTE GROUPE*/
		itemAccueil.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 22));
		this.mnEcurie.add(this.itemAccueil);
		itemQuitter.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 22));
		this.mnEcurie.add(this.itemQuitter);
		itemFormsCours.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 22));
		getContentPane().add(this.itemFormsCours);
		this.itemQuitter.addActionListener(this);
		this.itemAccueil.addActionListener(this);
		this.itemFormsCours.addActionListener(this);
		return menuBar; 
    }
	public JToolBar createToolBar() {
		btnFormateur.setToolTipText("Gestion des formateurs");
		toolBar.add(btnFormateur);
		toolBar.addSeparator();
		btnEleve.setToolTipText("Gestion des élèves");
		toolBar.add(btnEleve);
		toolBar.addSeparator();
		btnCheval.setToolTipText("Gestion des chevaux");
		toolBar.add(btnCheval);
		toolBar.addSeparator();
		btnArticle.setToolTipText("Gestion des articles");
		toolBar.add(btnArticle);
		toolBar.addSeparator();
		btnEvent.setToolTipText("Gestion des évènements");
		toolBar.add(btnEvent);
		toolBar.addSeparator();
		btnFormateur.setToolTipText("Gestion des cours");
		toolBar.add(btnCours);
		this.btnEleve.addActionListener(this);
		this.btnFormateur.addActionListener(this);
		this.btnCheval.addActionListener(this);
		this.btnArticle.addActionListener(this);
		this.btnEvent.addActionListener(this);
		this.btnCours.addActionListener(this);
		
		return toolBar;
	}
   	/*ACTION GENERAL APPLI MenuBar*/
@Override
public void actionPerformed(ActionEvent e)
{			UIManager.put("JLabel.font", new Font("Arial", Font.PLAIN, 50));

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
			else if (e.getSource()==this.btnEleve) {
				for (JPanel panel : panels) {
					panel.setVisible(false);
					panelEleve.setVisible(true);    
					}
		}
		else if (e.getSource()==this.btnCheval) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelCheval.setVisible(true);    
				}
		}
		else if (e.getSource()==this.btnFormateur) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelFormateur.setVisible(true);    
				}
		}
		else if (e.getSource()==this.btnArticle) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelArticle.setVisible(true);    
				}
		}
		else if (e.getSource()==this.btnEvent) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelEvenement.setVisible(true);    
				}
		}
		else if (e.getSource()==this.btnCours) {
			for (JPanel panel : panels) {
				panel.setVisible(false);
				panelCour.setVisible(true);    
				}
		}
}
}