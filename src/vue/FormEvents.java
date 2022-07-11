package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableColumnModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controleur.Event;
import modele.ModeleEvent;
import com.toedter.calendar.JDateChooser;

public class FormEvents extends JPanel implements ActionListener  {

	private static final long serialVersionUID = -7935938065497628244L;
	String prenom, nom, sexe, imageevent;
	int id, privilege, age, selection;
	Date dateevent;
	String[] formState = { " VISUALISER ", " AJOUTER ", " MODIFIER ", " SUPPRIMER " };
	String[] titresEvent = new String[] {" Référence "," Evènement "," Description "," Prix "," Lieu ", " Date "," Catégorie "};
	Object[][] dataEvent = ModeleEvent.extraireEvents();
	Object[] dataCategorie = ModeleEvent.extraireCategories();
	private final JPanel panelForm = new JPanel();
	private final JPanel panelImageID = new JPanel();
	private final JPanel panelReference = new JPanel();
	private final JPanel panelDescription = new JPanel();
	private final JPanel panelPrix = new JPanel();
	private final JPanel panelDate = new JPanel();
	private final JPanel panelLieu = new JPanel();
	private final JPanel panelNom = new JPanel();
	private final JPanel panelButton = new JPanel();
	private final JPanel panelTable = new JPanel();
	private final JPanel panelFormulaire = new JPanel();
	private final JPanel panelCategorie = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulaire, panelTable);
	private final JTable tableEvents = new JTable(dataEvent, titresEvent);
	private final JScrollPane scrollTab = new JScrollPane(tableEvents);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des évènements ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbReference = new JLabel(" Référence : ");
	private final JLabel lbCategorie = new JLabel(" Catégorie : ");
	private final JLabel lbPrix = new JLabel(" Prix (\u20AC) : ");
	private final JLabel lbDescription = new JLabel(" Description : ");
	private final JLabel lbLibelle = new JLabel(" Nom : ");
	private final JLabel lbLieu = new JLabel(" Lieu : ");
	private final JLabel lbDate = new JLabel(" Date : ");
	private final JLabel lbImage = new JLabel(" Image : ");
	private final JLabel imgImage = new JLabel();
	private final JLabel textId = new JLabel();
	private final JTextField textReference = new JTextField();
	private final JTextField textLibelle = new JTextField();
	private final JTextField textPrix = new JTextField();
	private final JTextField textLieu = new JTextField();
	private final JDateChooser dateChooser = new JDateChooser();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final JTextPane textDescription = new JTextPane();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboBox = new JComboBox(dataCategorie);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	
	public FormEvents()
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
		 imgImage.setHorizontalAlignment(SwingConstants.CENTER);
		 imgImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 panelImageID.add(lbImage);
		 panelImageID.add(imgImage);
		 panelForm.add(panelReference);
		 panelReference.setLayout(new GridLayout(2, 1, 0, 0));
		 lbReference.setHorizontalAlignment(SwingConstants.CENTER);
		 panelReference.add(lbReference);
		 textReference.setHorizontalAlignment(SwingConstants.CENTER);
		 PromptSupport.setPrompt("Indiquer la référence d'un évènement", textReference);
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
		 panelForm.add(panelLieu);
		 panelLieu.setLayout(new GridLayout(2, 1, 0, 0));
		 lbLieu.setHorizontalAlignment(SwingConstants.CENTER);
		 panelLieu.add(lbLieu);
		 textLieu.setHorizontalAlignment(SwingConstants.CENTER);
		 panelLieu.add(textLieu);
		 panelForm.add(panelDate);
		 panelDate.setLayout(new GridLayout(2, 1, 0, 0));
		 lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		 panelDate.add(lbDate);
		 dateChooser.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		 dateChooser.setDateFormatString("dd MMMM yyyy");
		 panelDate.add(dateChooser);
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
		 panelTable.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(150, 100));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 40));
		 panelTable.add(lbTitre, BorderLayout.NORTH);
		 panelTable.add(scrollTab, BorderLayout.CENTER);
		 tableEvents.setShowVerticalLines(false);
		 tableEvents.setEnabled(false);
		 tableEvents.setRowHeight(30);
		    TableColumnModel columnModel = tableEvents.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(50);
		    columnModel.getColumn(1).setPreferredWidth(100);
		    columnModel.getColumn(2).setPreferredWidth(300);
		    columnModel.getColumn(3).setPreferredWidth(10);
		    columnModel.getColumn(4).setPreferredWidth(10);
		    columnModel.getColumn(5).setPreferredWidth(100);
		    columnModel.getColumn(6).setPreferredWidth(50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));
			this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
			this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.dateChooser.setDate(null);
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
						this.comboBox.setSelectedIndex(unEvent.getidCategorie());
						this.textDescription.setText(unEvent.getDescription());
						this.textLibelle.setText(unEvent.getLibelle());
						this.textPrix.setText(String.valueOf(unEvent.getPrix()));
						this.textLieu.setText(unEvent.getLieu());
						try {this.dateChooser.setDate(sdf.parse(unEvent.getDate()));} catch (ParseException e1) {e1.printStackTrace();}
						ImageIcon imageIcon = new ImageIcon(new ImageIcon("//NASCCB/web/Ecurie" + unEvent.getImageEvent()).getImage().getScaledInstance(65, 80, Image.SCALE_DEFAULT));
						this.imgImage.setIcon(imageIcon);
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				case 1: //AJOUTER
					try{
						if((textReference.getText().equals(""))||(comboBox.getSelectedIndex() == 0)||(textDescription.getText().equals(""))||(textLibelle.getText().equals(""))||(textPrix.getText().equals(""))||(textLieu.getText().equals(""))||(dateChooser.getDate().equals(null)))
							{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else if(unEvent != null)
							{ JOptionPane.showMessageDialog(this, " La référence saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							Event insertEvent = new Event(textReference.getText(), comboBox.getSelectedIndex(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), textLieu.getText(), sdf.format(dateChooser.getDate()));
							ModeleEvent.insert(insertEvent);
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.dateChooser.setDate(null);
							JOptionPane.showMessageDialog(this, " Insertion réalisé avec succès ! " ," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp)
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs et formats incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
				case 2: //MODIFIER
					try{
							if(textReference.getText().equals("")) 
								{ JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide"); }
						else {
							Event editEvent = new Event(textReference.getText(), comboBox.getSelectedIndex(), textDescription.getText(), textLibelle.getText(), Integer.parseInt(textPrix.getText()), textLieu.getText(), sdf.format(dateChooser.getDate()));
							ModeleEvent.update(editEvent, textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));	
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.dateChooser.setDate(null);
							JOptionPane.showMessageDialog(this, " Modification reussie avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp)
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs et formats incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
				case 3://SUPPRIMER
					try {
						if(textReference.getText().equals("")) 
							{ JOptionPane.showMessageDialog(this, " Veuillez saisir des valeurs dans les champs vide "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							ModeleEvent.delete(textReference.getText());
							this.textId.setText("");this.imgImage.setIcon(new ImageIcon(""));
							this.textReference.setText("");this.comboBox.setSelectedIndex(0);this.textDescription.setText("");
							this.textLibelle.setText("");this.textPrix.setText("");this.textLieu.setText("");this.dateChooser.setDate(null);
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