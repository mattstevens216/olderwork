import java.util.Iterator;

public class NodeIterator<T> implements Iterator<T>{

	Node<? super T> x;
	
	public NodeIterator(Node<? super T> n){
		x = n;
	}
	
	public T next(){
		T node = (T) (x.next.v);
		x = x.next;
		return node;
	}

	public boolean hasNext(){
		if (x.next == null)
			return false;
		return true;
	}
}
