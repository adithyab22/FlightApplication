/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adithya
 */
@Embeddable
public class FlightComponent implements Cloneable{
    private int flightComponentID;
    @Column(name="FLIGHT_ID")
    private int flightID;
    @Temporal (TemporalType.DATE)
    @Column(name="FLIGHT_DATE")
    private Date flightDate;
    @Column(name="FLIGHT_PRICE")
    private double flightPrice;
    @Column(name="AIRLINE_CARD_PRICE")
    private double airlineCardPrice;
    @Column(name="COMPUTED_PRICE")
    private double computedPrice;
    @Column(name="IS_REMOVED")
    private int isRemoved;
    @Column(name="CREATED_DATETIME")
    private Date createdDateTime;
     @Column(name="REMOVED_DATETIME")
    private Date removedDateTime;
   
    public int getFlightComponentID() {
        return flightComponentID;
    }

    public void setFlightComponentID(int flightComponentID) {
        this.flightComponentID = flightComponentID;
    }
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public double getAirlineCardPrice() {
        return airlineCardPrice;
    }

    public void setAirlineCardPrice(double airlineCardPrice) {
        this.airlineCardPrice = airlineCardPrice;
    }

    public double getComputedPrice() {
        return computedPrice;
    }

    public void setComputedPrice(double computedPrice) {
        this.computedPrice = computedPrice;
    }

    public int getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(int isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getRemovedDateTime() {
        return removedDateTime;
    }

    public void setRemovedDateTime(Date removedDateTime) {
        this.removedDateTime = removedDateTime;
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
