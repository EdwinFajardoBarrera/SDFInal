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
public class Company implements Serializable{
    
    private String companyRFC = "";
    private int numOfActions = 0;
    private Double valueOfAction = 0.0;

    public Company(String companyRFC, int numOfActions, Double valueOfAction) {
        this.companyRFC = companyRFC;
        this.numOfActions = numOfActions;
        this.valueOfAction = valueOfAction;
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

    public Double getValueOfAction() {
        return valueOfAction;
    }

    public void setValueOfAction(Double valueOfAction) {
        this.valueOfAction = valueOfAction;
    }
    
    
    

    
    
    
}
