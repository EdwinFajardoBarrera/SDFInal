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

    public static int create(User u) {
        int iRet = -1;
        try {
            Connection con = DBManager.getInstance().getConnection();
            String SQL = "INSERT INTO users (userRFC, companyRFC, numOfActions, lastBuyPrice) values(?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, u.getUserRFC());
            pstmt.setString(2, u.getCompanyRFC());
            pstmt.setInt(3, u.getNumOfActions());
            pstmt.setDouble(4, u.getLastBuyPrice());

            iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return iRet;
    }

    public static ArrayList getUser(String userRFC) {
        int iRet = -1;
        ArrayList arr = new ArrayList();
        try {
            Connection con = DBManager.getInstance().getConnection();
            //String SQL = "INSERT INTO users (userRFC, companyRFC, numOfActions, lastBuyPrice) values(?,?,?,?)";
            String SQL = "SELECT * FROM users WHERE userRFC = '" + userRFC + "'";

            PreparedStatement pstmt = con.prepareStatement(SQL);
            //pstmt.setString(1, userRFC);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserRFC(rs.getString("userRFC"));
                u.setCompanyRFC(rs.getString("companyRFC"));
                u.setNumOfActions(rs.getInt("numOfActions"));
                u.setLastBuyPrice(rs.getDouble("lastBuyPrice"));
                arr.add(u);
            }
            
//            pstmt.setString(2, u.getCompanyRFC());
//            pstmt.setInt(3, u.getNumOfActions());
//            pstmt.setDouble(4, u.getLastBuyPrice());

            //iRet = pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException se) {
            System.out.println(se);
        }

        return arr;
    }
    
        public static ArrayList getInvestments(String userRFC) {
        int iRet = -1;
        ArrayList arr = new ArrayList();
        try {
            Connection con = DBManager.getInstance().getConnection();
            //String SQL = "INSERT INTO users (userRFC, companyRFC, numOfActions, lastBuyPrice) values(?,?,?,?)";
            String SQL = "SELECT t.companyRFC, date, operatedActions, operatedActionsPrice FROM transactions AS t INNER JOIN companies AS c ON c.companyRFC = t.companyRFC WHERE userRFC='" + userRFC + "'";
            
            //SELECT * FROM transactions as t INNER JOIN companies as c ON c.companyRFC = t.companyRFC WHERE userRFC= 'AA12001082'

            PreparedStatement pstmt = con.prepareStatement(SQL);
            //pstmt.setString(1, userRFC);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserRFC(rs.getString("userRFC"));
                u.setCompanyRFC(rs.getString("companyRFC"));
                u.setNumOfActions(rs.getInt("numOfActions"));
                u.setLastBuyPrice(rs.getDouble("lastBuyPrice"));
                arr.add(u);
            }
            
//            pstmt.setString(2, u.getCompanyRFC());
//            pstmt.setInt(3, u.getNumOfActions());
//            pstmt.setDouble(4, u.getLastBuyPrice());

            //iRet = pstmt.executeUpdate();

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
