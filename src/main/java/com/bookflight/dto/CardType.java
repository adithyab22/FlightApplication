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
public class CardType {
    @Id
    private int cardTypeID;
    private String cardTypeName;
    public int getCardTypeID() {
        return cardTypeID;
    }

    public void setCardTypeID(int cardTypeID) {
        this.cardTypeID = cardTypeID;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }
   
}
