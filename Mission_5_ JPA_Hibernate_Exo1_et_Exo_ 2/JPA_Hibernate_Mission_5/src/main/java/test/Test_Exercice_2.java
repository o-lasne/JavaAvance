package test;

import metier.Student_Exercice_2;
import metier.StudentId_Exercice_2;
import dao.StudentDAO_Exercice_2;


public class Test_Exercice_2 {

	public static void main(String[] args) {
			
		Student_Exercice_2 sExo2 = new Student_Exercice_2("Capulet_2", "Juliette_2", 14, 13.3);
		StudentId_Exercice_2 sIDExo2 = new StudentId_Exercice_2();
		StudentDAO_Exercice_2 sDAOExo2 = new StudentDAO_Exercice_2();
		sDAOExo2.addStudent(sExo2);
		
		//System.out.println("Le nom de Juliette est : " + sIDExo2.getNom());
		//System.out.println("nom Juliette : " + sIDExo2.getNom()); getNom = null
	}
}
