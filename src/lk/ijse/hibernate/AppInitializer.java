/*
 * Dev_name - mGunawardhana
 * Dev_con - 071-9043372
 * e-mail - mrgunawardhana27368@gmail.com
 * Copyright (c)
 */

package lk.ijse.hibernate;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import lk.ijse.hibernate.entity.OrderDetails;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setCus_id("C001");
        c1.setCus_name("Maneesha");
        c1.setCus_address("Galle");
        c1.setCus_contact("071-9043372");

        Item i1 = new Item();
        i1.setItem_code("I001");
        i1.setItem_description("chocolate");
        i1.setItem_price(1200.00);
        i1.setQtyOnHand(100);

        Order o1=new Order();
        o1.setOrderId("O001");
        o1.setCustomer(c1);
        o1.setPrice(500.00);

        OrderDetails OD1 = new OrderDetails();
        OD1.setId("OD001");
        OD1.setItem(i1);
        OD1.setOrder(o1);
        OD1.setOrderQty(20);

        Customer c2 = new Customer();
        c2.setCus_id("C002");
        c2.setCus_name("Dakshina");
        c2.setCus_address("Galle");
        c2.setCus_contact("071-9067372");

        Item i2 = new Item();
        i2.setItem_code("I002");
        i2.setItem_description("iceCream");
        i2.setItem_price(1200.00);
        i2.setQtyOnHand(100);

        Order o2=new Order();
        o2.setOrderId("O002");
        o2.setCustomer(c2);
        o2.setPrice(500.00);

        OrderDetails OD2 = new OrderDetails();
        OD2.setId("OD002");
        OD2.setItem(i2);
        OD2.setOrder(o2);
        OD2.setOrderQty(20);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        session.save(o2);
        session.save(OD2);
        session.save(o1);
        session.save(OD1);
        session.delete(session.get(OrderDetails.class,"OD001"));

        transaction.commit();
        session.close();
    }
}
