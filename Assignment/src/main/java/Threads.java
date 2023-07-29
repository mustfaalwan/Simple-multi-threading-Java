
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
public class Threads extends Thread{
    	Thread thread;
	int ThreadID;
	String serverID;
	int time;
	Random rand = new Random();
        String Ctime;
        String Ttime;
        LocalDateTime creation;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

   //const
   public Threads(int i, String s) {
       
        ThreadID = i;
	serverID = s;
	time = rand.nextInt(20); 
        creation = LocalDateTime.now();
        Ctime = dtf.format(creation);
    }
   //to deliver threads info to client.
   public List<Object> getDetails(int t, String s, String ct,  String tt, Duration lf ) 
    { 
         int tid = t; 
         String sid = s;
         String creation2 = ct; 
         String termination = tt;
         Duration life = lf;
         
        return Arrays.asList(tid, sid, creation2, termination, life); 
    } 


// Override the run() method of the Thread class sleeps randomly. then, returns info to server.
    public void run(){
            try {
                // let the thread sleep.
                Thread.sleep(time*1000);
                System.out.printf("------------------------- #" +ThreadID+" ------------------------\n\n");
                System.out.printf("The thread id = %d\n",ThreadID);
                System.out.printf("The server id = %s\n",serverID);  
                LocalDateTime termination = LocalDateTime.now();
                Ttime = dtf.format(termination);
                System.out.printf("The creation time = %s\n",Ctime);
                System.out.printf("The termination time = %s\n\n",Ttime);

                
            } catch (Exception e) {
                
            }
	
    }

}

