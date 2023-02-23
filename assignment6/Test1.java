import java.util.*;

public class Test1<T>{
	
	
	public static void main(String[] args){
			List<Node<Integer>> l = new ArrayList<Node<Integer>>();
			Node<Integer> a = new Node<Integer>(1, null);
			Node<Integer> b = new Node<Integer>(2, null);
			Node<Integer> c = new Node<Integer>(3, null);
			Node<Integer> d = new Node<Integer>(4, null);
			Node<Integer> e = new Node<Integer>(5, null);
			l.add(a);
			l.add(b);
			l.add(c);
			l.add(d);
			l.add(e);
			print(l);
			System.out.println(sum(l));
			
	}

	public static int sum(List<Node<Integer>> list){
		int sum = 0;
		for(Node<Integer> e : list){
			sum += e.v;
		}
	return sum;
	}

	public static void print(List<Node<Integer>> list){
		for(Node<Integer> e : list) {
				System.out.print(e.v + " ");
		}
		System.out.println();
	}
}