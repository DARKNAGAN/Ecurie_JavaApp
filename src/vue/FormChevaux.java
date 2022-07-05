package vue;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import controleur.Cheval;
import modele.ModeleCheval;

public class FormChevaux extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = -2223951904837426516L;
	String id, nom, sexe, robe, type, race, proprietaire, age, imagecheval = "";
	int selection;
	String[] formState = { " VISUALISER ", " AJOUTER ", " SUPPRIMER " };
	String[] titresChevaux = new String[] {" Nom ", " Sexe ", " Age ", " Propriétaire ", " Race ", " Robe ", " Type "};
	Object[][] dataChevaux =  extraireChevaux();
	private final JPanel panel = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel_10);
	private final JTable tableChevaux = new JTable(dataChevaux, titresChevaux);
	private final JScrollPane scrollTab = new JScrollPane(tableChevaux);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des chevaux ");
	private final JLabel titreChevaux= new JLabel(" Liste des chevaux ");
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

	public FormChevaux()	{		
		
	 this.setBackground(new Color(222,220,203));
	 setLayout(new BorderLayout(0, 0));	 
	 this.add(splitPane);
	 panel.setPreferredSize(new Dimension(500, 10));
	 panel.setLayout(new BorderLayout(0, 30));
	 panel.add(panel_11);
	 panel_11.setLayout(new GridLayout(0, 1, 0, 0));	 
	 panel_11.add(panel_1);
	 panel_1.setLayout(new GridLayout(1, 4, 0, 0));
	 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
	 lbId.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_1.add(lbId);	 
	 textId.setHorizontalAlignment(SwingConstants.CENTER);
	 textId.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_1.add(textId);
	 lbPhoto.setFont(new Font("Book Antiqua", Font.BOLD, 20));
	 imgPhoto.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 imgPhoto.setHorizontalAlignment(SwingConstants.CENTER);
	 panel_1.add(lbPhoto);
	 panel_1.add(imgPhoto);
	 panel_11.add(panel_2);
	 panel_2.setLayout(new GridLayout(2, 1, 0, 0));
	 lbNom.setHorizontalAlignment(SwingConstants.CENTER);
	 lbNom.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_2.add(lbNom);	 
	 textNom.setHorizontalAlignment(SwingConstants.CENTER);
	 textNom.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_2.add(textNom);	
	 panel_11.add(panel_3);
	 panel_3.setLayout(new GridLayout(1, 1, 0, 0));
	 lbSexe.setHorizontalAlignment(SwingConstants.CENTER);
	 lbSexe.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_3.add(lbSexe);
	 groupSexe.add(textSexeF);
	 groupSexe.add(textSexeH);	
	 textSexeF.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 textSexeF.setActionCommand("FEMELLE");	 
	 panel_3.add(textSexeF);
	 textSexeH.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 textSexeH.setActionCommand("MALE");	 
	 panel_3.add(textSexeH);
	 panel_11.add(panel_8);
	 panel_8.setLayout(new GridLayout(1, 1, 0, 0));
	 lbAge.setHorizontalAlignment(SwingConstants.RIGHT);
	 lbAge.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_8.add(lbAge);	 
	 textAge.setHorizontalAlignment(SwingConstants.CENTER);
	 textAge.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_8.add(textAge);	 
	 panel_11.add(panel_4);
	 panel_4.setLayout(new GridLayout(2, 1, 0, 0));
	 lbRobe.setHorizontalAlignment(SwingConstants.CENTER);
	 lbRobe.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_4.add(lbRobe);
	 textRobe.setHorizontalAlignment(SwingConstants.CENTER);
	 textRobe.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_4.add(textRobe);	 
	 panel_11.add(panel_5);
	 panel_5.setLayout(new GridLayout(2, 1, 0, 0));
	 lbType.setHorizontalAlignment(SwingConstants.CENTER);
	 lbType.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_5.add(lbType);	 
	 textType.setHorizontalAlignment(SwingConstants.CENTER);
	 textType.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_5.add(textType);	 
	 panel_11.add(panel_6);
	 panel_6.setLayout(new GridLayout(2, 1, 0, 0));
	 lbRace.setHorizontalAlignment(SwingConstants.CENTER);
	 lbRace.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_6.add(lbRace);	 
	 textRace.setHorizontalAlignment(SwingConstants.CENTER);
	 textRace.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_6.add(textRace);	 
	 panel_11.add(panel_7);
	 panel_7.setLayout(new GridLayout(2, 1, 0, 0));
	 lbProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
	 lbProprietaire.setFont(new Font("Book Antiqua", Font.BOLD, 20));	 
	 panel_7.add(lbProprietaire);	 
	 textProprietaire.setHorizontalAlignment(SwingConstants.CENTER);
	 textProprietaire.setFont(new Font("Bodoni MT", Font.BOLD, 20));
	 panel_7.add(textProprietaire);	 
	 panel_9.setPreferredSize(new Dimension(10, 30));
	 panel.add(panel_9, BorderLayout.SOUTH);
	 panel_9.setLayout(new GridLayout(1, 3, 40, 0));
	 choiceForm.setFont(new Font("Book Antiqua", Font.BOLD, 15));
	 choiceForm.setSelectedIndex(0);
	 panel_9.add(choiceForm);
	 btAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 15));
	 panel_9.add(btAnnuler);
	 btAjouter.setFont(new Font("Book Antiqua", Font.BOLD, 15));
	 panel_9.add(btAjouter);
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
	 panel_10.setLayout(new BorderLayout(0, 0));
	 lbTitre.setPreferredSize(new Dimension(160, 50));
	 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
	 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
	 panel_10.add(lbTitre, BorderLayout.NORTH);
	 titreChevaux.setHorizontalAlignment(SwingConstants.CENTER);
	 titreChevaux.setFont(new Font(titreChevaux.getText(), Font.CENTER_BASELINE, 20));
	 panel_10.add(scrollTab, BorderLayout.CENTER);
	 tableChevaux.setShowVerticalLines(false);
	 tableChevaux.setEnabled(false);
	 tableChevaux.setRowHeight(30);
	 tableChevaux.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
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
					this.imgPhoto.setIcon(new ImageIcon("//NASCCB/web/Ecurie" + unCheval.getImage()));	
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
	//extraire les Chevaux 	
	public Object [][] extraireChevaux () {
		ArrayList <Cheval> lesChevaux = ModeleCheval.selectAll();
		Object [][] donnees = new Object [lesChevaux.size()][7];
		int i =0;
		for (Cheval unCheval : lesChevaux) {
			donnees[i][0] = unCheval.getNom();
			donnees[i][1] = unCheval.getSexe();
			donnees[i][2] = unCheval.getAge();
			donnees[i][3] = unCheval.getProprietaire();
			donnees[i][4] = unCheval.getRace();
			donnees[i][5] = unCheval.getRobe();
			donnees[i][6] = unCheval.getType();
			i++;
		}
		return donnees;
	}
}