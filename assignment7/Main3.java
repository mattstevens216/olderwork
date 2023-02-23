////////////////////////////////////////////
////	Program Name: Main3.java     	////
////	Member: Matthew Stevens 		////
////	UIN: 924000693          		////
////	Member: Joshua Langley	      	////
////	UIN: 323005577	      	        ////
////	Acknowledgements: 			    ////
////////////////////////////////////////////	

import java.lang.reflect.*;
import java.util.*;

class Main3{
	
	static void displayMethodInfo(Object obj){
		Method methods[] = obj.getClass().getDeclaredMethods();
			for(Method b : methods){
				boolean isStatic = Modifier.isStatic(b.getModifiers());
				System.out.print(b.getName() + "(" + (isStatic ? "" : b.getDeclaringClass().getSimpleName()));
				Type[] datatypes = b.getGenericParameterTypes();
				int counter = 0;
				 for(Type c : datatypes){
//					Object c = new Object();
//					String name = c.getName(); 
					System.out.print(", " + "T" + counter);
					counter++; 
				 }
				System.out.print(") -> " + b.getGenericReturnType().toString());
			System.out.println();
			}
		
	}
	
	
	public static class A {
		void foo(int T1, double T2){}//constructor
		int bar(int T1, double T2, float T3){ return 1; }
		static double doo(){return 1;}
	}	
	
	public static void main(String args[]){
		A a = new A(); //instantiate a new object a of class A type
		displayMethodInfo(a);
	}
}