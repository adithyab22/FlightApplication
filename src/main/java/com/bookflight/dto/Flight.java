/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adithya
 */
@Entity
@Table (name = "FLIGHT_DETAILS")
public class Flight {
    @Id
    @Column (name = "FLIGHT_NUMBER")
    private int flightNumber;
    @Column (name = "FLIGHT_NAME")
    private String flightName;
    @Column (name = "AIRLINE_NAME")
    private String airlineName;
    @Column (name = "FLIGHT_PRICE")
    private double cost;
    
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
   
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    
}
