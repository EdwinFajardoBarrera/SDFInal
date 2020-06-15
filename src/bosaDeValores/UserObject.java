/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bosaDeValores;

import java.rmi.server.UnicastRemoteObject;
//import IRemoteExchange;
//import Province;
//import ProvinceRepository;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;

/**
 *
 * @author Edwin Fajardo
 */
public class UserObject extends UnicastRemoteObject implements IRemoteUser {

    /**
     *
     */
    private static final long serialVersionUID = 11L;

    public UserObject() throws RemoteException {
        super();
    }

    public int createUser(User u) {
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return UserRepository.createUser(u);
    }

    public User getUser(String userRFC) {
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        
        return UserRepository.getUser(userRFC);
    }

    public int createCompany(Company c) {
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return UserRepository.createCompany(c);
    }
    
    
        public int createInvestment(Transaction t) {
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return UserRepository.createInvestment(t);
    }

    public ArrayList getInvestments(String userRFC) {
        ArrayList al = new ArrayList();
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }

        al = UserRepository.getInvestments(userRFC);
        return al;
    }

//  public int save(Province p) {
//    try {
//      System.out.println("Invoke save from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    return ProvinceRepository.save(p);
//  }
// 
//  public int update(Province p) {
//    try {
//      System.out.println("Invoke update from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    return ProvinceRepository.update(p);
//  }
// 
//  public int delete(Province p) {
//    try {
//      System.out.println("Invoke delete from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    return ProvinceRepository.delete(p);
//  }
// 
//  public void deleteAll() {
//    try {
//      System.out.println("Invoke deleteAll from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    ProvinceRepository.deleteAll();
//  }
// 
//  public ArrayList findAll() {
//    try {
//      System.out.println("Invoke findAll from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    return ProvinceRepository.findAll();
//  }
// 
//  public ArrayList findByName(String criteria) {
//    try {
//      System.out.println("Invoke findByName from " + getClientHost());
//    } catch (ServerNotActiveException snae) {
//      snae.printStackTrace();
//    }
//    return ProvinceRepository.findByName(criteria);
//  }
}
