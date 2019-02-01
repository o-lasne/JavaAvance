package METIER;

import METIER.Identite;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint; 

@Entity
public class Eleve implements Serializable{
	
	private static final long serialVersionUID = 1L; 

	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEleve;
	
	@Embedded
	private Identite identite;
		
	private Double note;

	public Eleve() {
		
	}
	
	public Eleve(Identite identiteP, Double noteP) {
		this.identite = identiteP;
		this.note = noteP;
	}
	
	public Double getNote()
	{
		return note;
	}
	
	public void setNote(Double noteP)
	{
		this.note = noteP;
	}
	
	@Override
	public String toString() {
		return "Eleve [idEleve=" + idEleve + ", identite=" + identite + " note=" + note + "]";
	}
}
