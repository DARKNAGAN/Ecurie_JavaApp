package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controleur.Article;
import modele.ModeleArticle;
import javax.swing.border.EtchedBorder;
import org.jdesktop.swingx.prompt.PromptSupport;


public class FormArticles extends JPanel implements ActionListener  {

	private static final long serialVersionUID = -7935938065497628244L;
	String prenom, nom, sexe, imagearticle;
	int id, privilege, age, selection;
	String[] formState = { " VISUALISER ", " AJOUTER ", " MODIFIER ", " SUPPRIMER " };
	String[] titresArticle = new String[] {" Référence "," Produit "," Description "," Catégorie "," Prix "," Quantité "};
	Object[][] dataArticle = ModeleArticle.extraireArticles();
	Object[] dataCategorie = ModeleArticle.extraireCategories();
	private final JPanel panelForm = new JPanel();
	private final JPanel panelImageID = new JPanel();
	private final JPanel panelReference = new JPanel();
	private final JPanel panelDescription = new JPanel();
	private final JPanel panelPrix = new JPanel();
	private final JPanel panelQuantite = new JPanel();
	private final JPanel panelNom = new JPanel();
	private final JPanel panelButton = new JPanel();
	private final JPanel panelTable = new JPanel();
	private final JPanel panelFormulaire = new JPanel();
	private final JPanel panelCategorie = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulaire, panelTable);
	private final JTable tableArticles = new JTable(dataArticle, titresArticle);
	private final JScrollPane scrollTab = new JScrollPane(tableArticles);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des articles ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbReference = new JLabel(" Référence : ");
	private final JLabel lbCategorie = new JLabel(" Catégorie : ");
	private final JLabel lbPrix = new JLabel(" Prix (\u20AC) : ");
	private final JLabel lbDescription = new JLabel(" Description : ");
	private final JLabel lbLibelle = new JLabel(" Nom : ");
	private final JLabel lbQtestock = new JLabel(" Quantité (/pièce) : ");
	private final JLabel lbImage = new JLabel(" Image : ");
	private final JLabel imgImage = new JLabel();
	private final JLabel textId = new JLabel();
	private final JTextField textReference = new JTextField();
	private final JTextField textLibelle = new JTextField();
	private final JTextField textPrix = new JTextField();
	private final JTextField textQtestock = new JTextField();
	private final JTextPane textDescription = new JTextPane();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboBox = new JComboBox(dataCategorie);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	
	public FormArticles()
	{
		 this.setBackground(new Color(222,220,203));
		 setLayout(new BorderLayout(0, 0));
		 this.add(splitPane);
		 panelFormulaire.setPreferredSize(new Dimension(500, 10));
		 panelFormulaire.setLayout(new BorderLayout(0, 30));
		 panelFormulaire.add(panelForm, BorderLayout.CENTER);
		 panelForm.setLayout(new GridLayout(0, 1, 0, 0));
		 panelForm.add(panelImageID);
		 panelImageID.setLayout(new GridLayout(1, 4, 0, 0));
		 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelImageID.add(lbId);
		 textId.setHorizontalAlignment(SwingConstants.CENTER);
		 panelImageID.add(textId);
		 imgImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 imgImage.setHorizontalAlignment(SwingConstants.CENTER);
		 panelImageID.add(lbImage);
		 panelImageID.add(imgImage);
		 panelForm.add(panelReference);
		 panelReference.setLayout(new GridLayout(2, 1, 0, 0));
		 lbReference.setHorizontalAlignment(SwingConstants.CENTER);
		 panelReference.add(lbReference);
		 PromptSupport.setPrompt("Indiquer une référence d'un article", textReference);
		 textReference.setHorizontalAlignment(SwingConstants.CENTER);
		 panelReference.add(textReference);
		 panelForm.add(panelNom);
		 panelNom.setLayout(new GridLayout(2, 1, 0, 0));
		 lbLibelle.setHorizontalAlignment(SwingConstants.CENTER);
		 panelNom.add(lbLibelle);
		 textLibelle.setHorizontalAlignment(SwingConstants.CENTER);
		 panelNom.add(textLibelle);
		 panelForm.add(panelDescription);
		 panelDescription.setLayout(new GridLayout(2, 1, 0, 0));
		 lbDescription.setHorizontalAlignment(SwingConstants.CENTER);
		 panelDescription.add(lbDescription);
		 panelDescription.add(textDescription);
		 panelForm.add(panelCategorie);
		 panelCategorie.setLayout(new GridLayout(2, 1, 0, 0));
		 lbCategorie.setHorizontalAlignment(SwingConstants.CENTER);
		 panelCategorie.add(lbCategorie);
		 panelCategorie.add(comboBox);
		 panelForm.add(panelPrix);
		 panelPrix.setLayout(new GridLayout(1, 1, 0, 0));
		 lbPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelPrix.add(lbPrix);
		 textPrix.setHorizontalAlignment(SwingConstants.CENTER);
		 panelPrix.add(textPrix);
		 panelForm.add(panelQuantite);
		 panelQuantite.setLayout(new GridLayout(1, 1, 0, 0));
		 lbQtestock.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelQuantite.add(lbQtestock);
		 textQtestock.setHorizontalAlignment(SwingConstants.CENTER);
		 panelQuantite.add(textQtestock);
		 panelButton.setPreferredSize(new Dimension(20, 50));
		 panelFormulaire.add(panelButton, BorderLayout.SOUTH);
		 panelButton.setLayout(new GridLayout(1, 3, 40, 0));
		 choiceForm.setSelectedIndex(0); 
		 panelButton.add(choiceForm);
		 panelButton.add(btAnnuler);
		 panelButton.add(btAjouter);
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
		 panelTable.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(150, 100));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 40));
		 panelTable.add(lbTitre, BorderLayout.NORTH);
		 panelTable.add(scrollTab, BorderLayout.CENTER);
		 tableArticles.setShowVerticalLines(false);
		 tableArticles.setEnabled(false);
		 tableArticles.setRowHeight(30);
		    TableColumnModel columnModel = tableArticles.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(10);
		    columnModel.getColumn(1).setPreferredWidth(100);
		    columnModel.getColumn(2).setPreferredWidth(300);
		    columnModel.getColumn(3).setPreferredWidth(10);
		    columnModel.getColumn(4).setPreferredWidth(10);
		    columnModel.getColumn(5).setPreferredWidth(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));
			this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
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
						this.comboBox.setSelectedIndex(unArticle.getidCategorie());
						this.textDescription.setText(unArticle.getDescription());
						this.textLibelle.setText(unArticle.getLibelle());
						this.textPrix.setText(String.valueOf(unArticle.getPrix()));
						this.textQtestock.setText(String.valueOf(unArticle.getQtestock()));
						ImageIcon imageIcon = new ImageIcon(new ImageIcon("//NASCCB/web/Ecurie" + unArticle.getImageArticle()).getImage().getScaledInstance(75, 85, Image.SCALE_DEFAULT));
						this.imgImage.setIcon(imageIcon);
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				case 1: //AJOUTER
					try{
						if((textReference.getText().equals(""))||(comboBox.getSelectedIndex()==0)||(textDescription.getText().equals(""))||(textLibelle.getText().equals(""))||(textPrix.getText().equals(""))||(textQtestock.getText().equals("")))
							{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else if(unArticle != null)
							{ JOptionPane.showMessageDialog(this, " La référence saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							Article insertArticle = new Article(textReference.getText(), comboBox.getSelectedIndex(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), Integer.parseInt(textQtestock.getText()));
							ModeleArticle.insert(insertArticle);
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
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
							Article editArticle = new Article(textReference.getText(), comboBox.getSelectedIndex(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), Integer.parseInt(textQtestock.getText()));
							ModeleArticle.update(editArticle, textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
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
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
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
}