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
import controleur.Cheval;
import modele.ModeleCheval;

public class FormChevaux extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -2223951904837426516L;
	String[] formState = { "VISUALISER", "AJOUTER", "SUPPRIMER" };
	String id, nom, sexe, robe, type, race, proprietaire, age, imagecheval = "";
	int selection;
	private JComboBox choiceForm = new JComboBox(formState);
	private JLabel txtId = new JLabel();
	private JTextField txtNom = new JTextField("");
	private ButtonGroup groupSexe = new ButtonGroup();
	private JRadioButton txtSexeF = new JRadioButton("Femelle");
	private JRadioButton txtSexeH = new JRadioButton("Mâle");
	private JTextField txtRobe = new JTextField();
	private JTextField txtType = new JTextField("");
	private JTextField txtRace = new JTextField("");
	private JTextField txtProprietaire = new JTextField("");
	private JTextField txtAge = new JTextField("");
	//IMG Cheval
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Editer");
	public FormChevaux()
	{
		//Configuration des composants
		JLabel lbVide1 = new JLabel("");JLabel lbVide2 = new JLabel("");JLabel lbVide3 = new JLabel("");JLabel lbVide4 = new JLabel("");
		this.setBounds(50, 80, 650, 250);this.setLayout(new GridLayout(0, 2));this.setBackground(new Color(222,220,203));
		JLabel lbId = new JLabel(" ID :");lbId.setFont(new Font(lbId.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbNom = new JLabel(" Nom :");lbNom.setFont(new Font(lbNom.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbSexe = new JLabel(" Sexe :");lbSexe.setFont(new Font(lbSexe.getText(), Font.CENTER_BASELINE, 18));
		txtSexeF.setMnemonic(KeyEvent.VK_B);txtSexeH.setMnemonic(KeyEvent.VK_B);
		txtSexeF.setActionCommand("FEMELLE");txtSexeH.setActionCommand("MALE");txtSexeF.setSelected(true);
		JLabel lbRobe = new JLabel(" Robe :");lbRobe.setFont(new Font(lbRobe.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbType = new JLabel(" Type :");lbType.setFont(new Font(lbType.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbRace = new JLabel(" Race :");lbRace.setFont(new Font(lbRace.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbProprietaire = new JLabel(" Proprietaire :");lbProprietaire.setFont(new Font(lbProprietaire.getText(), Font.CENTER_BASELINE, 18));
		JLabel lbAge = new JLabel(" Âge :");lbAge.setFont(new Font(lbAge.getText(), Font.CENTER_BASELINE, 18));
		choiceForm.setSelectedIndex(0);choiceForm.addActionListener(this);
		//IMG Cheval
		this.btAnnuler.setIcon(new ImageIcon(new ImageIcon("src/images/choix1.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAnnuler.addActionListener(this);
		this.btAjouter.setIcon(new ImageIcon(new ImageIcon("src/images/choix2.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));this.btAjouter.addActionListener(this);
		// Affichage des composants
		this.add(lbId); this.add(this.txtId);
		this.add(lbNom); this.add(this.txtNom);
		this.add(lbSexe); this.add(this.txtSexeF);
		this.add(lbVide1); this.add(this.txtSexeH);
		groupSexe.add(txtSexeF); groupSexe.add(txtSexeH);
		this.add(lbRobe); this.add(this.txtRobe);
		this.add(lbType); this.add(this.txtType);
		this.add(lbRace); this.add(this.txtRace);
		this.add(lbProprietaire); this.add(this.txtProprietaire);
		this.add(lbAge); this.add(this.txtAge);
		this.add(this.choiceForm); this.add(lbVide2);
		this.add(this.btAnnuler); this.add(this.btAjouter);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		if(e.getSource()==this.btAnnuler){
			this.txtId.setText("");
			this.txtNom.setText("");this.txtNom.setBackground(Color.WHITE);
			this.txtSexeF.setSelected(true);
			this.txtRobe.setText("");this.txtRobe.setBackground(Color.WHITE);
			this.txtType.setText("");this.txtType.setBackground(Color.WHITE);
			this.txtRace.setText("");this.txtRace.setBackground(Color.WHITE);
			this.txtProprietaire.setText("");this.txtProprietaire.setBackground(Color.WHITE);
			this.txtAge.setText("");this.txtAge.setBackground(Color.WHITE);	
			//IMG Cheval
		}
		else if (e.getSource()==this.btAjouter) {
			int selection = choiceForm.getSelectedIndex();
			switch(selection) {
			case 0: //VISUALISE
			{
				Cheval unCheval = ModeleCheval.selectWhere(txtNom.getText());
				if(unCheval == null) {
					this.txtNom.setBackground(Color.RED);
					JOptionPane.showMessageDialog(this, "Veuillez vérifier le nom du cheval !");
				}
				else {
					this.txtNom.setBackground(Color.WHITE);	
					this.txtId.setText(String.valueOf(unCheval.getId()));
					this.txtNom.setText(unCheval.getNom());
					this.txtSexeF.setSelected(true);//A VERIFIER
					this.txtRobe.setText(String.valueOf(unCheval.getRobe()));
					this.txtType.setText(unCheval.getType());
					this.txtRace.setText(unCheval.getRace());
					this.txtProprietaire.setText(unCheval.getProprietaire());
					this.txtAge.setText(String.valueOf(unCheval.getAge()));
					//image
					JOptionPane.showMessageDialog(this, "Visualisation reussie");
				}
			}
			break;
			case 1://AJOUTER
				try{
					this.txtNom.getText();
					if((txtNom.getText().equals(""))||(txtRobe.getText().equals(""))||(txtType.getText().equals(""))||(txtRace.getText().equals(""))||(txtProprietaire.getText().equals(""))||(txtAge.getText().equals(""))) 
					{
						JOptionPane.showMessageDialog(this, "Veuillez saisir toutes les valeurs dans les champs vide");
						this.txtNom.setBackground(Color.RED);
						this.txtRobe.setBackground(Color.RED);
						this.txtType.setBackground(Color.RED);
						this.txtRace.setBackground(Color.RED);
						this.txtProprietaire.setBackground(Color.RED);
						this.txtAge.setBackground(Color.RED);
					}
					else {
						this.txtNom.setBackground(Color.WHITE);	
						Cheval unCheval = new Cheval(txtNom.getText(), txtSexeF.getText(), txtRobe.getText(), txtType.getText(), txtRace.getText(), txtProprietaire.getText(), Integer.parseInt(txtAge.getText()));
						ModeleCheval.insert(unCheval);
						JOptionPane.showMessageDialog(this, "Insertion reussie");
						this.txtNom.setText("");
						this.txtSexeF.setSelected(true);
						this.txtRobe.setText("");
						this.txtType.setText("");
						this.txtRace.setText("");
						this.txtProprietaire.setText("");
						this.txtAge.setText("");
					}
					this.setVisible(true); // fin d'enregistrement
				}
				catch (NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(this,"Erreur dans la saisie");
				}
			break;
				case 2://DELETE
					try {
						if(txtNom.getText().equals("")) {
							this.txtNom.setBackground(Color.RED);
							JOptionPane.showMessageDialog(this, "Veuillez saisir des valeurs dans les champs vide");
						}
						else {
							this.txtNom.setBackground(Color.WHITE);
							ModeleCheval.delete(txtNom.getText());
							JOptionPane.showMessageDialog(this, "Suppression reussie");
							this.txtNom.setText("");
						}
						this.setVisible(true);// fin d'enregistrement
					}
					catch (NumberFormatException exp) {
						this.txtNom.setBackground(Color.RED);
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