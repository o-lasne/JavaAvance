package test;

import metier.Adresse_Exercice_1;
import metier.Student_Exercice_1;
import dao.StudentDAO_Exercice_1;


public class Test_Exercice_1 {

	public static void main(String[] args) {
			
		Student_Exercice_1 sExo1 = new Student_Exercice_1();
		sExo1.setNom("Capulet");
		sExo1.setPrenom("Juliette");
		sExo1.setAge(15);
		sExo1.setNote(14.0);
		
		Adresse_Exercice_1 addExo1 = new Adresse_Exercice_1("Rue du riz", "00000", "Rome");
		sExo1.setAdresse(addExo1);
		System.out.println("La ville de Juliette est : " + addExo1.getVille());
		
		StudentDAO_Exercice_1 sDAOExo2 = new StudentDAO_Exercice_1();
		sDAOExo2.addStudent(sExo1);
		
	}
}
