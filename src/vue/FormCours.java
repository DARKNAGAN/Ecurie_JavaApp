package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;

import controleur.Cours;
import modele.ModeleCours;
import modele.ModeleCheval;
import modele.ModeleEleve;
import modele.ModeleFormateur;

public class FormCours extends JPanel implements ActionListener  {

	private static final long serialVersionUID = -7935938065497628244L;
	String prenom, nom, sexe, imagearticle;
	int id, privilege, age, selection;
	String[] formState = { " VISUALISER "/*, " AJOUTER ", " MODIFIER ", " SUPPRIMER " */};
	String[] titresCour = new String[] {" Date "," Horaires "," Formateur "," Elève "," Cheval "};
	String[] dataCategorie = new String[] {"00:00:00","00:30:00","01:00:00","01:30:00","02:00:00","02:30:00","03:00:00","03:30:00","04:00:00","04:30:00","05:00:00","05:30:00","06:00:00","06:30:00","07:00:00","07:30:00","08:00:00","08:30:00","09:00:00","09:30:00","10:00:00","10:30:00","11:00:00","11:30:00","12:00:00","12:30:00","13:00:00","13:30:00","14:00:00","14:30:00","15:00:00","15:30:00","16:00:00","16:30:00","17:00:00","17:30:00","18:00:00","18:30:00","19:00:00","19:30:00","20:00:00","20:30:00","21:00:00","21:30:00","22:00:00","22:30:00","23:00:00","23:30"};
	Object[][] dataCour = ModeleCours.extraireCours();
	Object[] dataChevaux =  ModeleCheval.extraireChevaux();
	Object[] dataEleves =  ModeleEleve.extraireEleves();
	Object[] dataFormateurs =  ModeleFormateur.extraireFormateurs();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_14 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_15, panel_14);
	private final JTable tableCours = new JTable(dataCour, titresCour);
	TableRowSorter<TableModel> sort = new TableRowSorter<>(tableCours.getModel());
	private final JScrollPane scrollTab = new JScrollPane(tableCours);
	private final JLabel lbTitre = new JLabel(" Panneau de gestion des cours ");
	private final JLabel lbId = new JLabel(" ID : ");
	private final JLabel lbDate = new JLabel(" Date : ");
	private final JLabel lbHoraire = new JLabel(" Horaires : ");
	private final JLabel lbNote = new JLabel(" Note : ");
	private final JLabel lbCheval = new JLabel(" Cheval : ");
	private final JLabel lbElève = new JLabel(" Elève : ");
	private final JLabel lbFormateur = new JLabel(" Formateur : ");
	private final JLabel lbvide1 = new JLabel("");
	private final JLabel lbFiltre = new JLabel(" Filtre : ");
	private final JLabel textId = new JLabel();
	private final JDateChooser ChooserDate = new JDateChooser();
	private final JTextField textFiltre = new JTextField();
	private final JTextPane textNote = new JTextPane();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboFormateur = new JComboBox(dataFormateurs);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboEleve = new JComboBox(dataEleves);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboCheval = new JComboBox(dataChevaux);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboBox = new JComboBox(dataCategorie);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox comboBox1 = new JComboBox(dataCategorie);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private final JComboBox choiceForm = new JComboBox(formState);
	private final JButton btAnnuler = new JButton(" Annuler ");
	private final JButton btAjouter = new JButton(" Valider ");
	
	
	public FormCours()
	{
		 this.setBackground(new Color(222,220,203));
		 setLayout(new BorderLayout(0, 0));
		 this.add(splitPane);
		 
		 panel_15.setPreferredSize(new Dimension(500, 10));
		 panel_15.setLayout(new BorderLayout(0, 30));
		 panel_15.add(panel, BorderLayout.CENTER);
		 panel.setLayout(new GridLayout(0, 1, 0, 0));
		 panel.add(panel_1);
		 panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		 lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		 panel_1.add(lbId);
		 textId.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_1.add(textId);
		 panel.add(panel_2);
		 panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		 lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_2.add(lbDate);
		 ChooserDate.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		 ChooserDate.setDateFormatString("yyy-MM-dd");
		 panel_2.add(ChooserDate);
		 panel.add(panel_12);
		 panel_12.setLayout(new GridLayout(2, 1, 0, 0));
		 lbHoraire.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_12.add(lbHoraire);
		 panel_12.add(lbvide1);
		 panel_12.add(comboBox);
		 panel_12.add(comboBox1);
		 panel.add(panel_10);
		 panel_10.setLayout(new GridLayout(2, 1, 0, 0));
		 lbFormateur.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_10.add(lbFormateur);
		 panel_10.add(comboFormateur);
		 panel.add(panel_9);
		 panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		 lbElève.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_9.add(lbElève);
		 panel_9.add(comboEleve);
		 panel.add(panel_8);
		 panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		 lbCheval.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_8.add(lbCheval);
		 panel_8.add(comboCheval);
		 panel.add(panel_7);
		 panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		 lbNote.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_7.add(lbNote);
		 panel_7.add(textNote);
		 panel.add(panel_11);
		 panel_11.setLayout(new GridLayout(2, 1, 0, 0));
		 textFiltre.setHorizontalAlignment(SwingConstants.CENTER);
		 textFiltre.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = textFiltre.getText();
				if (str.trim().length() == 0) {sort.setRowFilter(null);} 
				else {//(?i) recherche insensible à la casse 
				sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				String str = textFiltre.getText();
				if (str.trim().length() == 0) {sort.setRowFilter(null);} 
				else {sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {}
			});
		 
		 
		 textFiltre.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = textFiltre.getText();
				if (str.trim().length() == 0) {sort.setRowFilter(null);} 
				else {//(?i) recherche insensible à la casse 
				sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				String str = textFiltre.getText();
				if (str.trim().length() == 0) {sort.setRowFilter(null);} 
				else {sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {}
			});
		 lbFiltre.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_11.add(lbFiltre);
		 panel_11.add(textFiltre);
		 panel_13.setPreferredSize(new Dimension(20, 50));
		 panel_15.add(panel_13, BorderLayout.SOUTH);
		 panel_13.setLayout(new GridLayout(1, 3, 40, 0));
		 choiceForm.setSelectedIndex(0); 
		 panel_13.add(choiceForm);
		 panel_13.add(btAnnuler);
		 panel_13.add(btAjouter);
		 this.choiceForm.addActionListener(this);
		 this.btAnnuler.addActionListener(this);
		 this.btAjouter.addActionListener(this);
		 panel_14.setLayout(new BorderLayout(0, 0));
		 lbTitre.setPreferredSize(new Dimension(150, 100));
		 lbTitre.setHorizontalAlignment(SwingConstants.CENTER);
		 lbTitre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 40));
		 panel_14.add(lbTitre, BorderLayout.NORTH);
		 panel_14.add(scrollTab, BorderLayout.CENTER);
		 tableCours.setShowVerticalLines(false);
		 tableCours.setRowSorter(sort);
		 tableCours.setEnabled(true);
		 tableCours.setRowHeight(30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.textId.setText("");this.textNote.setText("");this.textFiltre.setText("");this.ChooserDate.setDate(null);
			this.comboBox.setSelectedIndex(0);this.comboBox1.setSelectedIndex(0);this.comboCheval.setSelectedIndex(0);
			this.comboEleve.setSelectedIndex(0);this.comboFormateur.setSelectedIndex(0);
			}
		else if (e.getSource()==this.btAjouter) {
			Cours unCour = ModeleCours.selectWhere(sdf.format(ChooserDate.getDate())/*, comboBox.setSelectedIndex(), comboBox1.setSelectedIndex()*/);
			switch(choiceForm.getSelectedIndex()) {
				case 0: //VISUALISE
				{
					if(unCour == null) 
						{ JOptionPane.showMessageDialog(this, "Aucun cours ne correspond.\n Vérifier la date du cours !"," Erreur de saisie ",JOptionPane.ERROR_MESSAGE); }
					else {
						this.textId.setText(String.valueOf(unCour.getIdCours()));
						try {this.ChooserDate.setDate(sdf.parse(unCour.getDateCours()));} catch (ParseException e1) {e1.printStackTrace();}
						this.comboBox.setSelectedItem(unCour.getHeureDebut());
						this.comboBox1.setSelectedItem(unCour.getHeureFin());
						this.comboCheval.setSelectedIndex(unCour.getIdCheval());
						this.comboEleve.setSelectedIndex(unCour.getIdEleve());
						this.comboFormateur.setSelectedIndex(unCour.getIdFormateur());
						this.textNote.setText(unCour.getNote());
						JOptionPane.showMessageDialog(this, " Visualisation réalisé avec succès ! "," Action réussie ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
			}
		}
	}
}