////////////////////////////////////////////
////	Program Name: Main4.java     	////
////	Member: Matthew Stevens 		////
////	UIN: 924000693          		////
////	Member: Joshua Langley	      	////
////	UIN: 323005577	      	        ////
////	Acknowledgements: 			    ////
////////////////////////////////////////////	

import java.lang.reflect.*;
import java.util.*;


class Main4{
	public static void main(String[] args){
			try{
				try{
				Class<?> c = Class.forName(args[0]);
				try{
				Method method = c.getMethod("test", String[].class);
				System.out.println("test = " + method.toString());
				}catch (NoSuchMethodException e){System.out.println("no method");}
			}catch(NoSuchElementException e){
				System.out.println(e.toString());
			}
			}catch (ClassNotFoundException e){System.out.println("no class");}
/* 			String[] params = null;
			method.invoke(null, (Object) params);
			if (test.getMethod() == true)
					System.out.println("OK: " + params + " Succeeded.");
			else
					System.out.println("FAILED: " + params + " Failed."); */
	}
}