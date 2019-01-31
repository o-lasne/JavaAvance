package test;

import java.util.Scanner;

import dao.StudentDAO;
import metier.Student;

public class Test {

	public static void main(String[] args) {
		
		Scanner scNom = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");
		String nom = scNom.nextLine();
		
		Scanner scPrenom = new Scanner(System.in);
		System.out.println("Veuillez saisir un prenom :");
		String prenom = scPrenom.nextLine();
		
		Scanner scAge = new Scanner(System.in);
		System.out.println("Veuillez saisir un age :");
		int age = Integer.parseInt(scAge.nextLine());
		
		Scanner scNote = new Scanner(System.in);
		System.out.println("Veuillez saisir un note :");
		Double note = Double.parseDouble(scNote.nextLine());
		
		Student s1 = new Student();
		s1.setNom(nom);
		s1.setPrenom(prenom);
		s1.setAge(age);
		s1.setNote(note);
		
		StudentDAO stDAO = new StudentDAO();
		stDAO.addStudent(s1);
		stDAO.requeteParametre();
		System.out.println("GetStudents : " + stDAO.getStudents().toString());
		System.out.println("GetStudent : " + stDAO.getStudent("Haricot").toString());
		stDAO.updateStudent(22, "Tomtom", "Nana", 10, 12);
		stDAO.deleteStudent(25);
	}
}
