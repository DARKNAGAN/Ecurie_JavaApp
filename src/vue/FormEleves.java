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
import java.text.SimpleDateFormat;

import controleur.Eleve;
import modele.ModeleEleve;

public class FormEleves extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 2192831696580913888L;
	String record, pseudo, prenom, nom, sexe, adresse, mdp, mail, imageeleve;
	int id, privilege, age, selection;
	String[] galop= { "0", "1", "2", "3", "4", "5", "6", "7" }; 
	String[] formState = { " VISUALISER ", " AJOUTER ",  " MODIFIER ", " SUPPRIMER " };
	String[] titresEleve = new String[] {" Pseudo "," E-mail "," Elève "," Adresse "," Sexe "," Age "," Galop "};
	Object[][] dataEleve = ModeleEleve.extraireEleves2();
	private final JPanel panelForm = new JPanel();
	private final JPanel panelPrivilegeID = new JPanel();
	private final JPanel panelRecord = new JPanel();
	private final JPanel panelAvatar = new JPanel();
	private final JPanel panelPseudo = new JPanel();
	private final JPanel panelMail = new JPanel();
	private final JPanel panelMdp = new JPanel();
	private final JPanel panelPrenom = new JPanel();
	private final JPanel panelNom = new JPanel();
	private final JPanel panelSexe = new JPanel();
	private final JPanel panelGalopAge = new JPanel();
	private final JPanel panelAdresse = new JPanel();
	private final JPanel panelButton = new JPanel();
	private final JPanel panelTable = new JPanel();
	private final JPanel panelFormulaire = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulaire, panelTable);
	private final JTable tableEleves = new JTable(dataEleve, titresEleve);
	private final JScrollPane scrollTab = new JScrollPane(tableEleves);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des élèves ");
	private final JLabel lbGalop = new JLabel(" Galop : ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbPrivilege = new JLabel(" Privilège : ");
	private final JLabel lbRecord = new JLabel(" Enregistrer le :");
	private final JLabel lbPseudo = new JLabel(" Pseudo : ");
	private final JLabel lbMail = new JLabel(" E-mail : ");
	private final JLabel lbMdp = new JLabel(" Mot de passe : ");
	private final JLabel lbPrenom = new JLabel(" Prénom : ");
	private final JLabel lbNom = new JLabel(" Nom : ");
	private final JLabel lbAge = new JLabel(" Age : ");
	private final JLabel lbSexe = new JLabel(" Sexe : ");
	private final JLabel lbAdresse = new JLabel(" Adresse : ");
	private final JLabel lbAvatar = new JLabel(" Avatar : ");
	private final JLabel imgAvatar = new JLabel();
	private final JLabel textId = new JLabel();
	private final JLabel textPrivilege = new JLabel();
	private final JLabel textRecord = new JLabel();
	private final JLabel textPseudo = new JLabel();
	private final JTextField textMail = new JTextField();
	private final JTextField textPrenom = new JTextField();
	private final JTextField textNom = new JTextField();
	private final JTextField textAge = new JTextField();
	private final JTextField textAdresse = new JTextField();
	private final JPasswordField textMdp = new JPasswordField();
	private final ButtonGroup groupSexe = new ButtonGroup();
	private final JRadioButton textSexeF = new JRadioButton(" Femme ");
	private final JRadioButton textSexeH = new JRadioButton(" Homme ");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox textGalop = new JComboBox(galop);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	public FormEleves(){
		 this.setBackground(new Color(222,220,203));
		 setLayout(new BorderLayout(0, 0));
		 this.add(splitPane);
		 panelFormulaire.setPreferredSize(new Dimension(500, 10));
		 panelFormulaire.setLayout(new BorderLayout(0, 30));
		 panelFormulaire.add(panelForm, BorderLayout.CENTER);
		 panelForm.setLayout(new GridLayout(0, 1, 0, 0));
		 lbAvatar.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbAvatar.setIcon(new ImageIcon(imageeleve));
		 panelForm.add(panelPrivilegeID);
		 panelPrivilegeID.setLayout(new GridLayout(0, 4, 0, 0));
		 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		 textId.setHorizontalAlignment(SwingConstants.CENTER);
		 panelPrivilegeID.add(lbId);
		 panelPrivilegeID.add(textId);
		 panelPrivilegeID.add(lbPrivilege);
		 panelPrivilegeID.add(textPrivilege);
		 lbPrivilege.setHorizontalAlignment(SwingConstants.RIGHT);
		 textPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		 panelForm.add(panelRecord);
		 panelRecord.setLayout(new GridLayout(1, 2, 0, 0));
		 lbRecord.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelRecord.add(lbRecord);
		 textRecord.setHorizontalAlignment(SwingConstants.CENTER);
		 panelRecord.add(textRecord);
		 panelAvatar.setPreferredSize(new Dimension(0, 100));
		 panelForm.add(panelAvatar);
		 panelAvatar.setLayout(new GridLayout(1, 1, 0, 0));
		 imgAvatar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 imgAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		 panelAvatar.add(lbAvatar);
		 panelAvatar.add(imgAvatar);
		 panelForm.add(panelPseudo);
		 panelPseudo.setLayout(new GridLayout(1, 1, 0, 0));
		 lbPseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelPseudo.add(lbPseudo);
		 textPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		 panelPseudo.add(textPseudo);
		 panelForm.add(panelMail);
		 panelForm.add(panelMdp);
		 panelMdp.setLayout(new GridLayout(2, 1, 0, 0));
		 lbMdp.setHorizontalAlignment(SwingConstants.CENTER);
		 panelMdp.add(lbMdp);
		 textMail.setHorizontalAlignment(SwingConstants.CENTER);
		 PromptSupport.setPrompt("Indiquer l'e-mail d'un élève", textMail);
		 textMdp.setHorizontalAlignment(SwingConstants.CENTER);
		 panelMdp.add(textMdp);
		 panelMail.setLayout(new GridLayout(2, 1, 0, 0));
		 lbMail.setHorizontalAlignment(SwingConstants.CENTER);
		 panelMail.add(lbMail);
		 panelMail.add(textMail);
		 panelForm.add(panelPrenom);
		 panelPrenom.setLayout(new GridLayout(2, 1, 0, 0));
		 lbPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		 panelPrenom.add(lbPrenom);
		 textPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		 panelPrenom.add(textPrenom);
		 panelForm.add(panelNom);
		 panelNom.setLayout(new GridLayout(2, 1, 0, 0));
		 lbNom.setHorizontalAlignment(SwingConstants.CENTER);
		 panelNom.add(lbNom);
		 textNom.setHorizontalAlignment(SwingConstants.CENTER);
		 panelNom.add(textNom);
		 panelForm.add(panelAdresse);
		 panelAdresse.setLayout(new GridLayout(2, 1, 0, 0));
		 lbAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		 panelAdresse.add(lbAdresse);
		 textAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		 panelAdresse.add(textAdresse); 
		 panelSexe.setLayout(new GridLayout(1, 1, 0, 0));
		 lbSexe.setHorizontalAlignment(SwingConstants.CENTER);
		 panelForm.add(panelSexe);
		 panelSexe.add(lbSexe);
		 groupSexe.add(textSexeF);
		 groupSexe.add(textSexeH);	
		 textSexeF.setActionCommand("FEMME");
		 panelSexe.add(textSexeF);
		 textSexeH.setActionCommand("HOMME");
		 panelSexe.add(textSexeH);
		 panelForm.add(panelGalopAge);
		 panelGalopAge.setLayout(new GridLayout(1, 4, 0, 0));
		 lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelGalopAge.add(lbAge);
		 textAge.setHorizontalAlignment(SwingConstants.CENTER);
		 panelGalopAge.add(textAge);
		 lbGalop.setHorizontalAlignment(SwingConstants.RIGHT);
		 panelGalopAge.add(lbGalop);
		 panelGalopAge.add(textGalop);
		 panelButton.setPreferredSize(new Dimension(20, 50));
		 panelFormulaire.add(panelButton, BorderLayout.SOUTH);
		 panelButton.setLayout(new GridLayout(1, 3, 40, 0));
		 choiceForm.setSelectedIndex(0); 
		 panelButton.add(choiceForm);
		 panelButton.add(btAnnuler);
		 panelButton.add(btAjouter);
		 this.choiceForm.addActionListener(this);
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
		 tableEleves.setShowVerticalLines(false);
		 tableEleves.setEnabled(false);
		 tableEleves.setRowHeight(30);
	     TableColumnModel columnModel = tableEleves.getColumnModel();
	     columnModel.getColumn(0).setPreferredWidth(50);
	     columnModel.getColumn(1).setPreferredWidth(80);
	     columnModel.getColumn(2).setPreferredWidth(80);
	     columnModel.getColumn(3).setPreferredWidth(100);
	     columnModel.getColumn(4).setPreferredWidth(10);
	     columnModel.getColumn(5).setPreferredWidth(10);
	     columnModel.getColumn(6).setPreferredWidth(10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.textPrivilege.setText("");this.textRecord.setText("");this.textPseudo.setText("");
			this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");this.textAdresse.setText("");
			this.textAge.setText("");this.textGalop.setSelectedIndex(0);this.groupSexe.clearSelection();this.imgAvatar.setIcon(new ImageIcon(""));
		}
		else if (e.getSource()==this.btAjouter) {
			Eleve unEleve = ModeleEleve.selectWhere(textMail.getText());
			switch(choiceForm.getSelectedIndex()) {
				case 0: //VISUALISE
				{
						
					if(unEleve == null) {
						JOptionPane.showMessageDialog(this, " Veuillez vérifier l'adresse e-mail ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE);
					}
					else {	
						this.textId.setText(String.valueOf(unEleve.getId()));
						this.textPrivilege.setText(String.valueOf(unEleve.getPrivilege()));
						this.textRecord.setText(new SimpleDateFormat("dd MMMM yyyy").format(unEleve.getRecord()));
						this.textPseudo.setText(unEleve.getPseudo());
						this.textPrenom.setText(unEleve.getPrenom());
						this.textNom.setText(unEleve.getNom());
						if (unEleve.getSexe().equals("FEMME")){textSexeF.setSelected(true);}
						else if (unEleve.getSexe().equals("HOMME")){textSexeH.setSelected(true);}
						else {this.groupSexe.clearSelection();}
						this.textAge.setText(String.valueOf(unEleve.getAge()));
						this.textAdresse.setText(unEleve.getAdresse());
						this.textMdp.setText(unEleve.getMdp());
						//mail
						this.textGalop.setSelectedIndex(unEleve.getGalop());
						ImageIcon imageIcon = new ImageIcon(new ImageIcon("//NASCCB/web/Ecurie" + unEleve.getImageEleve()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
						this.imgAvatar.setIcon(imageIcon);
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
				case 1: //AJOUTER
					try{
						if((textNom.getText().equals(""))||(groupSexe.getSelection().getActionCommand().equals(""))||(textAge.getText().equals(""))||(textAdresse.getText().equals(""))||(textMail.getText().equals("")))
							{ JOptionPane.showMessageDialog(this, " Veuillez vérifier ou compléter tous les champs ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else if(unEleve != null)
							{ JOptionPane.showMessageDialog(this, " L'adresse e-mail saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							Eleve insertEleve = new Eleve(textPrenom.getText(), textNom.getText(), groupSexe.getSelection().getActionCommand(), Integer.parseInt(textAge.getText()), textAdresse.getText(), textMail.getText(), textGalop.getSelectedIndex());
							ModeleEleve.insert(insertEleve);
							this.textId.setText("");this.textPrivilege.setText("");this.textRecord.setText("");this.textPseudo.setText("");
							this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");this.textAdresse.setText("");
							this.textAge.setText("");this.textGalop.setSelectedIndex(0);this.groupSexe.clearSelection();this.imgAvatar.setIcon(new ImageIcon(""));
							JOptionPane.showMessageDialog(this, " Insertion réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp)
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
				case 2: //MODIFIER
					try{
							if(textMail.getText().equals("")) 
							{ JOptionPane.showMessageDialog(this, " Veuillez vérifier l'adresse e-mail ! "," Action refusé ",JOptionPane.ERROR_MESSAGE); }
						else {
							Eleve editEleve = new Eleve(textPrenom.getText(), textNom.getText(), groupSexe.getSelection().getActionCommand(), Integer.parseInt(textAge.getText()), textAdresse.getText(), textMail.getText(), textGalop.getSelectedIndex());
							ModeleEleve.update(editEleve, textMail.getText());
							this.textId.setText("");this.textPrivilege.setText("");this.textRecord.setText("");this.textPseudo.setText("");
							this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");this.textAdresse.setText("");
							this.textAge.setText("");this.textGalop.setSelectedIndex(0);this.groupSexe.clearSelection();this.imgAvatar.setIcon(new ImageIcon(""));
							JOptionPane.showMessageDialog(this, " Modification réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
													
						}
						this.setVisible(true); // fin de modification
					}
					catch (NumberFormatException exp) 
					{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				break;
				case 3: //SUPPRIMER
					try {
						if(textMail.getText().equals("")) 
						{ JOptionPane.showMessageDialog(this, " Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
						else {
							ModeleEleve.delete(textMail.getText());
							this.textId.setText("");this.textPrivilege.setText("");this.textRecord.setText("");this.textPseudo.setText("");
							this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");this.textAdresse.setText("");
							this.textAge.setText("");this.textGalop.setSelectedIndex(0);this.groupSexe.clearSelection();this.imgAvatar.setIcon(new ImageIcon(""));
							JOptionPane.showMessageDialog(this, " Suppression réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
						}
						this.setVisible(true); // fin de suppression
					}
					catch (NumberFormatException exp) {
						JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE);
					}
				break;
			}
		}
	}
}