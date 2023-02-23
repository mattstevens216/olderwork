////////////////////////////////////////////
////	Program Name: TimePrint.java    ////
////	Member: Matthew Stevens 		////
////	UIN: 924000693          		////
////	Member: Joshua Langley	      	////
////	UIN: 323005577	      	        ////
////	Acknowledgements: 			    ////
////////////////////////////////////////////	

import java.util.*;
import java.lang.*;
public class TimePrint implements Runnable

{
     public TimePrint(){}
     public void run()
     {
          int c = 0;
          while (true)
          {
              c = c + 1;
              System.out.print(c + " ");
              if ((c + 1) % 7 == 0)
              {
                   System.out.println();
                   System.out.println("7 second message");
              }
              if ((c + 1) % 15 == 0)
              {
                   System.out.println();
                   System.out.println("15 second message");
              }
              try
              {
                   Thread.sleep(1000);

              }
              catch (Exception e)
              {
                   e.printStackTrace();
              }

          }

     }

}