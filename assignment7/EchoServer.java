////////////////////////////////////////////
////	Program Name: EchoServer.java	////
////	Member: Matthew Stevens 		////
////	UIN: 924000693          		////
////	Member: Joshua Langley	      	////
////	UIN: 323005577	      	        ////
////	Acknowledgements: Jared Wheeler ////
////////////////////////////////////////////	


import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class EchoServer implements Runnable {
	//using "static" enables these fields shared among all EchoServer instances
	private static final Queue<String> requests = new LinkedList<String>();
	private static Lock changeLock = new ReentrantLock();
	private static Condition newMessage = changeLock.newCondition();
	
	//Instance members for each thread
	private String title;
	private int id;
	private int messageNo = 0;
	
	public EchoServer(String t, int i){
		title = t;
		id = i;
		//assign instance member fields and
		//start a new thread for this EchoServer instance
		new Thread(this).start();
 	}
	
	public void echo(String s){
		//add the String s to the message queue; to do so,
		//first, acquire the lock
		changeLock.lock();
		try{
		//second, add s to requests
		requests.add(s);
		//third, signal every thread that is waiting on the lock, and
		newMessage.signalAll();
		//finally, release the lock
		} finally { changeLock.unlock(); }
		//you need to use try-finally block

	}

	public synchronized void run() {
		while(true){ //the threads keep adding and echoing the messages
			if(title.equals("manager")){//if this is the manager
				//acquire the lock
				changeLock.lock();
				//check if there is a message in the queue to print out
				if(!requests.isEmpty()){
					realEcho(requests.remove());
					changeLock.unlock();
				} else {
					try{ newMessage.await();	
					} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
				//if so, invokes realEcho with the message removed from the queue
				//if not, within a try-catch block, await on the condition to change such that
				//new messages are added. You need to catch InterruptedException
				//release the lock		
			} else {//not manager, i.e., any other EchoServer instance
				try{
				echo("Message " + (++messageNo) + " from " + title);
				Thread.sleep(100+500*(messageNo%id));
				} catch (InterruptedException e) {
				e.printStackTrace();	
				}
			}
		}
	}
	
	private void realEcho(String s){
		System.out.println("Echoing ... " + s);
	}
}

