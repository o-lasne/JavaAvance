package metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint; 

@Entity
@Table(name="Etudiant", uniqueConstraints={@UniqueConstraint(name="nom_prenom", columnNames={"Nom", "Prenom"})}) 
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L; 

	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_Student")
	private int idStudent;
	@Column(name = "Age", length=3, nullable = false)
	private int age;
	@Column(name = "Nom", length=200, nullable = false, unique = true)
	private String nom;
	@Column(name = "Prenom",length=200, nullable = false, unique = true)
	private String prenom;
	@Column(name = "Note", length=20, nullable = false)
	private Double note;

	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", note=" + note + "]\n";
	}
	
	
}
