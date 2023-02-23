/* An example to show that a static method is re-defined 
   by a derived class, not overridden: written by Hyunyoung Lee */
 
class Super {
  public static void mymessage() {
    System.out.println("I am static method in super class");
  }
  public static void message1() {
    System.out.println("Static method in super class");
  }
  public void message2()  {
    System.out.println("Non-static method in super class");
  }
}
 
class Sub extends Super {
  public static void message3() {
    System.out.println("I am static method in subclass");
  }
  public static void message1() {
    System.out.println("Static method in subclass");
  }
  public void message2() {
    System.out.println("Non-static method in subclass");
  }
}
 
public class StaticOver {
  public static void main(String[] args)  {
    System.out.println("Super object...");
    Super obj1 = new Sub();
    obj1.mymessage();  
    obj1.message1();  
    obj1.message2();     
    //obj1.message3(); // compile error 
    System.out.println("Sub object...");
    Sub obj2 = new Sub();
    obj2.mymessage();  
    obj2.message1();  
    obj2.message2();     
    obj2.message3();     
  }
}

