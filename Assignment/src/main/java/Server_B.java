
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Server_B {
    public static void main(String[] args) throws RemoteException{
	Registry registry = LocateRegistry .createRegistry(5001);
	registry.rebind("Server_B", new implementation());
         System.err.println("Server B is ready ....... \n"); 
    } 
}
