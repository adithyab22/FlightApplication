/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dao;

import com.bookflight.dto.CardType;
import com.bookflight.dto.Sales;
import com.bookflight.dto.UserDetails;
import com.bookflight.util.HibernateUtility;
import java.util.Date;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adithya
 */
public class SalesDAO {

    private static Logger log = LoggerFactory.getLogger(SalesDAO.class);

    /**
     * Get the details required to book and add to the sales table
     */
    public void book(CardType cardType, String cardNumber, int cartId, UserDetails user) {
        Sales sales = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();

            //Logic
            //get all the details
            //create a sales object
            //save sales, so that it gets added to the table
            sales = new Sales();
            sales.setBookingDate(new Date());
            sales.setCardType(cardType);
            String successID = generateSuccessID(user);
            sales.setSuccessID(successID);
            sales.setTotalAmount(cartId);
            session.save(sales);

            transaction.commit();
            log.info("Booking successful; success ID = " + successID);
        } catch (Exception e) {
            log.error("Booking unsuccessful, Please check exception: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * Generates a simple unique successID, include the userid and current timestamp
     *
     * @return
     */
    public String generateSuccessID(UserDetails user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getUserName());
        Random random = new Random(System.nanoTime());
        int randomInt = random.nextInt(1000000000);
        sb.append(randomInt + "");
        return sb.toString();
    }

    public Sales getSalesBySuccessID(String successID) {
        Sales sales = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            sales = (Sales) session.get(Sales.class, successID);
            transaction.commit();
            return sales;
        } catch (Exception e) {
            log.error("Sales information not found for success ID: " + successID);
            return null;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        
    }
}
