package dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import metier.*;


public class BulletinDAO {
	private ArrayList<Bulletin> lBulletin = new ArrayList <Bulletin>();
	
	/**
	 Constructeur BulletinDAO
	**/
	public BulletinDAO() {
		
	}
	
	/**
	 Ajoute les éléments du bulletin saisie par l'utilisateur
	 * @return la liste des bulletins
	**/
	public ArrayList<Bulletin> addBulletin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un prenom :");
		String prenom = sc.nextLine();
		
		Scanner scNom = new Scanner(System.in);
		System.out.println("Veuillez saisir un nom :");
		String nom = scNom.nextLine();
		
		Scanner scNote = new Scanner(System.in);
		System.out.println("Veuillez saisir une note :");
		int note = Integer.parseInt(scNote.nextLine());
		Bulletin b = new Bulletin();
		b.setNom(nom);
		b.setPrenom(prenom);
		b.setNote(note);
		
		this.lBulletin.add(b);
		
		return lBulletin;
	}

	/**
	 Recherche bulletin par Nom ou Prénom
	 @param mc en chaine de caractère
	 @param b en liste type de Bulletin
	 @return la liste des bulletins
	**/
	public Bulletin getBulletinParMc(String mc, ArrayList<Bulletin> b) {
		
		for (Bulletin unB : b) {
			if(unB.getNom().equals(mc) || unB.getPrenom().equals(mc)) {
				return unB;
			}
		}
		
		return null;
	}
	
	/**
	 Affiche tous les bulletins qui ne correspondent pas au mot clé 
	 @param mc type String
	 @param b de type liste Bulletin
	 @return la liste restante de type Bulletin qui sans les bulletins supprimés
	**/
	public ArrayList<Bulletin> deleteBulletinParMc(String mc, ArrayList<Bulletin> b) {
	    Iterator<Bulletin> itr = b.iterator();
	    while(itr.hasNext()){
	        Bulletin unBulletin = itr.next();
	        if(unBulletin.getNom().equals(mc) || unBulletin.getPrenom().equals(mc)){
	            itr.remove();
	        }
	    }

	    return b;
	}
	
	
	
	
	/**
	 Getter Bulletin 
	 @return la liste des bulletins
	**/
	public ArrayList<Bulletin> getlBulletin() {
		return lBulletin;
	}
	
	
	/**
	 Setter Bulletin 
	**/
	public void setlBulletin(ArrayList<Bulletin> lBulletin) {
		this.lBulletin = lBulletin;
	}

}
