/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Adithya
 */
@Entity
public class Sales {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private String successID;
    //foreign key
    @OneToOne
    @JoinColumn(name="CARD_TYPE_ID")
    private CardType cardType;
    private String cardNumber;
    private double totalAmount;
    private Date bookingDate;
    //foreign key
    @OneToOne
    @JoinColumn(name="SESSION_ID")
    private UserSession userSession;

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
    public String getSuccessID() {
        return successID;
    }

    public void setSuccessID(String successID) {
        this.successID = successID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    
     public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
}
