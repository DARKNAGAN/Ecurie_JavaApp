package vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import controleur.Formateur;
import modele.ModeleFormateur;

public class FormFormateurs extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -7023992128997426855L;
	String[] formState = { "VISUALISER", "AJOUTER", "SUPPRIMER" };
	String login, prenom, nom, sexe, mail, mdp= "";
	int id, privilege, age, galop, selection;
	private JComboBox<String> choiceForm = new JComboBox<>(formState);
	private JLabel txtId = new JLabel();
	private JLabel txtLogin = new JLabel();
	private JLabel txtPrivilege = new JLabel();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtNom = new JTextField("");
	private JTextField txtAge = new JTextField("");
	private JTextField txtGalop = new JTextField("");
	private ButtonGroup groupSexe = new ButtonGroup();
	private JRadioButton txtSexeF = new JRadioButton("Femme");
	private JRadioButton txtSexeH = new JRadioButton("Homme");
	private JTextField txtMail = new JTextField("");
	private JPasswordField txtMdp = new JPasswordField("");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Editer");
	
	public FormFormateurs()
	{
		//Configuration des composants
		JLabel lbVide1 = new JLabel("");JLabel lbVide2 = new JLabel("");
		this.setBounds(50, 80, 650, 250);this.setLayout(new GridLayout(0, 2));this.setBackground(new Color(222,220,203));
		JLabel lbId = new JLabel(" ID :");lbId.setFont(new Font(lbId.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbPrivilege = new JLabel(" Privilege :");lbPrivilege.setFont(new Font(lbPrivilege.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbLogin = new JLabel(" Login :");lbLogin.setFont(new Font(lbLogin.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbPrenom = new JLabel(" Prenom :");lbPrenom.setFont(new Font(lbPrenom.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbNom = new JLabel(" Nom :");lbNom.setFont(new Font(lbNom.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbAge = new JLabel(" Âge :");lbAge.setFont(new Font(lbAge.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbGalop = new JLabel(" Galop :");lbGalop.setFont(new Font(lbGalop.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbSexe = new JLabel(" Sexe :");lbSexe.setFont(new Font(lbSexe.getText(), Font.CENTER_BASELINE, 18));
		txtSexeF.setMnemonic(KeyEvent.VK_B); txtSexeH.setMnemonic(KeyEvent.VK_B);
		txtSexeF.setActionCommand("FEMME");txtSexeF.setSelected(true); txtSexeH.setActionCommand("HOMME");
		groupSexe.add(txtSexeF); groupSexe.add(txtSexeH);
		JLabel lbMail = new JLabel(" E-mail :");lbMail.setFont(new Font(lbMail.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbMdp = new JLabel(" Mot de passe :");lbMdp.setFont(new Font(lbMdp.getText(), Font.CENTER_BASELINE, 18));
		choiceForm.setSelectedIndex(0);choiceForm.addActionListener(this);
		this.btAnnuler.setIcon(new ImageIcon(new ImageIcon("src/images/choix1.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAnnuler.addActionListener(this);
		this.btAjouter.setIcon(new ImageIcon(new ImageIcon("src/images/choix2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAjouter.addActionListener(this);
		// Affichage des composants
		this.add(lbId);this.add(this.txtId);
		this.add(lbPrivilege);this.add(this.txtPrivilege);
		this.add(lbLogin);this.add(this.txtLogin);
		this.add(lbMail);this.add(this.txtMail);
		this.add(lbMdp);this.add(this.txtMdp);
		this.add(lbPrenom);this.add(this.txtPrenom);
		this.add(lbNom);this.add(this.txtNom);
		this.add(lbAge);this.add(this.txtAge);
		this.add(lbGalop);this.add(this.txtGalop);
		this.add(lbSexe);this.add(this.txtSexeF);
		this.add(lbVide1);this.add(this.txtSexeH);
		this.add(this.choiceForm);this.add(lbVide2);
		this.add(this.btAnnuler);this.add(this.btAjouter);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		if(e.getSource()==this.btAnnuler) {
			this.txtId.setText("");
			this.txtLogin.setText("");
			this.txtPrivilege.setText("");
			this.txtPrenom.setText("");this.txtPrenom.setBackground(Color.WHITE);
			this.txtNom.setText("");this.txtNom.setBackground(Color.WHITE);
			this.txtAge.setText("");this.txtAge.setBackground(Color.WHITE);
			this.txtGalop.setText("");this.txtGalop.setBackground(Color.WHITE);
			this.txtSexeF.setSelected(true);
			this.txtMail.setText("");this.txtMail.setBackground(Color.WHITE);
			this.txtMdp.setText("");this.txtMdp.setBackground(Color.WHITE);
		}
		else if (e.getSource()==this.btAjouter) {
			int selection = choiceForm.getSelectedIndex();
			switch(selection) {
			case 0: //VISUALISE
			{
				Formateur unFormateur = ModeleFormateur.selectWhere(txtMail.getText(),String.valueOf(txtMdp.getPassword()));
				if(unFormateur == null) {
					this.txtMail.setBackground(Color.RED);
					this.txtMdp.setBackground(Color.RED);
					JOptionPane.showMessageDialog(this, "Veuillez vérifier l'adresse Email et le Mot de passe!");
				}
				else {
					this.txtMail.setBackground(Color.WHITE);
					this.txtMdp.setBackground(Color.WHITE);
					this.txtId.setText(String.valueOf(unFormateur.getId()));
					this.txtPrivilege.setText(String.valueOf(unFormateur.getPrivilege()));
					this.txtLogin.setText(unFormateur.getLogin());
					this.txtPrenom.setText(unFormateur.getPrenom());
					this.txtNom.setText(unFormateur.getNom());
					this.txtAge.setText(String.valueOf(unFormateur.getAge()));
					this.txtGalop.setText(String.valueOf(unFormateur.getGalop()));
					this.txtSexeF.setSelected(true);//A VERIFIER
					this.txtMdp.setText(unFormateur.getMdp());
					//mail
					JOptionPane.showMessageDialog(this, "Visualisation reussie");
				}
			}
			break;
			case 1://AJOUTER
				try{
					this.txtMail.getText();
					if((txtNom.getText().equals(""))||(txtSexeF.getText().equals(""))||(txtAge.getText().equals(""))||(txtMail.getText().equals(""))||(txtGalop.getText().equals(""))||(String.valueOf(txtMdp.getPassword()).equals("")))
					{
						JOptionPane.showMessageDialog(this, "Veuillez saisir toutes les valeurs dans les champs vide");
						this.txtPrenom.setBackground(Color.RED);
						this.txtNom.setBackground(Color.RED);
						this.txtAge.setBackground(Color.RED);
						this.txtMail.setBackground(Color.RED);
						this.txtGalop.setBackground(Color.RED);
						this.txtMdp.setBackground(Color.RED);
					}
					else {
						this.txtMail.setBackground(Color.WHITE);
						this.txtMdp.setBackground(Color.WHITE);
						Formateur unFormateur = new Formateur(txtPrenom.getText(), txtNom.getText(), Integer.parseInt(txtAge.getText()), Integer.parseInt(txtGalop.getText()),txtSexeF.getText(), txtMail.getText(), String.valueOf(txtMdp.getPassword()));
						ModeleFormateur.insert(unFormateur);
						JOptionPane.showMessageDialog(this, "Insertion reussie");
						this.txtPrenom.setText("");
						this.txtNom.setText("");
						this.txtSexeF.setSelected(true);
						this.txtAge.setText("");
						this.txtMail.setText("");
						this.txtGalop.setText("");
						this.txtMdp.setText("");
					}
					this.setVisible(true);// fin d'enregistrement
				}
				catch (NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(this,"Erreur dans la saisie");
				}
			break;
				case 2://DELETE
					try {
						if(txtMail.getText().equals("") && String.valueOf(txtMdp.getPassword()).equals("")) {
							this.txtMail.setBackground(Color.RED);
							this.txtMdp.setBackground(Color.RED);
							JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide");
						}
						else {
							this.txtMail.setBackground(Color.WHITE);
							this.txtMdp.setBackground(Color.WHITE);
							ModeleFormateur.delete(txtMail.getText());
							JOptionPane.showMessageDialog(this, "Suppression reussie");
							this.txtMail.setText("");
							this.txtMdp.setText("");
						}
						this.setVisible(true);// fin d'enregistrement
					}
					catch (NumberFormatException exp) {
						this.txtMail.setBackground(Color.RED);
						this.txtMdp.setBackground(Color.RED);
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