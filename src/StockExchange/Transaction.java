/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockExchange;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Edwin Fajardo
 */
public class Transaction implements Serializable {
    private String userRFC;
    private String companyRFC;
    private int operatedStocks;
    private Double operatedStocksPrice;
    private Double actualStocksPrice;

    public Transaction(String userRFC, String companyRFC, int operatedStocks, Double operatedStocksPrice) {
        this.userRFC = userRFC;
        this.companyRFC = companyRFC;
        this.operatedStocks = operatedStocks;
        this.operatedStocksPrice = operatedStocksPrice;
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

    public int getOperatedStocks() {
        return operatedStocks;
    }

    public void setOperatedStocks(int operatedStocks) {
        this.operatedStocks = operatedStocks;
    }

    public Double getOperatedStocksPrice() {
        return operatedStocksPrice;
    }

    public void setOperatedStocksPrice(Double operatedStocksPrice) {
        this.operatedStocksPrice = operatedStocksPrice;
    }

    public Double getActualStocksPrice() {
        return actualStocksPrice;
    }

    public void setActualStocksPrice(Double actualStocksPrice) {
        this.actualStocksPrice = actualStocksPrice;
    }
    
    
    
    
    
    
    
    

    
    
    
}
