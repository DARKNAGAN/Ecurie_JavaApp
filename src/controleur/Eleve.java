package controleur;

import java.util.Date;

public class Eleve
{
	private int id, privilege, age, galop;
	public String pseudo, prenom, nom, sexe, adresse, mdp, mail, imageeleve;
	public String eleve;
	private Date record;
	public Eleve() {//ALL
			this.id=this.privilege=this.age=this.galop=0;
			this.pseudo=this.prenom=this.nom=this.sexe=this.adresse=this.mail=this.eleve="";
			this.record=null;
		}
	public Eleve (int id, int privilege, Date record, String pseudo, String prenom, String nom, String sexe, int age, String adresse, String mdp, String mail, int galop, String imageeleve, String eleve)
		{//ALL
			this.id= id;
			this.privilege = privilege;
			this.record = record;
			this.pseudo = pseudo;
			this.prenom = prenom;
			this.nom = nom;
			this.sexe = sexe;
			this.age = age;
			this.adresse = adresse;
			this.mdp = mdp;
			this.mail = mail;
			this.galop = galop;
			this.imageeleve = imageeleve;
			this.eleve = eleve;
		}
	public Eleve (String prenom, String nom, String sexe, int age, String adresse, String mail, int galop)
	{//ADD & Modify
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
		this.adresse = adresse;
		this.mail = mail;
		this.galop = galop;
	}
	public Eleve (String mail) {//DELETE
		this.mail = mail;
	}
	public Eleve (int id, String eleve) {
		this.id= id;
		this.eleve= eleve;
	}
	public int getId() { return id; }
	public int getPrivilege() { return privilege; }
	public Date getRecord() { return record; }
	public String getPseudo() { return pseudo; }
	public String getPrenom() { return prenom; }
	public String getNom() { return nom; }
	public String getSexe() { return sexe; }
	public int getAge() { return age; }
	public String getAdresse() { return adresse; }
	public String getMdp() { return mdp; }
	public String getMail() { return mail; }
	public int getGalop() { return galop; }
	public String getImageEleve() { return imageeleve; }
	public String getEleve() {return eleve;}
	public void setid(int id) { this.id = id; }
	public void setPrivilege(int privilege) { this.privilege = privilege; }
	public void setrecord(Date record) { this.record = record; }
	public void setPseudo(String pseudo) { this.pseudo = pseudo; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setNom(String nom) { this.nom = nom; }
	public void setSexe(String sexe) { this.sexe = sexe; }	
	public void setAge(int age) { this.age = age; }	
	public void setAdresse(String adresse) { this.adresse = adresse; }
	public void setMdp(String mdp) { this.mdp = mdp; }
	public void setMail(String mail) { this.mail = mail; }
	public void setGalop(int galop) { this.galop = galop; }
	public void setImageEleve(String imageeleve) { this.imageeleve = imageeleve; }
	public void setEleve(String eleve) {this.eleve = eleve;}}