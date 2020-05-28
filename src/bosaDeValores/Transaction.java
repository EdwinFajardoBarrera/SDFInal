/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.sql.Date;

/**
 *
 * @author Edwin Fajardo
 */
public class Transaction {
    private String userRFC;
    private String companyRFC;
    private Date date;
    private int operatedActions;
    private Double operatedActionsPrice;

    public Transaction(String userRFC, String companyRFC, Date date, int operatedActions, Double operatedActionsPrice) {
        this.userRFC = userRFC;
        this.companyRFC = companyRFC;
        this.date = date;
        this.operatedActions = operatedActions;
        this.operatedActionsPrice = operatedActionsPrice;
    }
    
    
    
    

    
    
    
}
