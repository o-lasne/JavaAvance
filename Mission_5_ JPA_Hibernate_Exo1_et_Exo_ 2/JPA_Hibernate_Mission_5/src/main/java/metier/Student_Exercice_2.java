package metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import metier.StudentId_Exercice_2;;

@Entity
public class Student_Exercice_2 implements Serializable{
	
	@EmbeddedId  // clé primaire
	private StudentId_Exercice_2 idStudent;
	
	private int age;
	private Double note;
	
	public Student_Exercice_2(String nom, String prenom, int age, Double note) {
		this.idStudent = new StudentId_Exercice_2(nom, prenom);
		this.age = age;
		this.note = note;
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
		return "Student Exercice 2 [idStudent=" + idStudent + ", age=" + age + ", note=" + note + "]\n";
	}
}
