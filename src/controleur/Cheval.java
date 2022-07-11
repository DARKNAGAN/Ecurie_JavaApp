package controleur;

public class Cheval {
	private int id, age;
	private String nom, sexe, robe, type, race, proprietaire, image;
	public Cheval() 
	{//ADD
		this.id=this.age=0;
		this.nom=this.sexe=this.proprietaire=this.robe=this.type=this.image="";
	}
	public Cheval (int id, String nom, String sexe, String robe, String type, String race, String proprietaire, int age, String image)
	{//ALL
		this.id= id; 
		this.nom = nom; 
		this.sexe = sexe; 
		this.robe = robe; 
		this.type = type; 
		this.race = race; 
		this.proprietaire = proprietaire; 
		this.age = age; 
		this.image = image; 
	}
	public Cheval (String nom, String sexe, String robe, String type, String race, String proprietaire, int age)
	{//ADD
		this.nom = nom; 
		this.sexe = sexe; 
		this.robe = robe; 
		this.type = type; 
		this.race = race; 
		this.proprietaire = proprietaire; 
		this.age = age;
	}
	public Cheval (String nom)
	{//DELETE
		this.nom = nom; 
	}
	public Cheval (int id, String nom) {
		this.id= id;
		this.nom= nom;
	}
	public int getId() { return id; }
	public String getNom() { return nom; }
	public String getSexe() { return sexe; }
	public String getRobe() { return robe; }
	public String getType() { return type; }
	public String getRace() { return race; }
	public String getProprietaire() { return proprietaire; }
	public int getAge() { return age; }
	public String getImage() { return image; }
	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setSexe(String sexe) { this.sexe = sexe; }
	public void setRobe(String robe) { this.robe = robe; }
	public void setType(String type) { this.type = type; }
	public void setRace(String race) { this.race = race; }
	public void setProprietaire(String proprietaire) { this.proprietaire = proprietaire; }
	public void setAge(int age) { this.age = age; }
	public void setImage(String image) { this.image = image; }
}