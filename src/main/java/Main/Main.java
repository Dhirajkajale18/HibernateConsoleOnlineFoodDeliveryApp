package Main;


import java.util.Scanner;

import Services.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 menuservice ms=new menuservice();
 orderservice os=new orderservice();
        while (true) {
            System.out.println("\n--- Console Food App ---");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View My Orders");
            System.out.println("4. Cancel Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
          int userid=1;
            switch (choice) {
                case 1:
                	ms.displayMenu();
                    break;
                case 2:
                	System.out.println("Enter your User id : ");
                	int user_id=sc.nextInt();
                    os.placeOrder(sc, user_id);
                    break;
                case 3:
                	 
                   os.viewOrders(userid);
                    break;
                case 4:
                	  System.out.println("Enter your order id to Cancel order: ");
                    int orderid = sc.nextInt();
                    orderservice.cancelOrder(orderid);
                    break;
                case 5:
                    System.out.println("Thank you for using Console Food App.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
     
  
    }
    
}