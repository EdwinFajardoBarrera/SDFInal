/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.io.Serializable;

/**
 *
 * @author Edwin Fajardo
 */
public class User implements Serializable {
    
    private String userRFC = "";
    private String companyRFC = "";    
    private int numOfActions = 0;
    private Double lastBuyPrice = 0.0;
    
    public User () {
    
    }
    
    
    public User (String userRFC, String companyRFC) {
        this.userRFC = userRFC;
        this.companyRFC = companyRFC;
    }

    public String getUserRFC() {
        return userRFC;
    }

    public void setUserRFC(String userRFC) {
        this.userRFC = userRFC;
    }

    public String getCompanyRFC() {
        return companyRFC;
    }

    public void setCompanyRFC(String companyRFC) {
        this.companyRFC = companyRFC;
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
