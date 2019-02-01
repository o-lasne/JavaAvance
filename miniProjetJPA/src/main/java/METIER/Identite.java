package METIER;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Identite implements Serializable{
	
	private String nom, prenom;
	private int age;
	
	public Identite()
	{
		
	}
	
	public Identite(String nomP, String prenomP, int ageP)
	{
		this.nom = nomP;
		this.prenom = prenomP;
		this.age = ageP;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nomP)
	{
		this.nom = nomP;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public void setPrenom(String prenomP)
	{
		this.prenom = prenomP;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int ageP)
	{
		this.age = ageP;
	}
}
