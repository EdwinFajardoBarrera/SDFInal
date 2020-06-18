/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
package bosaDeValores;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
//import java.util.*;

/**
 *
 * @author Edwin Fajardo
 */
public class UserRepository {

    public static int createUser(User u) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "INSERT INTO users (userRFC, name, numOfActions, lastBuyPrice) values(?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, u.getUserRFC());
            pstmt.setString(2, u.getName());
            pstmt.setInt(3, u.getNumOfActions());
            pstmt.setDouble(4, u.getLastBuyPrice());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static User getUser(String userRFC) {
        User usr = new User();

        try {
            Connection con = DBManager.getInstance().getConnection();
            //String SQL = "SELECT userRFC, name FROM users WHERE userRFC = '" + userRFC + "' LIMIT 1";
            String SQL = "SELECT * FROM users WHERE userRFC = ? LIMIT 1";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, userRFC);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usr.setUserRFC(rs.getString("userRFC"));
                usr.setName(rs.getString("name"));
                usr.setNumOfActions(rs.getInt("numOfActions"));
                usr.setLastBuyPrice(rs.getDouble("lastBuyPrice"));
            }

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }
        return usr;
    }

    public static int createCompany(Company c) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "INSERT INTO companies (companyRFC, numOfActions, valueOfAction) values(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, c.getCompanyRFC());
            pstmt.setInt(2, c.getNumOfActions());
            pstmt.setDouble(3, c.getValueOfAction());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static ArrayList<Company> getAllCompanies() {
        ArrayList<Company> cList = new ArrayList();
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "SELECT * FROM companies";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Company c = new Company();
                c.setCompanyRFC( rs.getString("companyRFC") );
                c.setNumOfActions( rs.getInt("numOfActions") );
                c.setValueOfAction( rs.getDouble("valueOfAction") );
                cList.add(c);
            }

        } catch (SQLException se) {
            System.out.println(se);
        }
        return cList;
    }

//NUEVA TRANSACCIÖN
    public static int createInvestment(Transaction t) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();

            //SE ACTUALIZA EL NUMERO DE ACCIONES DISPONIBLES DE LA COMPANÍA
            String SQL = "UPDATE companies SET numOfActions =  numOfActions - ? WHERE companyRFC = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, t.getOperatedActions());
            pstmt.setString(2, t.getCompanyRFC());
            iRet = pstmt.executeUpdate();

            if (iRet == 1) {
                //SE RELIZA LA TRANSACCIÓN SI EXISTEN LAS ACCIONES SUFICIENTES
                SQL = "INSERT INTO transactions (userRFC, companyRFC, operatedActions, operatedActionsPrice) values(?,?,?,?)";
                PreparedStatement pstmt2 = con.prepareStatement(SQL);
                pstmt2.setString(1, t.getUserRFC());
                pstmt2.setString(2, t.getCompanyRFC());
                pstmt2.setInt(3, t.getOperatedActions());
                pstmt2.setDouble(4, t.getOperatedActionsPrice());
                iRet = pstmt2.executeUpdate();

                //SE ACTUALIZA EL NUMERO DE ACCIONES Y ULTIMO PRECIO DE COMPRA DEL USUARIO
                SQL = "UPDATE users SET numOfActions =  numOfActions + ?, lastBuyPrice = ? WHERE userRFC = ?";
                PreparedStatement pstmt3 = con.prepareStatement(SQL);
                pstmt3.setInt(1, t.getOperatedActions());
                pstmt3.setDouble(2, t.getOperatedActionsPrice());
                pstmt3.setString(3, t.getUserRFC());
                iRet = pstmt3.executeUpdate();
            }

        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static ArrayList getInvestments(String userRFC) {
        //int iRet = -1;
        ArrayList<Transaction> arr = new ArrayList();
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "SELECT t.companyRFC, t.operatedActions, t.operatedActionsPrice, c.valueOfAction FROM transactions as t "
                    + " INNER JOIN companies as c ON t.companyRFC = c.companyRFC WHERE userRFC = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, userRFC);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction tr = new Transaction();
                tr.setUserRFC(userRFC);
                tr.setCompanyRFC(rs.getString("companyRFC"));
                tr.setOperatedActions(rs.getInt("operatedActions"));
                tr.setOperatedActionsPrice(rs.getDouble("operatedActionsPrice"));
                tr.setActualActionsPrice(rs.getDouble("valueOfAction"));
                arr.add(tr);
            }

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return arr;
    }

//    public static ArrayList findByName(String userRFC) {
//        ArrayList arr = new ArrayList();
//
//        try {
//            String QRY = "SELECT * FROM users WHERE userRFC = (?)";
//            Connection con = DBManager.getInstance().getConnection();
//            PreparedStatement pstmt = con.prepareStatement(QRY);
//            pstmt.setString(1, "%" + name + "%");
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                Province p = new Province();
//                p.setId(rs.getInt("Id"));
//                p.setShortName(rs.getString("ShortName"));
//                p.setName(rs.getString("Name"));
//                arr.add(p);
//            }
//
//            pstmt.close();
//        } catch (SQLException se) {
//            System.out.println(se);
//        }
//        return arr;
//    }
}
