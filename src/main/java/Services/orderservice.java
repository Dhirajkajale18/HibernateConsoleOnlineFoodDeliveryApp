package Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Scanner;

import Entity.MenuEntity;
import Entity.ordersEntity;
import Entity.usersEntity;
import Util.JPAutil;

public class orderservice {
    static EntityManager em = JPAutil.getEntityManagerFactory().createEntityManager();

    public static void placeOrder(Scanner sc, int user_id) {
    	Userservice.register(sc);
        System.out.println("Enter Food ID to Order:");
        int food_id = sc.nextInt();

        try  {
            usersEntity ue = em.find(usersEntity.class, user_id);
            MenuEntity me = em.find(MenuEntity.class, food_id);

            if (ue != null && me != null) {
                ordersEntity order = new ordersEntity();
                order.setUe(ue);
                order.setMe(me);
                System.out.println("Placing order for user: " + ue.getId() + " | " + me.getName()+"|"+me.getPrice());

                     EntityTransaction et = em.getTransaction();
                 et.begin();
            em.persist(order);
               et.commit();
                System.out.println("Order placed successfully.");
            } else {
                System.out.println(" Invalid user or food ID.");
            }
        } catch (Exception e) {
            System.out.println(" Order failed.");
            e.printStackTrace();
        }
    }
    public void viewOrders(int user_id) {
        try {
            usersEntity ue = em.find(usersEntity.class, user_id);
            if (ue == null) {
                System.out.println("User not found.");
                return;
            }

            List<ordersEntity> orders = em.createQuery(
                "SELECT o FROM ordersEntity o JOIN FETCH o.me WHERE o.ue.id = :userId", ordersEntity.class).setParameter("userId", user_id).getResultList();

            if (orders.isEmpty()) {
                System.out.println("No orders found.");
                return;
            }

            System.out.println("Your Orders:");
            for (ordersEntity order : orders) {
                System.out.printf("%d- %s - ₹%.2f\n",
                	order.getId(),
                    order.getMe().getName(), 
                    order.getMe().getPrice());
               
            }
           

        } catch (Exception e) {
            System.out.println("Failed to fetch orders.");
            e.printStackTrace();
        }
    }
    public static void cancelOrder(int order_id) {
        try {
            ordersEntity order = em.find(ordersEntity.class, order_id);

            if (order != null) {
                EntityTransaction et = em.getTransaction();
                et.begin();
                em.remove(order);
                et.commit();
                System.out.println("Order canceled successfully.");
            } else {
                System.out.println("Order not found.");
            }
        } catch (Exception e) {
            System.out.println("Failed to cancel order.");
            e.printStackTrace();
        }
    }

}

