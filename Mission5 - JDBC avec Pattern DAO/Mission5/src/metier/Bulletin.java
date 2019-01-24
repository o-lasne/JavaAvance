package metier;

public class Bulletin {
	private int idBulletin;
	private String nom,prenom;
	private Double note;
	
	public Bulletin(String nom, String prenom, Double note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}
	
	public int getIdBulletin() {
		return idBulletin;
	}
	public void setIdBulletin(int idBulletin) {
		this.idBulletin = idBulletin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Bulletin [idBulletin=" + idBulletin + ", nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]";
	}
}
