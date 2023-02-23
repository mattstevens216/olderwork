/* Example using wildcards: written by Hyunyoung Lee */
import static java.lang.System.out;
import java.util.*;

class WildcardsTest {
  public static <T> T choose (T a, T b) {
    out.println("Choose a!");
    return a;
  }
  
  public static Set<?> chooseA (Set<?> a, List<?> b) {
    out.println("Choose a!");
    return a;
  }

  public static List<?> chooseB (Set<?> a, List<?> b) {
    out.println("Choose b!");
    return b;
  }

  public static <T> void foo(Set<T> s) {
    for (T e : s)
    out.println(e);
  }

  public static <T> void main(String[] args) {
    Set<Integer> intSet = new TreeSet<Integer>();
    Collection<Integer> intCollection = intSet;
    List<String> stringList = new ArrayList<String>();
    intCollection.add(3);
    intSet.add(5);
    intSet.add(7);
    stringList.add("Hi ");
    stringList.add("There ");
    Collection<?> intSet1 = choose(intCollection, intSet); 
    Set<?> intSet2 = chooseA(intSet, stringList);
    Collection<?> someCollection = chooseB(intSet, stringList);
    for (Object e : intSet1) out.print(e);
    out.println();
    for (Object e : intSet2) out.print(e);
    out.println();
    for (Object e : someCollection) out.print(e);
    out.println();
    foo(intSet2);
  }
}


