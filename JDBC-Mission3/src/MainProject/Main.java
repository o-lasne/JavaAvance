package MainProject;

import GraphicInterface.Formulaire;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formulaire form = new Formulaire();
		
		try {
			form.affichage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
