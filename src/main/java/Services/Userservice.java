package Services;

import java.util.Scanner;

import Entity.usersEntity;
import Util.JPAutil;
import jakarta.persistence.EntityManager;

public class Userservice {
	static EntityManager em=JPAutil.getEntityManagerFactory().createEntityManager();
public static void register(Scanner sc) {
	try {
		sc.nextLine();
		System.out.println("Enter Name: ");
		String username=sc.next();
		System.out.println("Enter Password: ");
		String password=sc.next();
		System.out.println("Enter Address: ");
		String address=sc.next();
		System.out.println("Enter Mobile Number: ");
		long MobNo=sc.nextLong();
		
		usersEntity u=new usersEntity();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("User Registered Successfully");
		
		
	}
	catch(Exception e) {
		em.getTransaction().rollback();
		System.out.println("Registration Failed!!");
	}
}
}
