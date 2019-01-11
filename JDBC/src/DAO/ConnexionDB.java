package dao;

import java.sql.*;	                 // ResultSet Connection DriverManager SQLException Statement


public class ConnexionDB{

	/**
	 Charge le pilote jdbc
	 */
	public static void main(String[] args) {
		try{		
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Pilote chargé");
		}
		
		catch(ClassNotFoundException e){
			System.out.println("Pilote non trouvé. "+e.getMessage());
		}
	
		/*****************************************************/
	
		String url="jdbc:mysql://localhost/exempleBDD"; //url de la base 
		ResultSet res = null;
		Connection cnx=null;
		PreparedStatement preparedStatement = null;
		
		try{
	
			cnx = DriverManager.getConnection(url,"root","");  //identifiant, mot de passe 
			//System.out.println("connection établie avec succès.\n"); 
			//Statement stmt = cnx.createStatement();
			
			//requette pour récup les notes <10
			String requete = " SELECT * FROM bulletin where note < ?;";
			preparedStatement = cnx.prepareStatement(requete);
			preparedStatement.setInt(1,10); 
			res = preparedStatement.executeQuery();
				
				
			System.out.println("Le resultat de la requete ["+requete+"] est :"); 
			while(res.next()){
			
				
			//Affichage des notes			
			System.out.print(res.getString(2)+" ");
			
			System.out.println(res.getString(3)+" ");
			
			System.out.println(res.getString(4)+" ");
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
