package vue.Formulaire;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import controleur.Eleve;
import modele.ModeleEleve;

public class FormEleves extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 2192831696580913888L;
	String[] formState = { "VISUALISER", "AJOUTER",  "MODIFIER", "SUPPRIMER" };
	String record, pseudo, prenom, nom, sexe, adresse, mdp, mail, imageeleve;
	int id, privilege, age, galop, selection;
	private JComboBox choiceForm = new JComboBox(formState);
	private JLabel txtId = new JLabel();
	private JLabel txtPrivilege = new JLabel();
	private JLabel txtRecord = new JLabel();
	private JLabel txtPseudo = new JLabel();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtNom = new JTextField();
	private ButtonGroup groupSexe = new ButtonGroup();
	private JRadioButton txtSexeF = new JRadioButton("Femme");
	private JRadioButton txtSexeH = new JRadioButton("Homme");
	private JTextField txtAge = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JLabel txtMdp = new JLabel();
	private JTextField txtMail = new JTextField();
	private JTextField txtGalop = new JTextField();
	//IMG Eleve
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Editer");
	public FormEleves()
	{
		//Configuration des composants
		JLabel lbVide1 = new JLabel("");JLabel lbVide2 = new JLabel("");JLabel lbVide3 = new JLabel("");JLabel lbVide4 = new JLabel("");
		this.setBounds(50, 80, 650, 250);this.setLayout(new GridLayout(0, 2));this.setBackground(new Color(222,220,203));
		JLabel lbId = new JLabel(" ID :");lbId.setFont(new Font(lbId.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbPrivilege = new JLabel(" Privilege :");lbPrivilege.setFont(new Font(lbPrivilege.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbRecord = new JLabel(" Enregistré le :");lbRecord.setFont(new Font(lbRecord.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbPseudo = new JLabel(" Pseudo :");lbPseudo.setFont(new Font(lbPseudo.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbPrenom = new JLabel(" Prenom :");lbPrenom.setFont(new Font(lbPrenom.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbNom = new JLabel(" Nom :");lbNom.setFont(new Font(lbNom.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbSexe = new JLabel(" Sexe :");lbSexe.setFont(new Font(lbSexe.getText(), Font.CENTER_BASELINE, 18));
		txtSexeF.setMnemonic(KeyEvent.VK_B);txtSexeF.setActionCommand("FEMME");txtSexeF.setSelected(true);
		txtSexeH.setMnemonic(KeyEvent.VK_B);txtSexeH.setActionCommand("HOMME");	
		groupSexe.add(txtSexeF);groupSexe.add(txtSexeH);
		JLabel lbAge = new JLabel(" Âge :");lbAge.setFont(new Font(lbAge.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbAdresse = new JLabel(" Adresse :");lbAdresse.setFont(new Font(lbAdresse.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbMdp = new JLabel(" Mot de Passe :");lbMdp.setFont(new Font(lbMdp.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbMail = new JLabel(" E-mail :");lbMail.setFont(new Font(lbMail.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbGalop = new JLabel(" Galop :");lbGalop.setFont(new Font(lbGalop.getText(), Font.CENTER_BASELINE, 18));
		choiceForm.setSelectedIndex(0);choiceForm.addActionListener(this);
		this.btAnnuler.setIcon(new ImageIcon(new ImageIcon("src/images/choix1.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAnnuler.addActionListener(this);
		this.btAjouter.setIcon(new ImageIcon(new ImageIcon("src/images/choix2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAjouter.addActionListener(this);
		// Affichage des composants
		this.add(lbId); this.add(this.txtId);
		this.add(lbPrivilege); this.add(this.txtPrivilege);
		this.add(lbRecord); this.add(this.txtRecord);
		this.add(lbPseudo); this.add(this.txtPseudo);
		this.add(lbMail); this.add(this.txtMail);
		this.add(lbMdp); this.add(this.txtMdp);
		this.add(lbPrenom); this.add(this.txtPrenom);
		this.add(lbNom); this.add(this.txtNom);
		this.add(lbSexe); this.add(this.txtSexeF);
		this.add(lbVide1); this.add(this.txtSexeH);
		this.add(lbAge); this.add(this.txtAge);
		this.add(lbAdresse); this.add(this.txtAdresse);
		this.add(lbGalop); this.add(this.txtGalop);
		this.add(this.choiceForm); this.add(lbVide2);
		this.add(this.btAnnuler); this.add(this.btAjouter);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		if(e.getSource()==this.btAnnuler) {
			this.txtId.setText("");
			this.txtPrivilege.setText("");
			this.txtRecord.setText("");
			this.txtPseudo.setText("");
			this.txtPrenom.setText("");this.txtPrenom.setBackground(Color.WHITE);
			this.txtNom.setText("");this.txtNom.setBackground(Color.WHITE);
			this.txtSexeF.setSelected(true);
			this.txtAge.setText("");this.txtAge.setBackground(Color.WHITE);
			this.txtAdresse.setText("");this.txtAdresse.setBackground(Color.WHITE);
			this.txtMdp.setText("");
			this.txtMail.setText("");this.txtMail.setBackground(Color.WHITE);
			this.txtGalop.setText("");this.txtGalop.setBackground(Color.WHITE);
		}
		else if (e.getSource()==this.btAjouter) {
			selection = choiceForm.getSelectedIndex();
			switch(selection) {
				case 0: //VISUALISE
				{
					Eleve unEleve = ModeleEleve.selectWhere(txtMail.getText());	
					if(unEleve == null) {
						this.txtMail.setBackground(Color.RED);	
						JOptionPane.showMessageDialog(this, "Veuillez vérifier l'adresse Email !");
					}
					else {	
						this.txtMail.setBackground(Color.WHITE);
						this.txtId.setText(String.valueOf(unEleve.getId()));
						this.txtPrivilege.setText(String.valueOf(unEleve.getPrivilege()));
						this.txtRecord.setText(unEleve.getRecord());
						this.txtPseudo.setText(unEleve.getPseudo());
						this.txtPrenom.setText(unEleve.getPrenom());
						this.txtNom.setText(unEleve.getNom());
						if (sexe=="FEMME"){this.txtSexeF.setSelected(true);}
						if (sexe=="HOMME"){this.txtSexeH.setSelected(true);}
						this.txtAge.setText(String.valueOf(unEleve.getAge()));
						this.txtAdresse.setText(unEleve.getAdresse());
						this.txtMdp.setText(unEleve.getMdp());
						//mail
						this.txtGalop.setText(String.valueOf(unEleve.getGalop()));
						//image
						JOptionPane.showMessageDialog(this, "Visualisation reussie");
					}
				}
				break;
				case 1://AJOUTER
					try{
						this.txtMail.getText();
						if((txtNom.getText().equals(""))||(txtSexeF.getText().equals(""))||(txtAge.getText().equals(""))||(txtAdresse.getText().equals(""))||(txtMail.getText().equals(""))||(txtGalop.getText().equals("")))
						{
							JOptionPane.showMessageDialog(this, "Veuillez saisir toutes les valeurs dans les champs vide");
							this.txtPrenom.setBackground(Color.RED);
							this.txtNom.setBackground(Color.RED);
							this.txtAge.setBackground(Color.RED);
							this.txtAdresse.setBackground(Color.RED);
							this.txtMail.setBackground(Color.RED);
							this.txtGalop.setBackground(Color.RED);
						}
						else {
							this.txtMail.setBackground(Color.WHITE);
							Eleve unEleve = new Eleve(txtPrenom.getText(), txtNom.getText(), txtSexeF.getText(), Integer.parseInt(txtAge.getText()), txtAdresse.getText(), txtMail.getText(), Integer.parseInt(txtGalop.getText()));
							ModeleEleve.insert(unEleve);
							JOptionPane.showMessageDialog(this, "Insertion reussie");
							this.txtPrenom.setText("");
							this.txtNom.setText("");
							this.txtSexeF.setSelected(true);
							this.txtAge.setText("");
							this.txtAdresse.setText("");
							this.txtMail.setText("");
							this.txtGalop.setText("");
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp)
					{
						JOptionPane.showMessageDialog(this,"Erreur dans la saisie");
					}
				break;
				case 2://MODIFIER
					try{
							System.out.println("MODIFY");
						if(txtMail.getText().equals("")) {
							this.txtMail.setBackground(Color.RED);
							JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide");
						}
						else {
							this.txtMail.setBackground(Color.WHITE);
							Eleve unEleve = new Eleve(txtPrenom.getText(), txtNom.getText(), txtSexeF.getText(), Integer.parseInt(txtAge.getText()), txtAdresse.getText(), txtMail.getText(), Integer.parseInt(txtGalop.getText()));
							ModeleEleve.update(unEleve, txtMail.getText());
							JOptionPane.showMessageDialog(this, "Modification reussie");
							this.txtPrenom.setText("");
							this.txtNom.setText("");
							this.txtSexeF.setSelected(true);
							this.txtAge.setText("");
							this.txtAdresse.setText("");
							this.txtMail.setText("");this.txtMail.setBackground(Color.WHITE);
							this.txtGalop.setText("");
						}
						this.setVisible(true); // fin d'enregistrement
					}
					catch (NumberFormatException exp) {
					}
				break;
				case 3://SUPPRIMER
					try {
						if(txtMail.getText().equals("")) {
							this.txtMail.setBackground(Color.RED);
							JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide");
						}
						else {
							ModeleEleve.delete(txtMail.getText());
							JOptionPane.showMessageDialog(this, "Suppression reussie");
							this.txtMail.setText("");
						}
						this.setVisible(true);// fin d'enregistrement
					}
					catch (NumberFormatException exp) {
						this.txtMail.setBackground(Color.RED);
						JOptionPane.showMessageDialog(this,"Erreur dans la saisie");
					}
				break;
			}
		}
	}
	class StateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - état : " + ((JRadioButton)e.getSource()).isSelected());
		}
	}
}