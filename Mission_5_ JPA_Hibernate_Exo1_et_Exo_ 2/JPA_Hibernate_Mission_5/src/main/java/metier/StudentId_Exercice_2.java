package metier;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentId_Exercice_2 implements Serializable {
	
	private String nom, prenom;

	public StudentId_Exercice_2() {
		
	}
	
	public StudentId_Exercice_2(String nomP, String prenomP) {
		this.nom = nomP;
		this.prenom = prenomP;
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

	@Override
	public String toString() {
		return "StudentId_Exercice_2 [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// Garantir l'equivalence de l'identité persistance
		
		boolean sontEgaux = false;
		if(obj!=null && obj instanceof StudentId_Exercice_2) {
			StudentId_Exercice_2 autre = (StudentId_Exercice_2)obj;
			sontEgaux = this.getNom().equals(autre.getNom()) && this.getPrenom().equals(autre.getPrenom());
		}
		return sontEgaux;
		//return equals(obj);
	}

	@Override
	public int hashCode() {
		// Retourne un entier qui permet d'identifier un objet
		//return hashCode();
		return this.nom.hashCode()+this.prenom.hashCode();
	}
}







