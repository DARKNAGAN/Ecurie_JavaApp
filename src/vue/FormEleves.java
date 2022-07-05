package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controleur.Eleve;
import modele.ModeleEleve;

public class FormEleves extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 2192831696580913888L;
	String record, pseudo, prenom, nom, sexe, adresse, mdp, mail, imageeleve;
	int id, privilege, age, selection;
	String[] galop= { "0", "1", "2", "3", "4", "5", "6", "7" }; 
	String[] formState = { " VISUALISER ", " AJOUTER ",  " MODIFIER ", " SUPPRIMER " };
	String[] titresEleve = new String[] {" Pseudo "," E-mail "," Prénom "," Nom "," Adresse "," Sexe "," Age "," Galop "};
	Object[][] dataEleve = extraireEleves();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_14 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_15, panel_14);
	private final JTable tableEleves = new JTable(dataEleve, titresEleve);
	private final JScrollPane scrollTab = new JScrollPane(tableEleves);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des élèves ");
	private final JLabel titreFormateur= new JLabel(" Liste des élèves ");
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
	
	public FormEleves()
	{
		 this.setBackground(new Color(222,220,203));
		 setLayout(new BorderLayout(0, 0));
		 this.add(splitPane);
		 panel_15.setPreferredSize(new Dimension(500, 10));
		 panel_15.setLayout(new BorderLayout(0, 30));
		 panel_15.add(panel, BorderLayout.CENTER);
		 panel.setLayout(new GridLayout(0, 1, 0, 0));
		 lbAvatar.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbAvatar.setIcon(new ImageIcon(imageeleve));
		 panel.add(panel_1);
		 panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 textId.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textId.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_1.add(lbId);
		 panel_1.add(textId);
		 panel_1.add(lbPrivilege);
		 panel_1.add(textPrivilege);
		 lbPrivilege.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbPrivilege.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 textPrivilege.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		 panel.add(panel_2);
		 panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		 lbRecord.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbRecord.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_2.add(lbRecord);
		 textRecord.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textRecord.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_2.add(textRecord);
		 panel_3.setPreferredSize(new Dimension(0, 100));
		 panel.add(panel_3);
		 panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		 lbAvatar.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 imgAvatar.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 imgAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_3.add(lbAvatar);
		 panel_3.add(imgAvatar);
		 panel.add(panel_4);
		 panel_4.setLayout(new GridLayout(1, 1, 0, 0));
		 lbPseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbPseudo.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_4.add(lbPseudo);
		 textPseudo.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_4.add(textPseudo);	
		 panel.add(panel_5);
		 panel.add(panel_6);
		 panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		 lbMdp.setHorizontalAlignment(SwingConstants.CENTER);
		 lbMdp.setFont(new Font("Book Antiqua", Font.BOLD, 20));		 
		 panel_6.add(lbMdp);
		 textMail.setHorizontalAlignment(SwingConstants.CENTER);
		 textMail.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textMdp.setFont(new Font("Bell MT", Font.BOLD, 20));
		 textMdp.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_6.add(textMdp);
		 panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		 lbMail.setHorizontalAlignment(SwingConstants.CENTER);
		 lbMail.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_5.add(lbMail);
		 textMail.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		 panel_5.add(textMail);
		 panel.add(panel_7);
		 panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		 lbPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		 lbPrenom.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		 panel_7.add(lbPrenom);
		 textPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		 textPrenom.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 panel_7.add(textPrenom);
		 panel.add(panel_8);
		 panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		 lbNom.setHorizontalAlignment(SwingConstants.CENTER);
		 lbNom.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_8.add(lbNom);
		 textNom.setHorizontalAlignment(SwingConstants.CENTER);
		 textNom.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 panel_8.add(textNom);
		 panel.add(panel_11);
		 panel_11.setLayout(new GridLayout(2, 1, 0, 0));
		 lbAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		 lbAdresse.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_11.add(lbAdresse);
		 textAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		 textAdresse.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 panel_11.add(textAdresse); 
		 panel_9.setLayout(new GridLayout(1, 1, 0, 0));
		 lbSexe.setHorizontalAlignment(SwingConstants.CENTER);
		 lbSexe.setFont(new Font("Book Antiqua", Font.BOLD, 20));		
		 panel.add(panel_9);		 
		 panel_9.add(lbSexe);
		 groupSexe.add(textSexeF);
		 groupSexe.add(textSexeH);	
		 textSexeF.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textSexeF.setActionCommand("FEMME");		 
		 panel_9.add(textSexeF);
		 textSexeH.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textSexeH.setActionCommand("HOMME");		 
		 panel_9.add(textSexeH);
		 panel.add(panel_10);
		 panel_10.setLayout(new GridLayout(1, 4, 0, 0));
		 lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbAge.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_10.add(lbAge);
		 textAge.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 textAge.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_10.add(textAge);
		 lbGalop.setHorizontalAlignment(SwingConstants.RIGHT);
		 lbGalop.setFont(new Font("Book Antiqua", Font.BOLD, 20)); 
		 panel_10.add(lbGalop);
		 textGalop.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		 panel_10.add(textGalop);
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
		 titreFormateur.setHorizontalAlignment(SwingConstants.CENTER);
		 titreFormateur.setFont(new Font(titreFormateur.getText(), Font.CENTER_BASELINE, 20));
		 panel_14.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(160, 50));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
		 panel_14.add(lbTitre, BorderLayout.NORTH);
		 panel_14.add(scrollTab, BorderLayout.CENTER);
		 tableEleves.setShowVerticalLines(false);
		 tableEleves.setEnabled(false);
		 tableEleves.setRowHeight(30);
		 tableEleves.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
	     TableColumnModel columnModel = tableEleves.getColumnModel();
	     columnModel.getColumn(0).setPreferredWidth(50);
	     columnModel.getColumn(1).setPreferredWidth(80);
	     columnModel.getColumn(2).setPreferredWidth(50);
	     columnModel.getColumn(3).setPreferredWidth(50);
	     columnModel.getColumn(4).setPreferredWidth(100);
	     columnModel.getColumn(5).setPreferredWidth(10);
	     columnModel.getColumn(6).setPreferredWidth(10);
	     columnModel.getColumn(7).setPreferredWidth(10);
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
						this.textRecord.setText(unEleve.getRecord());
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
						this.imgAvatar.setIcon(new ImageIcon("//NASCCB/web/Ecurie" + unEleve.getImageEleve()));						
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
	
	//extraire les Eleves 
	public Object [][] extraireEleves () {
		ArrayList <Eleve> lesEleves = ModeleEleve.selectAll();
		Object [][] donnees = new Object [lesEleves.size()][8];
		int i =0;
		for (Eleve unEleve : lesEleves) {
			donnees[i][0] = unEleve.getPseudo();
			donnees[i][1] = unEleve.getMail();
			donnees[i][2] = unEleve.getPrenom();
			donnees[i][3] = unEleve.getNom();
			donnees[i][4] = unEleve.getAdresse();
			donnees[i][5] = unEleve.getSexe();
			donnees[i][6] = unEleve.getAge();
			donnees[i][7] = unEleve.getGalop();
			i++;
		}
		return donnees;
	}
}