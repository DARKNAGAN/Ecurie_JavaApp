package controleur;

public class Cours
{
	private int idcours; 
	private String datecours, heuredebut, heurefin; 
	public Cours()
	{
		this.idcours=0;
		this.datecours = this.heuredebut=this.heurefin="";
	}
	public Cours (int idcours, String datecours, String heuredebut, String heurefin)
	{
		this.idcours= idcours; 
		this.datecours = datecours; 
		this.heuredebut = heuredebut; 
		this.heurefin = heurefin; 
	}
	public Cours ( String datecours, String heuredebut, String heurefin)
	{
		this.idcours= 0; 
		this.datecours = datecours; 
		this.heuredebut = heuredebut; 
		this.heurefin = heurefin; 
	}
	public int getIdCours() {
		return idcours;
	}
	public void setIdCours(int idcours) {
		this.idcours = idcours;
	}
	public String getDateCours() {
		return datecours;
	}
	public void setDateCours(String datecours) {
		this.datecours = datecours;
	}
	public String getHeureDebut() {
		return heuredebut;
	}
	public void setHeureDebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}
	public String getHeureFin() {
		return heurefin;
	}
	public void setHeureFin(String heurefin) {
		this.heurefin = heurefin;
	}
}
