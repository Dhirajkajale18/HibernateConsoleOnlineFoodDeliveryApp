package Util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {
private static final EntityManagerFactory emf ;
static {
	try {
		emf= Persistence.createEntityManagerFactory("hibernaateConsoleFoodapp");
	}catch(Throwable e) {throw new ExceptionInInitializerError(e);}
}
public static EntityManagerFactory getEntityManagerFactory () {
	return emf;
}
public static void shutdown() {
	if(emf!=null&&emf.isOpen())
	{emf.close();}
	
}

}

