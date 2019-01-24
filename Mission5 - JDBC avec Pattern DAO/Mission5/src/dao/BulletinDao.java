package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.Bulletin;

public class BulletinDao {
	
	private ArrayList<Bulletin> buls = new ArrayList <Bulletin>();
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public ArrayList<Bulletin> getBuls() {
		return buls;
	}

	public void setBuls(ArrayList<Bulletin> buls) {
		this.buls = buls;
	}
    
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

    public void createConnection() throws Exception {  	
    	drivers();

    	/*****************************************************/

		String url="jdbc:mysql://localhost/mission5";
		ResultSet res = null;

		String requete = "select * from users";
		Connection cnx=null;

    	try
    	{
			cnx = DriverManager.getConnection(url,"root","");
			System.out.println("Connexion établie avec succès.\n"); 
			PreparedStatement stmt = cnx.prepareStatement(requete);
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
        
    public void addBulletin(Bulletin bul) throws Exception
    {
    	drivers();
    	
    	String nom, prenom;
    	Double note;
    	
    	nom = bul.getNom();
    	prenom = bul.getPrenom();
    	note = bul.getNote();
    	
    	/*****************************************************/
    	String url="jdbc:mysql://localhost/mission5";
		ResultSet res = null;
		Connection cnx=null;
		
    	try
    	{
			cnx = DriverManager.getConnection(url,"root","");
			String sql = "INSERT INTO users (id_users, nom, prenom, note) VALUES (default,'" + nom + "','"+ prenom + "'," + note + ")"; 
			PreparedStatement preparedStatement = cnx.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			cnx.close(); //fermeture de la connexion
    	}
    	catch(SQLException e){
			 System.out.println("Erreur de connexion ou d'exécution de la requête \n"+   
			 e.getMessage());
		}
    }
    
    /**
	 Recherche bulletin par Nom ou Prénom
	 @param mc en chaine de caractère
	 @param b en liste type de Bulletin
	 @return la liste des bulletins
     * @throws Exception 
	**/
	public Bulletin bulletinParMc(String mc, ArrayList<Bulletin> buls) throws Exception {
		
		drivers();
    	
    	/*****************************************************/
    	String url="jdbc:mysql://localhost/mission5";
		ResultSet res = null;
		Connection cnx=null;
		
		/*for (Bulletin unB : buls) {
			if(unB.getNom().equals(mc) || unB.getPrenom().equals(mc)) {
				return unB;
			}
		}*/
		
		try
		{
			cnx = DriverManager.getConnection(url,"root","");
			String sql = "Select * from users where nom = '" + mc + "'"; 
			PreparedStatement preparedStatement = cnx.prepareStatement(sql);			
			res = preparedStatement.executeQuery(sql);
			
			System.out.println("Le resultat de la requete ["+sql+"] est :"); 
			while(res.next()){
				System.out.print(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4) + "\n");
				Bulletin b2 = new Bulletin(res.getString(2), res.getString(3), Double.parseDouble(res.getString(4)));
				buls.add(b2);
				System.out.print(buls.toString());
			}
			cnx.close(); //fermeture de la connexion
		}
		catch(SQLException e){
			 System.out.println("Erreur de connexion ou d'exécution de la requête"+   
			 e.getMessage());
		}
		
		
		return null;
	}
    
}
