package TEST;

import java.util.ArrayList;
import java.util.Scanner;
import METIER.Eleve;
import METIER.Formateur;
import METIER.Identite;
import DAO.EleveDAO;
import DAO.FormateurDAO;

public class Test {

	public static void main(String[] args) {
		
		
		Identite idJuliette = new Identite();
		idJuliette.setAge(17);
		idJuliette.setNom("Capulet");
		idJuliette.setPrenom("Juliette");
		
		Identite idMarcy = new Identite();
		idMarcy.setAge(25);
		idMarcy.setNom("Miou");
		idMarcy.setPrenom("Marcy");
		
		Eleve s1 = new Eleve(idJuliette, 15.0);
		
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		listEleve.add(s1);
		
		Formateur formateur = new Formateur(idMarcy, "Expert", listEleve);
				
		EleveDAO stDAO = new EleveDAO();
		stDAO.addStudent(s1);

		FormateurDAO forDAO = new FormateurDAO();
		forDAO.addFormateur(formateur);
		
		System.out.println("La note de juliette est " + s1.getNote());
	}
}
