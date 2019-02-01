package METIER;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint; 

@Entity
public class Formateur implements Serializable{
	
	private static final long serialVersionUID = 1L; 

	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFormateur;

	@Embedded
	private Identite identite;
	
	private String experience;
	
	@OneToMany
	private Collection<Eleve> eleList;
	
	public Formateur()
	{
		
	}

	public Formateur(Identite identiteP, String experienceP, Collection<Eleve> listEleP)
	{
		this.identite = identiteP;
		this.experience = experienceP;
		this.eleList = listEleP;
	}

	@Override
	public String toString() {
		return "Formateur [idFormateur=" + idFormateur + ", identite=" + identite + ", experience=" + experience + "]";
	}
}
