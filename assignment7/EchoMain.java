////////////////////////////////////////////
////	Program Name: EchoMain.java    	////
////	Member: Matthew Stevens 		////
////	UIN: 924000693          		////
////	Member: Joshua Langley	      	////
////	UIN: 323005577	      	        ////
////	Acknowledgements: 			    ////
////////////////////////////////////////////	


import java.util.*;
public class EchoMain{
    public static void main(String[] args) {
        Runnable manager = new EchoServer("manager", 1);
        Runnable client1 = new EchoServer("client1", 2);
        Runnable client2 = new EchoServer("client2", 3);
        new Thread(manager).start();
        new Thread(client1).start();
        new Thread(client2).start();
    }
}
