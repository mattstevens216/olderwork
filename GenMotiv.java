/* Example motivating generics: written by Hyunyoung Lee */
import java.util.*;

class GenMotiv {
  public static void main(String[] args) {
    List l = new LinkedList();
    l.add(new Integer(0));
    Integer x = l.iterator().next();
  }
}

