/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package com.bookflight.dao;

import com.bookflight.dto.FlightComponent;
import com.bookflight.util.HibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Adithya
 */
public class CartDAO {
    /**
     * Loads list of available flights from database
     */
    public List<FlightComponent> loadFlightComponents(){
       Session session = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            Query query = session.createQuery("from Cart c");
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<FlightComponent>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    /**
     * 
     */
    public FlightComponent addToCart(FlightComponent flightComponent){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(flightComponent);
            transaction.commit();
            return flightComponent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public boolean removeFromCart(int flightComponentId){
        Session session = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Student s where s.id =:id");
            createQuery.setParameter("id", flightComponentId);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }
    
 
    public FlightComponent findFlightComponentById(int id) {
        Session session = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            Query query = session.createQuery("from Cart c where c.id = :id");
            query.setParameter("id", id);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (FlightComponent) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
 
    public void updateCart(FlightComponent flightComponent) {
        Session session = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            session.saveOrUpdate(flightComponent);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}
