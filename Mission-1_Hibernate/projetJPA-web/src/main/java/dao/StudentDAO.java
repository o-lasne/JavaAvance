package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import metier.Student;

public class StudentDAO {
	
	EntityManagerFactory emf; 
	
	public StudentDAO() {         
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU  
		emf = Persistence.createEntityManagerFactory("projetJPAPU"); 
	}
	
	public void addStudent(Student student) { //ajout l'étudiant dans la BDD        
			
		//la création de l'étudiant se fera par persitence.xml 
		//<property name="hibernate.hbm2ddl.auto"  value = "create" /> 
		//2.Construction d'un entity manager pour effectuer les opérations CRUD et transaction           
		EntityManager em = emf.createEntityManager();        
		//3. Ouverture d'une transaction: 
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); 
		
		try{ 
		    //4. persistence de mon object student 
			em.persist(student); //le traitement se fera toujours dans une transaction 
		    //5. commit de la transaction : validation du traitement 
			tx.commit(); 
		}
		catch(Exception e) 
		{ 
	    	//Annuler les traitements    
			if (tx != null) { 
			tx.rollback();  //annuler la transaction s'il y a une exception e.printStackTrace();     
			}
		}
		finally
		{ 
			//6. dans tous les cas on ferme        
			em.close();        
			emf.close();      
		} 
	}
}