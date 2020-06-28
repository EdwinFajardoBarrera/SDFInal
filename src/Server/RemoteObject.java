package Server;

import DataBase.Repository;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import static java.rmi.server.RemoteServer.getClientHost;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;

/**
 * @author Edwin Fajardo
 */
public class RemoteObject extends UnicastRemoteObject implements IRemoteController {

    /**
     *
     */
    private static final long serialVersionUID = 11L;

    public RemoteObject() throws RemoteException {
        super();
    }

    public int createUser(User u) {
        try {
            System.out.println("Creación de uauario desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return Repository.createUser(u);
    }

    public User getUser(String userRFC) {
        try {
            System.out.println("Obtención de usuario desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }

        return Repository.getUser(userRFC);
    }

    public int createCompany(Company c) {
        try {
            System.out.println("Creación de companía desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return Repository.createCompany(c);
    }

    public ArrayList<Company> getAllCompanies() {
        try {
            System.out.println("Listad de companías desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        
        ArrayList<Company> arr = Repository.getAllCompanies();
        
        return arr;
    }

    public int createInvestment(Transaction t) {
        try {
            System.out.println("Solicitud de inversión desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return Repository.addInvestmentToQueue(t);
    }

    public ArrayList getInvestments(String userRFC) {

        try {
            System.out.println("Listado de inversiónes desde: " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }

        ArrayList<Transaction> arr = Repository.getInvestments(userRFC);

        return arr;
    }
}
