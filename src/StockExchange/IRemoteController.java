package StockExchange;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Daniel Álvarez
 */
interface IRemoteController extends Remote {
  public int createUser(User u) throws RemoteException;
  public User getUser(String userRFC) throws RemoteException;
  public int createCompany(Company c) throws RemoteException;
  public ArrayList<Company> getAllCompanies() throws RemoteException;
  public int createInvestment(Transaction t) throws RemoteException;
  public ArrayList getInvestments(String userRFC) throws RemoteException;
}
