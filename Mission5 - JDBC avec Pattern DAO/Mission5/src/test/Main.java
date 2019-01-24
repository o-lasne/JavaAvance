package test;

import java.util.Scanner;

import dao.BulletinDao;
import metier.Bulletin;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un prenom :");
		String prenom = sc.nextLine();
		
		Scanner scNom = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");
		String nom = scNom.nextLine();
		
		Scanner scNote = new Scanner(System.in);
		System.out.println("Veuillez saisir une note :");
		Double note = Double.parseDouble(scNote.nextLine());
		
		// TODO Auto-generated method stub
		Bulletin b1 = new Bulletin(nom, prenom, note);

		BulletinDao test = new BulletinDao();
		test.addBulletin(b1);
		
		Scanner scmc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot clé :");
		String mc = scmc.nextLine();
		
		test.bulletinParMc(mc, test.getBuls());
	}

}
