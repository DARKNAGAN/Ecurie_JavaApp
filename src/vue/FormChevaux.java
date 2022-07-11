package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controleur.Cheval;
import modele.ModeleCheval;

public class FormChevaux extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -2223951904837426516L;
	String id, nom, sexe, robe, type, race, proprietaire, age, imagecheval = "";
	int selection;
	String[] formState = { " VISUALISER ", " AJOUTER ", " SUPPRIMER " };
	String[] titresChevaux = new String[] {" Nom ", " Sexe ", " Age ", " Propriétaire ", " Race ", " Robe ", " Type "};
	Object[][] dataChevaux =  ModeleCheval.extraireChevaux2();
	private final JPanel panelFormulaire = new JPanel();
	private final JPanel panelButton = new JPanel();
	private final JPanel panelTable = new JPanel();
	private final JPanel panelForm = new JPanel();
	private final JPanel panelPictureID = new JPanel();
	private final JPanel panelNom = new JPanel();
	private final JPanel panelSexe = new JPanel();
	private final JPanel panelRobe = new JPanel();
	private final JPanel panelType = new JPanel();
	private final JPanel panelRace = new JPanel();
	private final JPanel panelProprietaire = new JPanel();
	private final JPanel panelAge = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulaire, panelTable);
	private final JTable tableChevaux = new JTable(dataChevaux, titresChevaux);
	private final JScrollPane scrollTab = new JScrollPane(tableChevaux);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des chevaux ");
	private final JLabel lbRace = new JLabel(" Race : ");
	private final JLabel lbRobe = new JLabel(" Robe : ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbAge = new JLabel(" Age : ");
	private final JLabel lbNom = new JLabel(" Nom : ");
	private final JLabel lbSexe = new JLabel(" Sexe : ");
	private final JLabel lbType = new JLabel(" Type :");
	private final JLabel lbProprietaire = new JLabel(" Propriétaire : ");
	private final JLabel lbPhoto = new JLabel(" Photo : ");
	private final JLabel imgPhoto = new JLabel();
	private final JLabel textId = new JLabel();
	private final JTextField textAge = new JTextField();
	private final JTextField textRobe = new JTextField();
	private final JTextField textProprietaire = new JTextField();
	private final JTextField textRace = new JTextField();
	private final JTextField textType = new JTextField();
	private final JTextField textNom = new JTextField();
	private final JRadioButton textSexeF = new JRadioButton(" Femelle ");
	private final JRadioButton textSexeH = new JRadioButton(" Mâle ");
	private final ButtonGroup groupSexe = new ButtonGroup();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");

	public FormChevaux(){
	 this.setBackground(new Color(222,220,203));
	 setLayout(new BorderLayout(0, 0));	
	 this.add(splitPane);
	 panelFormulaire.setPreferredSize(new Dimension(500, 10));
	 panelFormulaire.setLayout(new BorderLayout(0, 30));
	 panelFormulaire.add(panelForm);
	 panelForm.setLayout(new GridLayout(0, 1, 0, 0));
	 panelForm.add(panelPictureID);
	 panelPictureID.setLayout(new GridLayout(1, 4, 0, 0));
	 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
	 panelPictureID.add(lbId);	 
	 textId.setHorizontalAlignment(SwingConstants.CENTER);
	 panelPictureID.add(textId);
	 imgPhoto.setHorizontalAlignment(SwingConstants.CENTER);
	 imgPhoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	 panelPictureID.add(lbPhoto);
	 panelPictureID.add(imgPhoto);
	 panelForm.add(panelNom);
	 panelNom.setLayout(new GridLayout(2, 1, 0, 0));
	 lbNom.setHorizontalAlignment(SwingConstants.CENTER);
	 panelNom.add(lbNom);
	 textNom.setHorizontalAlignment(SwingConstants.CENTER);
	 PromptSupport.setPrompt("Indiquer le nom d'un cheval", textNom);
	 panelNom.add(textNom);
	 panelForm.add(panelSexe);
	 panelSexe.setLayout(new GridLayout(1, 1, 0, 0));
	 lbSexe.setHorizontalAlignment(SwingConstants.CENTER);
	 panelSexe.add(lbSexe);
	 groupSexe.add(textSexeF);
	 groupSexe.add(textSexeH);	
	 textSexeF.setActionCommand("FEMELLE");
	 panelSexe.add(textSexeF);
	 textSexeH.setActionCommand("MALE");
	 panelSexe.add(textSexeH);
	 panelForm.add(panelAge);
	 panelAge.setLayout(new GridLayout(1, 1, 0, 0));
	 lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
	 panelAge.add(lbAge);
	 textAge.setHorizontalAlignment(SwingConstants.CENTER);
	 panelAge.add(textAge);
	 panelForm.add(panelRobe);
	 panelRobe.setLayout(new GridLayout(2, 1, 0, 0));
	 lbRobe.setHorizontalAlignment(SwingConstants.CENTER);
	 panelRobe.add(lbRobe);
	 textRobe.setHorizontalAlignment(SwingConstants.CENTER);
	 panelRobe.add(textRobe);	
	 panelForm.add(panelType);
	 panelType.setLayout(new GridLayout(2, 1, 0, 0));
	 lbType.setHorizontalAlignment(SwingConstants.CENTER);
	 panelType.add(lbType);
	 textType.setHorizontalAlignment(SwingConstants.CENTER);
	 panelType.add(textType);
	 panelForm.add(panelRace);
	 panelRace.setLayout(new GridLayout(2, 1, 0, 0));
	 lbRace.setHorizontalAlignment(SwingConstants.CENTER);
	 panelRace.add(lbRace);
	 textRace.setHorizontalAlignment(SwingConstants.CENTER);
	 panelRace.add(textRace);	 
	 panelForm.add(panelProprietaire);
	 panelProprietaire.setLayout(new GridLayout(2, 1, 0, 0));
	 lbProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
	 panelProprietaire.add(lbProprietaire);
	 textProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
	 panelProprietaire.add(textProprietaire);
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
	    textAge.addKeyListener(new KeyAdapter() {
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
	 tableChevaux.setShowVerticalLines(false);
	 tableChevaux.setEnabled(false);
	 tableChevaux.setRowHeight(30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler){
			this.textId.setText("");this.imgPhoto.setIcon(new ImageIcon(""));
			this.textNom.setText("");this.groupSexe.clearSelection();this.textAge.setText("");
			this.textRobe.setText("");this.textType.setText("");this.textRace.setText("");this.textProprietaire.setText("");
		}
		else if (e.getSource()==this.btAjouter) {
			Cheval unCheval = ModeleCheval.selectWhere(textNom.getText());
			switch(choiceForm.getSelectedIndex()) {
			case 0: //VISUALISE
			{
				if(unCheval == null) {
					JOptionPane.showMessageDialog(this, " Veuillez vérifier le nom du cheval ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE);
				}
				else {
					this.textId.setText(String.valueOf(unCheval.getId()));
					this.textNom.setText(unCheval.getNom());
					if (unCheval.getSexe().equals("FEMELLE")){textSexeF.setSelected(true);}
					else if (unCheval.getSexe().equals("MALE")){textSexeH.setSelected(true);}
					else {this.groupSexe.clearSelection();}
					this.textRobe.setText(String.valueOf(unCheval.getRobe()));
					this.textType.setText(unCheval.getType());
					this.textRace.setText(unCheval.getRace());
					this.textProprietaire.setText(unCheval.getProprietaire());
					this.textAge.setText(String.valueOf(unCheval.getAge()));
					ImageIcon imageIcon = new ImageIcon(new ImageIcon("//NASCCB/web/Ecurie" + unCheval.getImage()).getImage().getScaledInstance(70, 85, Image.SCALE_DEFAULT));
					this.imgPhoto.setIcon(imageIcon);
					JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			break;
			case 1: //AJOUTER
				try{
					this.textNom.getText();
					if((textNom.getText().equals(""))||(textRobe.getText().equals(""))||(textType.getText().equals(""))||(textRace.getText().equals(""))||(textProprietaire.getText().equals(""))||(textAge.getText().equals(""))) 
					{ JOptionPane.showMessageDialog(this, " Veuillez vérifier ou compléter tous les champs ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
					else if(unCheval != null)
					{ JOptionPane.showMessageDialog(this, " Le nom saisi est déjà existante ! "," Action refusé ",JOptionPane.ERROR_MESSAGE); }
					else {
						Cheval insertCheval = new Cheval(textNom.getText(), groupSexe.getSelection().getActionCommand(), textRobe.getText(), textType.getText(), textRace.getText(), textProprietaire.getText(), Integer.parseInt(textAge.getText()));
						ModeleCheval.insert(insertCheval);
						this.textId.setText("");this.imgPhoto.setIcon(new ImageIcon(""));
						this.textNom.setText("");this.groupSexe.clearSelection();this.textAge.setText("");
						this.textRobe.setText("");this.textType.setText("");this.textRace.setText("");this.textProprietaire.setText("");
						JOptionPane.showMessageDialog(this, " Insertion réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
					this.setVisible(true); // fin d'ajout
				}
				catch (NumberFormatException exp)
				{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
			break;
				case 2: //DELETE
					try {
						if(textNom.getText().equals(""))
							{ JOptionPane.showMessageDialog(this, " Veuillez vérifier le nom du cheval ! "," Action refusé ",JOptionPane.ERROR_MESSAGE); }
						else {
							ModeleCheval.delete(textNom.getText());
							this.textId.setText("");this.imgPhoto.setIcon(new ImageIcon(""));
							this.textNom.setText("");this.groupSexe.clearSelection();this.textAge.setText("");
							this.textRobe.setText("");this.textType.setText("");this.textRace.setText("");this.textProprietaire.setText("");
							JOptionPane.showMessageDialog(this, " Suppression réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true);// fin de suppression
					}
					catch (NumberFormatException exp)
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
			}
		}
	}	
}