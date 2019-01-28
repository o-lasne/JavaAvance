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
	Integer age = Integer.parseInt(scAge.nextLine());
	
	Scanner scNote = new Scanner(System.in);
	System.out.println("Veuillez saisir un note :");
	Double note = Double.parseDouble(scNote.nextLine());

	StudentDAO sDAO = new StudentDAO();
	Student s1 = new Student();
	s1.setNom(nom);
	s1.setPrenom(prenom);
	s1.setNote(note);
	s1.setAge(age);
	
	sDAO.addStudent(s1);
	
	
	}

}
