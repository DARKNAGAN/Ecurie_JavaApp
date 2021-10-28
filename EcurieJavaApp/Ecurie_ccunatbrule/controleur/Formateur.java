package controleur;

public class Formateur
{
	private int idformateur, privilege, age, galop;
	private String login, prenom, nom, sexe, mail, mdp ;
	public Formateur() 
		{//ALL
			this.idformateur=this.privilege=this.age=this.galop=0;
			this.login=this.prenom=this.nom=this.sexe=this.mail=this.mdp="";
		}
	public Formateur (int idformateur, String login, int privilege, String prenom, String nom, int age, int galop, String sexe, String mail, String mdp)
		{//ALL
			this.idformateur= idformateur;
			this.login = login;
			this.privilege = privilege;
			this.prenom = prenom;
			this.nom = nom;
			this.age = age;
			this.galop = galop;
			this.sexe = sexe;
			this.mail = mail;
			this.mdp = mdp;
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
	public int getId() { return idformateur; }
	public String getLogin() { return login; }
	public int getPrivilege() { return privilege; }
	public String getPrenom() { return prenom; }
	public String getNom() { return nom; }
	public int getAge() { return age; }
	public int getGalop() { return galop;}
	public String getSexe() {return sexe;}
	public String getMail() { return mail; }
	public String getMdp() { return mdp; }
	public void setId(int idformateur) { this.idformateur = idformateur; }
	public void setLogin(String login) { this.login = login; }
	public void setPrivilege(int privilege) { this.privilege = privilege; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setNom(String nom) { this.nom = nom; }
	public void setAge(int age) { this.age = age; }
	public void setGalop(int galop) {this.galop = galop; }
	public void setSexe(String sexe) {this.sexe = sexe; }
	public void setMail(String mail) { this.mail = mail; }
	public void setMdp(String mdp) { this.mdp = mdp; }
}