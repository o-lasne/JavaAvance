package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public void requeteParametre()
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select nom from Student student where student.nom = :n");
        query.setParameter("n", "Sniper");  
        //query.setParameter("p", "Robert");
        List<Student> stu = query.getResultList();

        System.out.print(stu.toString());
        em.close();
	}
	
	public List<Student> getStudents()
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select s from Student s", Student.class);
        List<Student> stu = query.getResultList();

        em.close();
        return stu;
	}
	
	public List<Student> getStudent(String nom)
	{
		EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select prenom from Student student where student.nom = :n");
        query.setParameter("n", nom);
        List<Student> stu = query.getResultList();

        em.close();
        return stu;
	}
	
	public void updateStudent(int id, String nom, String prenom, int age, double note)
	{
		EntityManager em = emf.createEntityManager();
		Student s1 = em.find(Student.class, id);
		
		em.getTransaction().begin();
		
		s1.setNom(nom);
		s1.setPrenom(prenom);
		s1.setAge(age);
		s1.setNote(note);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteStudent(int id)
	{
		EntityManager em = emf.createEntityManager();
		Student s1 = em.find(Student.class, id);
		
		em.getTransaction().begin();
		
		em.remove(s1);
		
		em.getTransaction().commit();
		em.close();
	}
}
