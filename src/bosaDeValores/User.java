/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Edwin Fajardo
 */
public class User implements Serializable {

    private String userRFC = null;
    private String name = null;
    private int numOfActions = 0;
    private Double lastBuyPrice = 0.0;

    public User() {

    }

    public User(String userRFC, String name) {
        this.userRFC = userRFC;
        this.name = name;
    }

    public String getUserRFC() {
        return userRFC;
    }

    public void setUserRFC(String userRFC) {
        this.userRFC = userRFC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfActions() {
        return numOfActions;
    }

    public void setNumOfActions(int numOfActions) {
        this.numOfActions = numOfActions;
    }

    public Double getLastBuyPrice() {
        return lastBuyPrice;
    }

    public void setLastBuyPrice(Double lastBuyPrice) {
        this.lastBuyPrice = lastBuyPrice;
    }

}
