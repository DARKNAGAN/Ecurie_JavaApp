package controleur;

public class Formateur
{
	private int idformateur, privilege, age, galop;
	public String prenom, nom, sexe, mail, mdp, formateur ;
	public Formateur() 
		{//ALL
			this.idformateur=this.privilege=this.age=this.galop=0;
			this.prenom=this.nom=this.sexe=this.mail=this.mdp=this.formateur="";
		}
	public Formateur (int idformateur, int privilege, String prenom, String nom, int age, int galop, String sexe, String mail, String mdp, String formateur)
		{//ALL
			this.idformateur= idformateur;
			this.privilege = privilege;
			this.prenom = prenom;
			this.nom = nom;
			this.age = age;
			this.galop = galop;
			this.sexe = sexe;
			this.mail = mail;
			this.mdp = mdp;
			this.formateur = formateur;
		}
	public Formateur(String prenom,String nom, int age, int galop, String sexe, String mail, String mdp)
		{//ADD
			this.prenom = prenom;
			this.nom = nom;
			this.age = age;
			this.galop = galop;
			this.sexe = sexe;
			this.mail = mail;
			this.mdp = mdp;
		}
	public Formateur(String mail)
	{//DELETE
		this.mail = mail;
	}
	public Formateur (int idformateur, String formateur) {
		this.idformateur= idformateur;
		this.formateur= formateur;
	}
	public int getId() { return idformateur; }
	public int getPrivilege() { return privilege; }
	public String getPrenom() { return prenom; }
	public String getNom() { return nom; }
	public int getAge() { return age; }
	public int getGalop() { return galop;}
	public String getSexe() {return sexe;}
	public String getMail() { return mail; }
	public String getMdp() { return mdp; }
	public String getFormateur() { return formateur; }
	
	public void setId(int idformateur) { this.idformateur = idformateur; }
	public void setPrivilege(int privilege) { this.privilege = privilege; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setNom(String nom) { this.nom = nom; }
	public void setAge(int age) { this.age = age; }
	public void setGalop(int galop) {this.galop = galop; }
	public void setSexe(String sexe) {this.sexe = sexe; }
	public void setMail(String mail) { this.mail = mail; }
	public void setMdp(String mdp) { this.mdp = mdp; }
	public void setFormateur(String formateur) {this.formateur = formateur;}

}