/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dao;

import com.bookflight.dto.Cart;
import com.bookflight.dto.FlightComponent;
import com.bookflight.dto.UserDetails;
import com.bookflight.util.HibernateUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adithya
 */
public class CartDAO {

    private static Logger log = LoggerFactory.getLogger(CartDAO.class);

    /**
     * Loads list of available flights from database
     * @param cartID
     * @return 
     */
    public List<FlightComponent> loadFlightComponents(int cartID) {
        Session session = null;
        Transaction transaction = null;
        Cart cart = null;
        List<FlightComponent> flightComponents = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            cart = (Cart) session.get(Cart.class, cartID);
            if (cart != null) {
                flightComponents = (List<FlightComponent>) cart.getListOfFlightComponents();
            }
            transaction.commit();
            return flightComponents;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Adds the flight component to the provided Cart ID
     */
    public FlightComponent addToCart(FlightComponent flightComponent, int cartID) {
        Session session = null;
        Transaction transaction = null;
        Cart cart = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            cart = (Cart) session.get(Cart.class, cartID);
            if (cart != null) {
                List<FlightComponent> listOfFlightComponents = cart.getListOfFlightComponents();
                listOfFlightComponents.add(flightComponent);
                cart.setListOfFlightComponents(listOfFlightComponents);
                cart.setTotalCartPrice(cart.getTotalCartPrice() + flightComponent.getComputedPrice());
            } else {
                cart = new Cart();
                cart.setCartID(cartID);
                List<FlightComponent> newList = new ArrayList<>();
                newList.add(flightComponent);
                //Create a new list of flight components and add to Cart
                cart.setListOfFlightComponents((ArrayList<FlightComponent>) newList);
                //Update the cart
                cart.setTotalCartPrice(flightComponent.getComputedPrice());
            }
            session.save(cart);
            transaction.commit();
            return flightComponent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Sets isRemoved flag = 1 for the provided Flight Component ID
     *
     * @param cartID
     * @param flightComponentId
     * @return
     */
    public boolean removeFromCart(int cartID, int flightComponentId) {
        Session session = null;
        Transaction transaction = null;
        Cart cart = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            cart = (Cart) session.get(Cart.class, cartID);
            //if cart with Cart_ID is available
            if (cart != null) {
                //Get list of FlightComponents in the cart
                List<FlightComponent> flightComponents = (List<FlightComponent>) cart.getListOfFlightComponents();
                if (flightComponents != null) {
                    //Get the component having the provided Flight Component ID
                     for (FlightComponent flightComponent : flightComponents) {
                        if (flightComponent.getFlightComponentID() == flightComponentId) {
                            flightComponent.setIsRemoved(1);
                            FlightComponent updatedComponent = null;
                            try {
                                updatedComponent = (FlightComponent) flightComponent.clone();
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                            flightComponents.remove(flightComponent);
                            flightComponents.add(updatedComponent);
                            cart.setListOfFlightComponents(flightComponents);
                            //update price
                            cart.setTotalCartPrice(cart.getTotalCartPrice() - flightComponent.getComputedPrice());
                            session.update(cart);
                            transaction.commit();
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return true;
    }

    public void updateCart(Cart cart, FlightComponent f) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtility.getInstance().getSession();
            transaction = session.beginTransaction();
            int flightComponentId = f.getFlightComponentID();
            if (cart != null) {
                //Get list of FlightComponents in the cart
                List<FlightComponent> flightComponents = (List<FlightComponent>) cart.getListOfFlightComponents();
                if (flightComponents != null) {
                    //Get the component having the provided Flight Component ID
                    for (FlightComponent flightComponent : flightComponents) {
                        if (flightComponent.getFlightComponentID() == flightComponentId) {
                            FlightComponent updatedComponent = null;
                            try {
                                updatedComponent = (FlightComponent) flightComponent.clone();
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                            flightComponents.remove(flightComponent);
                            flightComponents.add(updatedComponent);
                            //update price
                            cart.setTotalCartPrice(cart.getTotalCartPrice() - flightComponent.getComputedPrice());
                            session.update(cart);
                            transaction.commit();
                        }
                    }
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        //Create 2 Flight Component objects, add to a list
        FlightComponent flightComponent1 = new FlightComponent();
        flightComponent1.setFlightComponentID(10);
        flightComponent1.setAirlineCardPrice(2.0);
        flightComponent1.setComputedPrice(102.0);
        flightComponent1.setCreatedDateTime(new Date());
        flightComponent1.setFlightDate(new Date());
        flightComponent1.setFlightPrice(100.0);
        flightComponent1.setIsRemoved(0);

        FlightComponent flightComponent2 = new FlightComponent();
        flightComponent2.setFlightComponentID(11);
        flightComponent2.setAirlineCardPrice(3.0);
        flightComponent2.setComputedPrice(203.0);
        flightComponent2.setCreatedDateTime(new Date());
        flightComponent2.setFlightDate(new Date());
        flightComponent2.setFlightPrice(200.0);
        flightComponent2.setIsRemoved(0);

        List<FlightComponent> listOfFlightComponents = new ArrayList<>();
        listOfFlightComponents.add(flightComponent1);
        listOfFlightComponents.add(flightComponent2);
        Cart c = new Cart();
        c.setCartID(1);
        c.setListOfFlightComponents((ArrayList<FlightComponent>) listOfFlightComponents);

        cartDAO.addToCart(flightComponent1, 1);
        cartDAO.addToCart(flightComponent2, 1);

        System.out.println(cartDAO.removeFromCart(1, 11));

    }

}
