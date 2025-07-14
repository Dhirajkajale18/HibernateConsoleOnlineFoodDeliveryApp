package Services;

import java.util.List;

import Entity.MenuEntity;
import Util.JPAutil;
import jakarta.persistence.EntityManager;

public class menuservice {
    public static void displayMenu() {
    	EntityManager em=JPAutil.getEntityManagerFactory().createEntityManager();
        try {
            List<MenuEntity> menuList = em.createQuery("SELECT m FROM MenuEntity m", MenuEntity.class).getResultList();

            System.out.println("Menu:");
            for (MenuEntity food : menuList) {
                System.out.printf("  %d  %s - ₹%.2f\n", food.getId(), food.getName(), food.getPrice());
            }

        } catch (Exception e) {
            System.out.println("Failed to fetch menu.");
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
