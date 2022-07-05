package controleur;

public class Event {
		private int id, prix;
		private String reference, categorie, description, libelle, imageevent, lieu, date;
		public Event() {//ALL
				this.id=this.prix=0;
				this.reference=this.categorie=this.description=this.libelle=this.lieu=this.date="";
			}
		public Event (int id, String reference, String categorie, String description, String libelle, int prix, String lieu, String date, String imageevent)
			{//ALL
				this.id= id;
				this.reference= reference;
				this.categorie= categorie;
				this.description = description;
				this.libelle = libelle;
				this.prix = prix;
				this.lieu = lieu;
				this.date = date;
				this.imageevent = imageevent;
			}
		public Event (String reference, String categorie, String description, String libelle, int prix, String lieu, String date)
		{//ADD & Modify
			this.reference = reference;
			this.categorie= categorie;
			this.description = description;
			this.libelle = libelle;
			this.prix = prix;
			this.lieu = lieu;
			this.date = date;
		}
		public Event (String reference) {//DELETE
			this.reference = reference;
		}
		public int getId() { return id; }
		public String getReference() { return reference; }
		public String getCategorie() { return categorie; }
		public int getPrix() { return prix; }
		public String getDescription() { return description; }
		public String getLibelle() { return libelle; }
		public String getLieu() { return lieu; }
		public String getDate() { return date; }
		public String getImageEvent() { return imageevent; }
		public void setid(int id) { this.id = id; }
		public void setReference(String reference) { this.reference = reference; }
		public void setCategorie(String categorie) { this.categorie = categorie; }
		public void setPrix(int prix) { this.prix = prix; }
		public void setDescription(String description) { this.description = description; }
		public void setLibelle(String libelle) { this.libelle = libelle; }
		public void setLieu(String lieu) { this.lieu = lieu; }
		public void setDate(String date) { this.date = date; }
		public void setImageEvent(String imageevent) { this.imageevent = imageevent; }
	}