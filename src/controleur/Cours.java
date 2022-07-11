package controleur;

public class Cours
{
	private int idcours, ideleve, idcheval, idformateur; 
	private String datecours, heure, heuredebut, heurefin, note, prenomformateur, nomformateur, nomeleve, prenomeleve, nomcheval, formateur, eleve; 
	public Cours()
	{
		this.idcours=this.ideleve=this.idcheval=this.idformateur=0;
		this.datecours=this.heure=this.heuredebut=this.heurefin=this.note=this.formateur=this.prenomformateur=this.nomformateur=this.eleve=this.nomeleve=this.prenomeleve=this.nomcheval="";
	}
	public Cours (int idcours, int ideleve, int idcheval, int idformateur, String datecours, String note, String heuredebut, String heurefin, String heure,String formateur, String eleve, String nomcheval)
	{
		this.idcours = idcours;
		this.ideleve = ideleve;
		this.idcheval = idcheval;
		this.idformateur = idformateur;
		this.datecours = datecours;
		this.note = note;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.heure = heure;
		this.datecours = datecours;
		this.formateur = formateur;
		this.eleve = eleve;
		this.nomcheval = nomcheval;
		
	}
	public Cours (int idcours, String datecours, String heuredebut, String heurefin, String note)
	{
		this.idcours= idcours;
		this.datecours = datecours;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.note = note;
	}
	
	public int getIdCours() {return idcours;}
	public int getIdFormateur() {return idformateur;}
	public int getIdEleve() {return ideleve;}
	public int getIdCheval() {return idcheval;}
	public String getDateCours() {return datecours;}
	public String getHeure() {return heure;}
	public String getHeureDebut() {return heuredebut;}
	public String getHeureFin() {return heurefin;}
	public String getNote() {return note;}
	public String getFormateur() {return formateur;}
	public String getprenomFormateur() {return prenomformateur;}
	public String getnomFormateur() {return nomformateur;}
	public String getEleve() {return eleve;}
	public String getnomEleve() {return nomeleve;}
	public String getprenomEleve() {return prenomeleve;}
	public String getnomCheval() {return nomcheval;}
	
	public void setIdCours(int idcours) {this.idcours = idcours;}
	public void setIdFormateur(int idformateur) {this.idformateur = idformateur;}
	public void setIdEleve(int ideleve) {this.ideleve = ideleve;}
	public void setIdCheval(int idcheval) {this.idcheval = idcheval;}
	public void setDateCours(String datecours) {this.datecours = datecours;}
	public void setHeure(String heure) {this.heure = heure;}
	public void setHeureDebut(String heuredebut) {this.heuredebut = heuredebut;}
	public void setHeureFin(String heurefin) {this.heurefin = heurefin;}
	public void setNote(String note) {this.note = note;}
	public void setprenomFormateur(String prenomformateur) {this.prenomformateur = prenomformateur;}
	public void setFormateur(String formateur) {this.formateur = formateur;}
	public void setnomFormateur(String nomformateur) {this.nomformateur = nomformateur;}
	public void setEleve(String eleve) {this.eleve = eleve;}
	public void setnomEleve(String nomeleve) {this.nomeleve = nomeleve;}
	public void setprenomEleve(String prenomeleve) {this.prenomeleve = prenomeleve;}
	public void setnomCheval(String nomcheval) {this.nomcheval = nomcheval;}
	
}