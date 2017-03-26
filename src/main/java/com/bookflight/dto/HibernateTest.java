/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Adithya
 */
public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserID(1);
        userDetails.setUserName("adi");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        //put
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(int i=1; i <= 10; i++){
            UserDetails user = new UserDetails();
            user.setUserName("User"+ i);
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();
        
        //get
        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails)session.get(UserDetails.class, 1);
        System.out.println("Username retrieved is: "+ userDetails.getUserName());
        
        //delete
        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user3 = (UserDetails)session.get(UserDetails.class, 3);
        session.delete(user3);
        session.getTransaction().commit();
        session.close();
        
        //update
        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails)session.get(UserDetails.class, 1);
        userDetails.setUserName("Updated Username");
        session.update(userDetails);    
        session.getTransaction().commit();
        session.close();
    }
}
