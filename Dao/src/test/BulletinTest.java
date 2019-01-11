package test;

import dao.BulletinDAO;

public class BulletinTest {
	
	/**
	 Fonction Principale d'affichage des résultats 
	**/
	public static void main (String[] args) {
		
		BulletinDAO b1 = new BulletinDAO ();
		System.out.println(b1.addBulletin().toString());
		System.out.println(b1.addBulletin().toString());
		System.out.println(b1.getBulletinParMc("Bayahya", b1.getlBulletin()));
		System.out.println(b1.deleteBulletinParMc("Bayahya", b1.getlBulletin()));
		
	}
}
