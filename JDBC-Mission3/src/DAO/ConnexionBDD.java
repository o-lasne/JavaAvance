package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConnexionBDD {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void drivers() throws Exception
    {
    	try
    	{
			Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Pilote non trouvé. " + e.getMessage());
    	}
    }
    
    public void addValueInDataBase(String nom, String prenom, int note) throws Exception
    {
    	drivers();
    	
    	/*****************************************************/
    	String url="jdbc:mysql://localhost/db_bulletin"; //url de la base 
		ResultSet res = null;

		String requete = "select * from users";     //à créer d’abord la table 
		Connection cnx=null;
		
    	try
    	{
			cnx = DriverManager.getConnection(url,"root","");  //identifiant, mot de passe 
			
			
	    	// create a Statement from the connection
			Statement statement = cnx.createStatement();
	    	// insert the data
	    	statement.executeUpdate("INSERT INTO users VALUES (default, ' " + nom + "', '" + prenom + "', " + note + ")");
			cnx.close(); //fermeture de la connexion
    	}
    	catch(SQLException e){
			 System.out.println("Erreur de connexion ou d'exécution de la requête"+   
			 e.getMessage());
		}
    }
    
    public void readDataBase() throws Exception {
    	
    	drivers();

    	/*****************************************************/

		String url="jdbc:mysql://localhost/db_bulletin"; //url de la base 
		ResultSet res = null;

		String requete = "select * from users";     //à créer d’abord la table 
		Connection cnx=null;

    	try
    	{
			cnx = DriverManager.getConnection(url,"root","");  //identifiant, mot de passe 
			System.out.println("connection établie avec succès.\n"); 
			Statement stmt = cnx.createStatement();
			
			res = stmt.executeQuery(requete);
			
			System.out.println("Le resultat de la requete ["+requete+"] est :"); 
			while(res.next()){
				System.out.print(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4) + "\n");
			}
			cnx.close(); //fermeture de la connexion
    	}
		catch(SQLException e){
			 System.out.println("Erreur de connexion ou d'exécution de la requête"+   
			 e.getMessage());
		}

    }
}
