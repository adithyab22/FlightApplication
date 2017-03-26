/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Adithya
 */
public class HibernateUtility {

    private static HibernateUtility hibernateUtility;
    private Configuration cfg;
    private static SessionFactory sessionFactory;
//to disallow creating objects by other classes.

    private HibernateUtility() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
//making the Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static synchronized HibernateUtility getInstance() throws HibernateException {
        if (hibernateUtility == null) {
            hibernateUtility = new HibernateUtility();
        }
 
        return hibernateUtility;
    }
    
    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }
 
    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
