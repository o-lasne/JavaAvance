package metier;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse_Exercice_1 implements Serializable {
	
	private String rue, codePostal, ville;
	
	public Adresse_Exercice_1() {
	
	}
	
	public Adresse_Exercice_1(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
