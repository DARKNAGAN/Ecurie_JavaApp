package controleur;

public class Article {
		private int id, prix, qtestock, idcategorie;
		private String reference, categorie, description, libelle, imagearticle;
		public Article() {//ALL
				this.id=this.idcategorie=this.prix=this.qtestock=0;
				this.reference=this.categorie=this.description=this.libelle="";
			}
		public Article (int id, String reference, int idcategorie, String categorie, String description, String libelle, int prix, int qtestock, String imagearticle)
			{//ALL
				this.id= id;
				this.reference= reference;
				this.idcategorie= idcategorie;
				this.categorie= categorie;
				this.description = description;
				this.libelle = libelle;
				this.prix = prix;
				this.qtestock = qtestock;
				this.imagearticle = imagearticle;
			}
		public Article (String reference, int idcategorie, String description, String libelle, int prix, int qtestock)
		{//ADD & Modify
			this.reference = reference;
			this.idcategorie= idcategorie;
			this.description = description;
			this.libelle = libelle;
			this.prix = prix;
			this.qtestock = qtestock;
		}
		public Article (String reference) {//DELETE
			this.reference = reference;
		}
		public Article (int idcategorie,String libelle)
		{// Categories
			this.idcategorie= idcategorie;
			this.libelle = libelle;
		}
		public int getId() { return id; }
		public String getReference() { return reference; }
		public int getidCategorie() { return idcategorie; }
		public String getCategorie() { return categorie; }
		public int getPrix() { return prix; }
		public String getDescription() { return description; }
		public String getLibelle() { return libelle; }
		public int getQtestock() { return qtestock; }
		public String getImageArticle() { return imagearticle; }
		public void setid(int id) { this.id = id; }
		public void setReference(String reference) { this.reference = reference; }
		public void setidCategorie(int idcategorie) { this.idcategorie = idcategorie; }
		public void setCategorie(String categorie) { this.categorie = categorie; }
		public void setPrix(int prix) { this.prix = prix; }
		public void setDescription(String description) { this.description = description; }
		public void setLibelle(String libelle) { this.libelle = libelle; }
		public void setQtestock(int qtestock) { this.qtestock = qtestock; }	
		public void setImageArticle(String imagearticle) { this.imagearticle = imagearticle; }
	}