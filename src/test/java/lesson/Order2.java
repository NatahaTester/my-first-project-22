package lesson;

import org.junit.jupiter.api.Test;

public class Order2 {
   @Test
    public void workingWitnOrders() {
       Order firstOrder = new Order();

       firstOrder.setTotalPrice(12.34);
       firstOrder.setAddress("rigas str. 22");
       firstOrder.setItemCount(9);

       Order secondOrder = new Order();
       secondOrder.setTotalPrice(55.87);
       secondOrder.setAddress("Lubanas str. 55");
       secondOrder.setItemCount(3);

       System.out.println("hello world");
       System.out.println("first order");
       System.out.println(firstOrder.getTotalPrice());

       System.out.println("second order");
       System.out.println(secondOrder.getTotalPrice());

    }
}
