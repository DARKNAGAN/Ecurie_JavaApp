package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import controleur.Formateur;
import modele.ModeleFormateur;

public class FormFormateurs extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -7023992128997426855L;
	String test, prenom, nom, sexe, mail, mdp= "";
	int id, privilege, age, selection;
	String[] galop= { "0", "1", "2", "3", "4", "5", "6", "7" }; 
	String[] formState = { " VISUALISER ", " AJOUTER ", " SUPPRIMER " };
	String[] titresFormateur = new String[] {" E-mail "," Formateur "," Sexe "," Age "," Galop "};
	Object[][] dataFormateur = ModeleFormateur.extraireFormateurs2();
	private final JPanel panelForm = new JPanel();
	private final JPanel panelPrivilegeID = new JPanel();
	private final JPanel panelMail = new JPanel();
	private final JPanel panelMdp = new JPanel();
	private final JPanel panelPrenom = new JPanel();
	private final JPanel panelNom = new JPanel();
	private final JPanel panelGalopAge = new JPanel();
	private final JPanel panelButton = new JPanel();
	private final JPanel panelTable = new JPanel();
	private final JPanel panelFormulaire = new JPanel();
	private final JPanel panelSexe = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulaire, panelTable);
	private final JTable tableFormateurs = new JTable(dataFormateur, titresFormateur);
	private final JScrollPane scrollTab = new JScrollPane(tableFormateurs);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des formateurs ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbPrivilege = new JLabel(" Privilège : ");
	private final JLabel lbMail = new JLabel(" E-mail : ");
	private final JLabel lbMdp = new JLabel(" Mot de passe : ");
	private final JLabel lbPrenom = new JLabel(" Prénom : ");
	private final JLabel lbNom = new JLabel(" Nom : ");
	private final JLabel lbAge = new JLabel(" Age : ");
	private final JLabel lbSexe = new JLabel(" Sexe : ");
	private final JLabel lbGalop = new JLabel(" Galop : ");
	private final JLabel textId = new JLabel();
	private final JLabel textPrivilege = new JLabel();
	private final JPasswordField textMdp = new JPasswordField();
	private final JTextField textPrenom = new JTextField();
	private final JTextField textNom = new JTextField();
	private final JTextField textAge = new JTextField();
	private final JTextField textMail = new JTextField();
	private final ButtonGroup groupSexe = new ButtonGroup();
	private final JRadioButton textSexeF = new JRadioButton(" Femme ");
	private final JRadioButton textSexeH = new JRadioButton(" Homme ");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final JComboBox textGalop = new JComboBox(galop);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");

	public FormFormateurs()
	{
		setLayout(new BorderLayout(0, 0));
		this.add(splitPane);
		panelFormulaire.setPreferredSize(new Dimension(500, 10));
		panelFormulaire.setLayout(new BorderLayout(0, 30));
		panelFormulaire.add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(new GridLayout(0, 1, 0, 0));
		panelForm.add(panelPrivilegeID);
		panelPrivilegeID.setLayout(new GridLayout(1, 4, 0, 0));
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrivilegeID.add(lbId);
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrivilegeID.add(textId);
		lbPrivilege.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrivilegeID.add(lbPrivilege);
		textPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrivilegeID.add(textPrivilege);
		panelForm.add(panelMail);
		panelForm.add(panelMdp);
		panelMdp.setLayout(new GridLayout(0, 1, 0, 0));
		lbMdp.setHorizontalAlignment(SwingConstants.CENTER);
		panelMdp.add(lbMdp);
		textMdp.setHorizontalAlignment(SwingConstants.CENTER);
		panelMdp.add(textMdp);
		panelMail.setLayout(new GridLayout(2, 1, 0, 0));
		lbMail.setHorizontalAlignment(SwingConstants.CENTER);
		panelMail.add(lbMail);
		textMail.setHorizontalAlignment(SwingConstants.CENTER);
		 PromptSupport.setPrompt("Indiquer l'e-mail d'un formateur", textMail);
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
		panelSexe.setLayout(new GridLayout(1, 3, 0, 0));
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
		textGalop.setSelectedIndex(0);
		panelGalopAge.add(textGalop);
		panelButton.setPreferredSize(new Dimension(23, 50));
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
		tableFormateurs.setShowVerticalLines(false);
		tableFormateurs.setEnabled(false);
		tableFormateurs.setRowHeight(30);
	    TableColumnModel columnModel = tableFormateurs.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(150);
	    columnModel.getColumn(1).setPreferredWidth(80);
	    columnModel.getColumn(2).setPreferredWidth(10);
	    columnModel.getColumn(3).setPreferredWidth(10);
	    columnModel.getColumn(4).setPreferredWidth(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.textPrivilege.setText("");
			this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");
			this.textAge.setText("");this.textGalop.setSelectedIndex(0);this.groupSexe.clearSelection();
		}
		else if (e.getSource()==this.btAjouter) {
			Formateur unEleve = ModeleFormateur.selectWhere(textMail.getText());
			Formateur unCompte = ModeleFormateur.selectCompte(textMail.getText(),new String(this.textMdp.getPassword()));
			switch(choiceForm.getSelectedIndex()) {
			case 0: //VISUALISE
			{
				if(unEleve == null) 
				{ JOptionPane.showMessageDialog(this, " Veuillez vérifier l'adresse mail saisie ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
				else {
					this.textId.setText(String.valueOf(unEleve.getId()));
					this.textPrivilege.setText(String.valueOf(unEleve.getPrivilege()));
					//mail
					this.textMdp.setText(unEleve.getMdp());
					this.textPrenom.setText(unEleve.getPrenom());
					this.textNom.setText(unEleve.getNom());
					this.textAge.setText(String.valueOf(unEleve.getAge()));
					this.textGalop.setSelectedIndex(unEleve.getGalop());
					if (unEleve.getSexe().equals("FEMME")){textSexeF.setSelected(true);}
					else if (unEleve.getSexe().equals("HOMME")){textSexeH.setSelected(true);}
					else {this.groupSexe.clearSelection();}
					JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			break;
			case 1: //AJOUTER
				try{
					if((textNom.getText().equals(""))||(groupSexe.getSelection().getActionCommand().equals(""))||(textAge.getText().equals(""))||(textMail.getText().equals(""))||(String.valueOf(textMdp.getPassword()).equals("")))
					{ JOptionPane.showMessageDialog(this, " Veuillez vérifier ou compléter tous les champs ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE);	}
					else if(unEleve != null)
					{ JOptionPane.showMessageDialog(this, " L'adresse e-mail saisi est déjà existante ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
					else {	
						Formateur insertFormateur = new Formateur(textPrenom.getText(), textNom.getText(), Integer.parseInt(textAge.getText()),textGalop.getSelectedIndex(), groupSexe.getSelection().getActionCommand(), textMail.getText(), String.valueOf(textMdp.getPassword()));
						ModeleFormateur.insert(insertFormateur);
						this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");
						this.groupSexe.clearSelection();this.textAge.setText("");this.textGalop.setSelectedIndex(0);
						JOptionPane.showMessageDialog(this, " Insertion réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
					this.setVisible(true);// fin d'ajout
				}
				catch (NumberFormatException exp)
				{ JOptionPane.showMessageDialog(this," Veuillez vérifier tous les champs incorrects ! "," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
			break;
				case 2: //DELETE
					try {
						if((textMail.getText().equals("")) && (String.valueOf(textMdp.getPassword()).equals("")) || (unCompte == null)) 
						{ JOptionPane.showMessageDialog(this, " Veuillez vérifier l'adresse e-mail et confirmer le mot de passe ! "," Action refusé ",JOptionPane.ERROR_MESSAGE); }
						else {
							ModeleFormateur.delete(textMail.getText());
							this.textId.setText("");this.textPrivilege.setText("");
							this.textPrenom.setText("");this.textNom.setText("");this.textMail.setText("");this.textMdp.setText("");
							this.groupSexe.clearSelection();this.textAge.setText("");this.textGalop.setSelectedIndex(0);
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