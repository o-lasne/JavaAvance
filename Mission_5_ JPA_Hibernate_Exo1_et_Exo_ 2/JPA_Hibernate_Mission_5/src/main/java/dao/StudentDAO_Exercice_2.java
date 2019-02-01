package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Student;
import metier.Student_Exercice_2;

public class StudentDAO_Exercice_2 {
	
	EntityManagerFactory emf; 
	
	public StudentDAO_Exercice_2() {         
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU  
		emf = Persistence.createEntityManagerFactory("projetJPAPU"); 
	}
	
	public void addStudent(Student_Exercice_2 student) {   
			
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
	
	public void showJuliette(Student_Exercice_2 student) {   
		
		EntityManager em = emf.createEntityManager();        
		
		/*
		 EntityManager em = emf.createEntityManager();
		Student s1 = em.find(Student.class, id); 
		 */
		//Student_Exercice_2 s_exo2 = em.find(StudentId_Exercice_2, id);
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); 
		try{ 
			//em.find(student);
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
