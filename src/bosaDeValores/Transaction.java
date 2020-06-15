/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Edwin Fajardo
 */
public class Transaction implements Serializable {
    private String userRFC;
    private String companyRFC;
    private int operatedActions;
    private Double operatedActionsPrice;
    private Double actualActionsPrice;

    public Transaction(String userRFC, String companyRFC, int operatedActions, Double operatedActionsPrice) {
        this.userRFC = userRFC;
        this.companyRFC = companyRFC;
        this.operatedActions = operatedActions;
        this.operatedActionsPrice = operatedActionsPrice;
    }
    
    public Transaction() {}

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

    public int getOperatedActions() {
        return operatedActions;
    }

    public void setOperatedActions(int operatedActions) {
        this.operatedActions = operatedActions;
    }

    public Double getOperatedActionsPrice() {
        return operatedActionsPrice;
    }

    public void setOperatedActionsPrice(Double operatedActionsPrice) {
        this.operatedActionsPrice = operatedActionsPrice;
    }

    public Double getActualActionsPrice() {
        return actualActionsPrice;
    }

    public void setActualActionsPrice(Double actualActionsPrice) {
        this.actualActionsPrice = actualActionsPrice;
    }
    
    
    
    
    
    
    
    

    
    
    
}
