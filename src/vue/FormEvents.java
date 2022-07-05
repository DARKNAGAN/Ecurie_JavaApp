package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controleur.Event;
import modele.ModeleEvent;


public class FormEvents extends JPanel implements ActionListener  {

	private static final long serialVersionUID = -7935938065497628244L;
	String prenom, nom, sexe, imageevent;
	int id, privilege, age, selection;
	String[] formState = { " VISUALISER ", " AJOUTER ", " MODIFIER ", " SUPPRIMER " };
	String[] titresEvent = new String[] {" Référence "," Categorie "," Evenement "," Description "," Prix "," Lieu ", " Date "};
	Object[][] dataEvent = extraireEvents();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_14 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_15, panel_14);
	private final JTable tableEvents = new JTable(dataEvent, titresEvent);
	private final JScrollPane scrollTab = new JScrollPane(tableEvents);
	private final JLabel lbTitre = new JLabel(" Panneau de Gestion des Evenements ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbReference = new JLabel(" Référence de l'évènement : ");
	private final JLabel lbCategorie = new JLabel(" Catégorie de l'évènement : ");
	private final JLabel lbPrix = new JLabel(" Prix de l'évènement (\u20AC) : ");
	private final JLabel lbDescription = new JLabel(" Description : ");
	private final JLabel lbLibelle = new JLabel(" Nom de l'évènement : ");
	private final JLabel lbLieu = new JLabel(" Lieu de l'évènement : ");
	private final JLabel lbDate = new JLabel(" Date de l'évènement : ");
	private final JLabel lbImage = new JLabel(" Image : ");
	private final JLabel imgImage = new JLabel();
	private final JLabel textId = new JLabel();
	private final JTextField textReference = new JTextField();
	private final JTextField textCategorie = new JTextField();
	private final JTextField textLibelle = new JTextField();
	private final JTextField textPrix = new JTextField();
	private final JTextField textLieu = new JTextField();
	private final JTextField textDate = new JTextField();
	private final JTextPane textDescription = new JTextPane();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	public FormEvents()
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
		 panel.add(panel_10);
		 panel_10.setLayout(new GridLayout(2, 1, 0, 0));
		 lbLieu.setHorizontalAlignment(SwingConstants.CENTER);
		 lbLieu.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_10.add(lbLieu);
		 textLieu.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textLieu.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_10.add(textLieu);
		 panel.add(panel_9);
		 panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		 lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		 lbDate.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_9.add(lbDate);
		 textDate.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textDate.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_9.add(textDate);
		 panel.add(panel_8);
		 panel_8.setLayout(new GridLayout(1, 1, 0, 0));
		 lbPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbPrix.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_8.add(lbPrix);
		 textPrix.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textPrix.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_8.add(textPrix);
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
		 panel_14.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(160, 50));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
		 panel_14.add(lbTitre, BorderLayout.NORTH);
		 panel_14.add(scrollTab, BorderLayout.CENTER);
		 tableEvents.setShowVerticalLines(false);
		 tableEvents.setEnabled(false);
		 tableEvents.setRowHeight(30);
		 tableEvents.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		    TableColumnModel columnModel = tableEvents.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(10);
		    columnModel.getColumn(1).setPreferredWidth(10);
		    columnModel.getColumn(2).setPreferredWidth(100);
		    columnModel.getColumn(3).setPreferredWidth(300);
		    columnModel.getColumn(4).setPreferredWidth(10);
		    columnModel.getColumn(5).setPreferredWidth(10);
		    columnModel.getColumn(6).setPreferredWidth(100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));
			this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
			this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.textDate.setText("");
		}
		else if (e.getSource()==this.btAjouter) {
			Event unEvent = ModeleEvent.selectWhere(textReference.getText());
			switch(choiceForm.getSelectedIndex()) {
				case 0: //VISUALISE
				{
					if(unEvent == null) 
						{ JOptionPane.showMessageDialog(this, "Veuillez vérifier la reference d'évènement !"," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
					else {	
						this.textId.setText(String.valueOf(unEvent.getId()));
						this.textReference.setText(unEvent.getReference());
						this.textCategorie.setText(unEvent.getCategorie());
						this.textDescription.setText(unEvent.getDescription());
						this.textLibelle.setText(unEvent.getLibelle());
						this.textPrix.setText(String.valueOf(unEvent.getPrix()));
						this.textLieu.setText(unEvent.getLieu());
						this.textDate.setText(unEvent.getDate());
						this.imgImage.setIcon(new ImageIcon("//NASCCB/web/Ecurie" + unEvent.getImageEvent()));
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				case 1: //AJOUTER
					try{
						if((textReference.getText().equals(""))||(textCategorie.getText().equals(""))||(textDescription.getText().equals(""))||(textLibelle.getText().equals(""))||(textPrix.getText().equals(""))||(textLieu.getText().equals(""))||(textDate.getText().equals("")))
							{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else if(unEvent != null)
							{ JOptionPane.showMessageDialog(this, " La référence saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							Event insertEvent = new Event(textReference.getText(), textCategorie.getText(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), textLieu.getText(), textDate.getText());
							ModeleEvent.insert(insertEvent);
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.textDate.setText("");
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
							Event editEvent = new Event(textReference.getText(), textCategorie.getText(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), textLieu.getText(), textDate.getText());
							ModeleEvent.update(editEvent, textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.textDate.setText("");
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
							ModeleEvent.delete(textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));
							this.textReference.setText("");this.textCategorie.setText("");this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.textDate.setText("");
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
	
	//extraire les Events 
	public Object [][] extraireEvents () {
		ArrayList <Event> lesEvents = ModeleEvent.selectAll();
		Object [][] donnees = new Object [lesEvents.size()][7];
		int i =0;
		for (Event unEvent : lesEvents) {
			donnees[i][0] = unEvent.getReference();
			donnees[i][1] = unEvent.getCategorie();
			donnees[i][2] = unEvent.getLibelle();
			donnees[i][3] = unEvent.getDescription();
			donnees[i][4] = unEvent.getPrix();
			donnees[i][5] = unEvent.getLieu();
			donnees[i][6] = unEvent.getDate();
			i++;
		}
		return donnees;
	}
}