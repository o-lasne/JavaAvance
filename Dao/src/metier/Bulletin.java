package metier;

import java.util.ArrayList;

public class Bulletin {
		
	/**
	 * D�claration des attribus non, pr�nom, note
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
	 * Constructeur Bulletin avec param�tre
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
	 Getter Pr�nom
	 @return Pr�nom
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
	 @return bulletin en cha�ne de caract�re
	**/
	@Override
	public String toString() {
		return "Bulletin [nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]";
	}

}
