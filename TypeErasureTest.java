/* Example for type erasure of type arguments: written by Hyunyoung Lee */
import java.util.*;

class TypeErasureTest {
  private List<String> ls = new ArrayList<String>(); 
  private List<Integer> li = new ArrayList<Integer>();
  boolean checkObjectType() {
    return ls.getClass() == li.getClass();
  }

  public static void main(String[] args) {
    System.out.println((new TypeErasureTest()).checkObjectType()); // true
  }
}

/*
class Foo<T> {
  public void bar(T x) {
     T t = new T();                       // error
     if(x instanceof T) {}                // error
  }
  public static void static_bar(T t) {}   // error
  public static List<T> l;                // error
}
*/

