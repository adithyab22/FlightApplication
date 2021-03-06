/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Adithya
 */
@Entity
@Table (name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_ID")
    private int cartID;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "CART_FLIGHT",
            joinColumns = @JoinColumn(name = "CART_ID"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {
        @Column(name = "FLIGHT_COMPONENT_ID")}, generator = "hilo-gen", type = @Type(type = "long"))
    private List<FlightComponent> listOfFlightComponents = new ArrayList<FlightComponent>();

    @Column(name = "TOTAL_CART_PRICE")
    private double totalCartPrice;

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public List<FlightComponent> getListOfFlightComponents() {
        return listOfFlightComponents;
    }

    public void setListOfFlightComponents(List<FlightComponent> listOfFlightComponents) {
        this.listOfFlightComponents = listOfFlightComponents;
    }

    public double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

}
