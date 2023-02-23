/* Test for covariance and contravariance. Written by Hyunyoung Lee */
import java.util.*;

public class VariantTest {

  public static void main(String[] args) {
    String[] stra = new String[1]; // stra is array of String with one element
    stra[0] = "Hi";
 
    Object[] obja = stra; // obja is array of Object
 
    obja[0] = 1; // Attemp to assign an Integer to Object, that is indeed 
                 // a String, so will throw java.lang.ArrayStoreException

    List<String> ls = new ArrayList<String>(); // ok
    List<Object> lo = new ArrayList<Object>(); // = ls; 
                                               // would cause Compile Error: 
                                               //       incompatible types 

    lo.add(new Object()); // ok
    ls.add(new Object()); // Compile Error: cannot find "add" method that
                          // accepts Object since the element is of type String 
  }
}
