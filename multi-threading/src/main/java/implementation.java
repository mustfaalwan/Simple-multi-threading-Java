
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class implementation extends UnicastRemoteObject implements Service {
    //example
    public implementation() throws RemoteException{
        
        super();
    }
    public List<Object> createThreads(int input, int id, String s) throws RemoteException{
        
       
           Threads t1 = new Threads(id, s);
           t1.start();
           
           
           //to wait for the time of termination.
               try {
                   t1.join();
               } catch (InterruptedException ex) {
                  
               }

               try {
                   t1.join();
               } catch (InterruptedException ex) {
                   
               }


            LocalDateTime termination = LocalDateTime.now();
            String Tertime = t1.dtf.format(termination);
            Duration lifespan = Duration.between(t1.creation, termination);
            
           List<Object> details = t1.getDetails(id, s, t1.Ctime, Tertime, lifespan);
           
        return details;
        
    }
}
