package metier;

import java.util.ArrayList;

public class Bulletin {
		
	/**
	 * Déclaration des attribus non, prénom, note
	**/
	private String nom;
	private String prenom;
	private int note;
	
	/**
	 * Constructeur Bulletin vide
	**/
	public Bulletin () {
		
	}
	
	/**
	 * Constructeur Bulletin avec paramètre
	**/
	public Bulletin(String nom, String prenom, int note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}
	
	/**
	 Getter Nom
	 @return nom
	**/
	public String getNom() {
		return nom;
	}
	
	/**
	 Setter Nom
	**/
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 Getter Prénom
	 @return Prénom
	**/
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 Setter Prenom
	**/
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 Getter note
	**/
	public int getNote() {
		return note;
	}
	
	/**
	 Setter note
	**/
	public void setNote(int note) {
		this.note = note;
	}
	
	/**
	 Fonction toString() 
	 @return bulletin en chaîne de caractère
	**/
	@Override
	public String toString() {
		return "Bulletin [nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]";
	}

}
