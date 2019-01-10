import java.io.*;
import java.awt.List;
import java.util.ArrayList;


public class Bulletin implements IBulletin {
	
	//Définition des attribus
	private String nom;
	private String prenom;
	private int note;	
	private ArrayList<Bulletin> lBulletin = new ArrayList();
	
	//Constructeur Bulletin
	public Bulletin(String nom, String prenom, int note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}

	//Getter liste Bulletin
	public ArrayList<Bulletin> getlBulletin() {
		return lBulletin;
	}

	//Setter liste Bulletin
	public void setlBulletin(ArrayList<Bulletin> lBulletin) {
		this.lBulletin = lBulletin;
	}

	//Getter Nom
	public String getNom() {
		return nom;
	}

	//Setter Nom
	public void setNom(String nom) {
		this.nom = nom;
	}

	//Getter Prenom
	public String getPrenom() {
		return prenom;
	}

	//Setter Prenom
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//Getter Note
	public int getNote() {
		return note;
	}

	//Setter Note
	public void setNote(int note) {
		this.note = note;
	}


	//Fonction addBulletin() pour ajouter les bulletins et les afficher
	@Override
	public ArrayList addBulletin() {
		  // create an empty array list with an initial capacity 
        // use add() method to add elements in the list 
        lBulletin.add(this); 
        // prints all the elements available in list 
       for (Bulletin note : lBulletin) { 
          System.out.println("Nom : " + note.getNom() + " " + note.getPrenom() + " " + " Note : " + note.getNote()); 
        } 
		
		return lBulletin;
	}
	
	//Fonction principale qui définit les bulletins et appelle la fonction addBulletin()
	public static void main(String[] args) {
		
		Bulletin b1 = new Bulletin("Thaina","Cynthia",13);
		Bulletin b2 = new Bulletin ("DIAGANA","Bayahya",15);
		b1.addBulletin();
		b2.addBulletin();
		
	}
}


