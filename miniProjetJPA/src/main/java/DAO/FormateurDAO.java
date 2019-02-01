package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import METIER.Formateur;

public class FormateurDAO {
	
	EntityManagerFactory emf; 
	
	public FormateurDAO() {         
		
		emf = Persistence.createEntityManagerFactory("miniProjetJPA"); 
	}
	
	public void addFormateur(Formateur formateur) {      
			        
		EntityManager em = emf.createEntityManager();        
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); 
		try{ 
			em.persist(formateur);
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
			em.close();        
			emf.close();      
		} 
	}
	
	public void requeteParametre()
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select nom from Student student where student.nom = :n");
        query.setParameter("n", "Sniper");  
        //query.setParameter("p", "Robert");
        List<Formateur> stu = query.getResultList();

        System.out.print(stu.toString());
        em.close();
	}
	
	public List<Formateur> getStudents()
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select s from Student s", Formateur.class);
        List<Formateur> stu = query.getResultList();

        em.close();
        return stu;
	}
	
	public List<Formateur> getStudentByName(String nom)
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select prenom from Student student where student.nom = :n");
        query.setParameter("n", nom);
        List<Formateur> stu = query.getResultList();

        em.close();
        return stu;
	}
	
	public void updateStudent(int id, String nom, String prenom, int age, double note)
	{
		EntityManager em = emf.createEntityManager();
		Formateur s1 = em.find(Formateur.class, id);
		
		em.getTransaction().begin();
		
		//s1.setNom(nom);
		//s1.setPrenom(prenom);
		//s1.setAge(age);
		//s1.setNote(note);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteStudent(int id)
	{
		EntityManager em = emf.createEntityManager();
		Formateur s1 = em.find(Formateur.class, id);
		
		em.getTransaction().begin();
		
		em.remove(s1);
		
		em.getTransaction().commit();
		em.close();
	}
}
