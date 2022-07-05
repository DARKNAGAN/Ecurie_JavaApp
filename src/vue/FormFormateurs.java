package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;

import controleur.Formateur;
import modele.ModeleFormateur;

public class FormFormateurs extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -7023992128997426855L;
	String test, login, prenom, nom, sexe, mail, mdp= "";
	int id, privilege, age, selection;
	String[] galop= { "0", "1", "2", "3", "4", "5", "6", "7" }; 
	String[] formState = { " VISUALISER ", " AJOUTER ", " SUPPRIMER " };
	String[] titresFormateur = new String[] {" Pseudo "," E-mail "," Prénom "," Nom "," Sexe "," Age "," Galop "};
	Object[][] dataFormateur = extraireFormateurs();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_13, panel_12);
	private final JTable tableFormateurs = new JTable(dataFormateur, titresFormateur);
	private final JScrollPane scrollTab = new JScrollPane(tableFormateurs);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des formateurs ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbPrivilege = new JLabel(" Privilège : ");
	private final JLabel lbLogin = new JLabel("Pseudo : ");
	private final JLabel lbMail = new JLabel(" E-mail : ");
	private final JLabel lbMdp = new JLabel(" Mot de passe : ");
	private final JLabel lbPrenom = new JLabel(" Prénom : ");
	private final JLabel lbNom = new JLabel(" Nom : ");
	private final JLabel lbAge = new JLabel(" Age : ");
	private final JLabel lbSexe = new JLabel(" Sexe : ");
	private final JLabel lbGalop = new JLabel(" Galop : ");
	private final JLabel titreFormateur= new JLabel(" Liste des Formateurs ");
	private final JLabel textId = new JLabel();
	private final JLabel textLogin = new JLabel();
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
		panel_13.setPreferredSize(new Dimension(500, 10));
		panel_13.setLayout(new BorderLayout(0, 30));
		panel_13.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbId.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_1.add(lbId);
		textId.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textId);
		lbPrivilege.setHorizontalAlignment(SwingConstants.RIGHT);
		lbPrivilege.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_1.add(lbPrivilege);
		textPrivilege.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textPrivilege);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		lbLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLogin.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_3.add(lbLogin);
		textLogin.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(textLogin);	
		panel.add(panel_4);
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		lbMdp.setHorizontalAlignment(SwingConstants.CENTER);
		lbMdp.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_5.add(lbMdp);
		textMdp.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textMdp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(textMdp);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		lbMail.setHorizontalAlignment(SwingConstants.CENTER);
		lbMail.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_4.add(lbMail);
		textMail.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textMail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(textMail);
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		lbPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrenom.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_6.add(lbPrenom);
		textPrenom.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(textPrenom);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		lbNom.setHorizontalAlignment(SwingConstants.CENTER);
		lbNom.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_7.add(lbNom);
		textNom.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textNom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(textNom);
		panel_10.setLayout(new GridLayout(1, 3, 0, 0));
		lbSexe.setHorizontalAlignment(SwingConstants.CENTER);
		lbSexe.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel.add(panel_10);
		panel_10.add(lbSexe);
		groupSexe.add(textSexeF);
		groupSexe.add(textSexeH);
		textSexeF.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textSexeF.setActionCommand("FEMME");
		panel_10.add(textSexeF);
		textSexeH.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textSexeH.setActionCommand("HOMME");
		panel_10.add(textSexeH);
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 4, 0, 0));
		lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_8.add(lbAge);
		textAge.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textAge.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(textAge);
		lbGalop.setHorizontalAlignment(SwingConstants.RIGHT);
		lbGalop.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		panel_8.add(lbGalop);
		textGalop.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		textGalop.setSelectedIndex(0);
		panel_8.add(textGalop);
		panel_11.setPreferredSize(new Dimension(10, 30));
		panel_13.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new GridLayout(1, 3, 40, 0));
		choiceForm.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		choiceForm.setSelectedIndex(0);
		panel_11.add(choiceForm);
		btAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		panel_11.add(btAnnuler);
		btAjouter.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		panel_11.add(btAjouter);
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
		titreFormateur.setHorizontalAlignment(SwingConstants.CENTER);
		titreFormateur.setFont(new Font(titreFormateur.getText(), Font.CENTER_BASELINE, 20));
		panel_12.setLayout(new BorderLayout(0, 0));
		lbTitre.setPreferredSize(new Dimension(160, 50));
		lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
		panel_12.add(lbTitre, BorderLayout.NORTH);
		panel_12.add(scrollTab, BorderLayout.CENTER);
		tableFormateurs.setShowVerticalLines(false);
		tableFormateurs.setEnabled(false);
		tableFormateurs.setRowHeight(30);
		tableFormateurs.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
	    TableColumnModel columnModel = tableFormateurs.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(50);
	    columnModel.getColumn(1).setPreferredWidth(150);
	    columnModel.getColumn(2).setPreferredWidth(50);
	    columnModel.getColumn(3).setPreferredWidth(50);
	    columnModel.getColumn(4).setPreferredWidth(10);
	    columnModel.getColumn(5).setPreferredWidth(10);
	    columnModel.getColumn(6).setPreferredWidth(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.textLogin.setText("");this.textPrivilege.setText("");
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
					this.textLogin.setText(unEleve.getLogin());
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
							this.textId.setText("");this.textPrivilege.setText("");this.textLogin.setText("");
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
	//extraire les Formateurs 
	public Object [][] extraireFormateurs () {
		ArrayList <Formateur> lesFormateurs = ModeleFormateur.selectAll();
		Object [][] donnees = new Object [lesFormateurs.size()][7];
		int i =0;
		for (Formateur unFormateur : lesFormateurs)
		{
			donnees[i][0] = unFormateur.getLogin();
			donnees[i][1] = unFormateur.getMail();
			donnees[i][2] = unFormateur.getPrenom();
			donnees[i][3] = unFormateur.getNom();
			donnees[i][4] = unFormateur.getSexe();
			donnees[i][5] = unFormateur.getAge();
			donnees[i][6] = unFormateur.getGalop();
			i++;
		}
		return donnees;
	}
}