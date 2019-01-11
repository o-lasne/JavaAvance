package DAO;

import java.sql.*;	                 // ResultSet Connection DriverManager SQLException Statement

	public class ConnexionDB{

	public static void main(String[] args) {
	try{

	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Pilote chargé");

	}catch(ClassNotFoundException e){

	System.out.println("Pilote non trouvé. "+e.getMessage());
	}

	/*****************************************************/

	String url="jdbc:mysql://localhost/exempleBDD"; //url de la base 
	ResultSet res = null;

	String requete = "select * from matiere";     //à créer d’abord la table 
	Connection cnx=null;

	try{

	cnx = DriverManager.getConnection(url,"root","");  //identifiant, mot de passe 
	System.out.println("connection établie avec succès.\n"); 
	Statement stmt = cnx.createStatement();

	res = stmt.executeQuery(requete);

	System.out.println("Le resultat de la requete ["+requete+"] est :"); 
	while(res.next()){

	System.out.print(res.getString(1)+" ");

	System.out.print(res.getString(2)+" ");

	System.out.println(res.getString(3));
	}

	System.out.println("\n Affichage terminé.");

	cnx.close(); //fermeture de la connexion

	}
	catch(SQLException e){

	         System.out.println("Erreur de connexion ou d'exécution de la requête"+   
	         e.getMessage());
	}
	}
	}


