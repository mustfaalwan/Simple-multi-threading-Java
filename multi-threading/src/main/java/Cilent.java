
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Cilent {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException
    {
    
    Scanner myObj = new Scanner(System.in);
    System.out.println("How many threads would you like to be created on each server?\n");
    int number = myObj.nextInt();
    
    
    Service service1 =  (Service) Naming.lookup("rmi://localhost:5099/Server_A");
    Service service2 =  (Service) Naming.lookup("rmi://localhost:5001/Server_B");
    
    for (int i = 0; i < number; i++) {
        
       //get threads details.
       List<Object> d1 = service1.createThreads(number, i, "A");
       List<Object> d2 = service2.createThreads(number, i, "B");
       
       //server A thread details.
       System.out.printf("---------------- #id " +d1.get(0)+", Server " +d1.get(1)+" ----------------\n\n");
       System.out.printf("The thread id = %d\n",d1.get(0));
       System.out.printf("The server id = %s\n",d1.get(1));  
       System.out.printf("The creation time = %s\n",d1.get(2));
       System.out.printf("The termination time = %s\n",d1.get(3));
       System.out.printf("The thread lifespan = %s\n\n",d1.get(4));
       
      
       //server B thread details.
       System.out.printf("---------------- #id " +d2.get(0)+", Server " +d2.get(1)+" ----------------\n\n");
       System.out.printf("The thread id = %d\n",d2.get(0));
       System.out.printf("The server id = %s\n",d2.get(1));  
       System.out.printf("The creation time = %s\n",d2.get(2));
       System.out.printf("The termination time = %s\n",d2.get(3));
       System.out.printf("The thread lifespan = %s\n\n",d2.get(4));
    }
    
    } 
}
