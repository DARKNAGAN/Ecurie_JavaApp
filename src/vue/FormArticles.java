package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controleur.Article;
import modele.ModeleArticle;


public class FormArticles extends JPanel implements ActionListener  {

	private static final long serialVersionUID = -7935938065497628244L;
	String prenom, nom, sexe, imagearticle;
	int id, privilege, age, selection;
	String[] formState = { " VISUALISER ", " AJOUTER ", " MODIFIER ", " SUPPRIMER " };
	String[] titresArticle = new String[] {" Référence "," Categorie "," Produit "," Description "," Prix "," Quantité "};
	Object[][] dataArticle = extraireArticles();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_14 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_15, panel_14);
	private final JTable tableArticles = new JTable(dataArticle, titresArticle);
	private final JScrollPane scrollTab = new JScrollPane(tableArticles);
	private final JLabel lbTitre = new JLabel(" Panneau de Gestion des Articles ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbReference = new JLabel(" Référence de l'article : ");
	private final JLabel lbCategorie = new JLabel(" Catégorie de l'article : ");
	private final JLabel lbPrix = new JLabel(" Prix de l'article (\u20AC) : ");
	private final JLabel lbDescription = new JLabel(" Description : ");
	private final JLabel lbLibelle = new JLabel(" Nom de l'article : ");
	private final JLabel lbQtestock = new JLabel(" Quantité (/pièce) : ");
	private final JLabel lbImage = new JLabel(" Image : ");
	private final JLabel imgImage = new JLabel();
	private final JLabel textId = new JLabel();
	private final JTextField textReference = new JTextField();
	private final JTextField textCategorie = new JTextField();
	private final JTextField textLibelle = new JTextField();
	private final JTextField textPrix = new JTextField();
	private final JTextField textQtestock = new JTextField();
	private final JTextPane textDescription = new JTextPane();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	public FormArticles()
	{
		 this.setBackground(new Color(222,220,203));
		 setLayout(new BorderLayout(0, 0));
		 this.add(splitPane);
		 panel_15.setPreferredSize(new Dimension(500, 10));
		 panel_15.setLayout(new BorderLayout(0, 30));
		 panel_15.add(panel, BorderLayout.CENTER);
		 panel.setLayout(new GridLayout(0, 1, 0, 0));
		 panel.add(panel_1);
		 panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_1.add(lbId);
		 textId.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textId.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_1.add(textId);
		 lbImage.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 imgImage.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 imgImage.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_1.add(lbImage);
		 panel_1.add(imgImage);
		 panel.add(panel_2);
		 panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		 lbReference.setHorizontalAlignment(SwingConstants.CENTER);
		 lbReference.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_2.add(lbReference);
		 textReference.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textReference.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_2.add(textReference);
		 panel.add(panel_12);
		 panel_12.setLayout(new GridLayout(2, 1, 0, 0));
		 lbCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		 lbCategorie.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_12.add(lbCategorie);
		 textCategorie.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_12.add(textCategorie);
		 panel.add(panel_11);
		 panel_11.setLayout(new GridLayout(2, 1, 0, 0));
		 lbLibelle.setHorizontalAlignment(SwingConstants.CENTER);
		 lbLibelle.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_11.add(lbLibelle);
		 textLibelle.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textLibelle.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_11.add(textLibelle);
		 panel.add(panel_7);
		 panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		 lbDescription.setHorizontalAlignment(SwingConstants.CENTER);
		 lbDescription.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_7.add(lbDescription);
		 textDescription.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 panel_7.add(textDescription);
		 panel.add(panel_8);
		 panel_8.setLayout(new GridLayout(1, 1, 0, 0));
		 lbPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbPrix.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_8.add(lbPrix);
		 textPrix.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textPrix.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_8.add(textPrix);
		 panel.add(panel_10);
		 panel_10.setLayout(new GridLayout(1, 1, 0, 0));
		 lbQtestock.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbQtestock.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_10.add(lbQtestock);
		 textQtestock.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textQtestock.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_10.add(textQtestock);
		 panel_13.setPreferredSize(new Dimension(10, 30));
		 panel_15.add(panel_13, BorderLayout.SOUTH);
		 panel_13.setLayout(new GridLayout(1, 3, 40, 0));
		 choiceForm.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		 choiceForm.setSelectedIndex(0); 
		 panel_13.add(choiceForm);
		 btAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		 panel_13.add(btAnnuler);
		 btAjouter.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		 panel_13.add(btAjouter);
		 choiceForm.addActionListener(this);
		 this.btAnnuler.addActionListener(this);
		 this.btAjouter.addActionListener(this);
		 textPrix.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();  // ignorer l'événement
	             }
	         }
	      });
		 textQtestock.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();  // ignorer l'événement
	             }
	         }
	      });
		 panel_14.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(160, 50));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
		 panel_14.add(lbTitre, BorderLayout.NORTH);
		 panel_14.add(scrollTab, BorderLayout.CENTER);
		 tableArticles.setShowVerticalLines(false);
		 tableArticles.setEnabled(false);
		 tableArticles.setRowHeight(30);
		 tableArticles.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		    TableColumnModel columnModel = tableArticles.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(10);
		    columnModel.getColumn(1).setPreferredWidth(10);
		    columnModel.getColumn(2).setPreferredWidth(100);
		    columnModel.getColumn(3).setPreferredWidth(300);
		    columnModel.getColumn(4).setPreferredWidth(10);
		    columnModel.getColumn(5).setPreferredWidth(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
			this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
			this.textLibelle.setText("");this.textPrix.setText("");this.textQtestock.setText("");
		}
		else if (e.getSource()==this.btAjouter) {
			Article unArticle = ModeleArticle.selectWhere(textReference.getText());	
			switch(choiceForm.getSelectedIndex()) {
				case 0: //VISUALISE
				{
					if(unArticle == null) 
						{ JOptionPane.showMessageDialog(this, "Veuillez vérifier la reference d'article !"," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
					else {	
						this.textId.setText(String.valueOf(unArticle.getId()));
						this.textReference.setText(unArticle.getReference());
						this.textCategorie.setText(unArticle.getCategorie());
						this.textDescription.setText(unArticle.getDescription());
						this.textLibelle.setText(unArticle.getLibelle());
						this.textPrix.setText(String.valueOf(unArticle.getPrix()));
						this.textQtestock.setText(String.valueOf(unArticle.getQtestock()));
						this.imgImage.setIcon(new ImageIcon("//NASCCB/web/Ecurie" + unArticle.getImageArticle()));
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				case 1: //AJOUTER
					try{
						if((textReference.getText().equals(""))||(textCategorie.getText().equals(""))||(textDescription.getText().equals(""))||(textLibelle.getText().equals(""))||(textPrix.getText().equals(""))||(textQtestock.getText().equals("")))
							{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else if(unArticle != null)
							{ JOptionPane.showMessageDialog(this, " La référence saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {							
							Article insertArticle = new Article(textReference.getText(), textCategorie.getText(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), Integer.parseInt(textQtestock.getText()));
							ModeleArticle.insert(insertArticle);
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textQtestock.setText("");
							JOptionPane.showMessageDialog(this, " Insertion réalisé avec succès ! " ," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp)
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
				case 2: //MODIFIER
					try{
							if(textReference.getText().equals("")) 
								{ JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide"); }
						else {							
							Article editArticle = new Article(textReference.getText(), textCategorie.getText(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), Integer.parseInt(textQtestock.getText()));
							ModeleArticle.update(editArticle, textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textQtestock.setText("");
							JOptionPane.showMessageDialog(this, " Modification reussie avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp) {
					}
				break;
				case 3://SUPPRIMER
					try {
						if(textReference.getText().equals("")) 
							{ JOptionPane.showMessageDialog(this, " Veuillez saisir des valeurs dans les champs vide "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							ModeleArticle.delete(textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textQtestock.setText("");
							JOptionPane.showMessageDialog(this, " Suppression réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);							
						}
						this.setVisible(true);// fin d'enregistrement
					}
					catch (NumberFormatException exp) 
						{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
			}
		}
	}
	
	//extraire les Articles 
	public Object [][] extraireArticles () {
		ArrayList <Article> lesArticles = ModeleArticle.selectAll();
		Object [][] donnees = new Object [lesArticles.size()][6];
		int i =0;
		for (Article unArticle : lesArticles) {
			donnees[i][0] = unArticle.getReference();
			donnees[i][1] = unArticle.getCategorie();
			donnees[i][2] = unArticle.getLibelle();
			donnees[i][3] = unArticle.getDescription();
			donnees[i][4] = unArticle.getPrix();
			donnees[i][5] = unArticle.getQtestock();
			i++;
		}
		return donnees;
	}
}