/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Adithya
 */
@Entity
public class UserSession {
    @Id
    private String sessonID;
    //foreign key
    private int userID;
    //foreign key
    private int cartID;
    //foreign key
    private int cardTypeID;
    //foreign key
    private String cardType;
    public String getSessonID() {
        return sessonID;
    }

    public void setSessonID(String sessonID) {
        this.sessonID = sessonID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCardTypeID() {
        return cardTypeID;
    }

    public void setCardTypeID(int cardTypeID) {
        this.cardTypeID = cardTypeID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
}
