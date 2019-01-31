package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Student_Exercice_1;

public class StudentDAO_Exercice_1 {
	
	EntityManagerFactory emf; 
	
	public StudentDAO_Exercice_1() {         
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU  
		emf = Persistence.createEntityManagerFactory("projetJPAPU"); 
	}
	
	public void addStudent(Student_Exercice_1 student) {   
			
		EntityManager em = emf.createEntityManager();        
		
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); 
		try{ 
			em.persist(student);
			tx.commit(); 
		}
		catch(Exception e) 
		{ 
	    	  
			if (tx != null) { 
			tx.rollback();  
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
