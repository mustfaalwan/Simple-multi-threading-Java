
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
public class Server_A {
    public static void main(String[] args) throws RemoteException{
	Registry registry = LocateRegistry .createRegistry(5099);
	registry.rebind("Server_A", new implementation());
        System.err.println("Server A is ready ....... \n"); 

    } 
}
