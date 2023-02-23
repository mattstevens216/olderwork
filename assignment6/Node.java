import java.util.Iterator;
import java.util.function.Consumer;

public final class Node<T> implements Iterable<T>{
	public final T v;
	
	public Node<T> next;
	
	public Node (T val, Node<T> link) {
		v = val;
		next = link;
	}
	
	@Override
	public Iterator<T> iterator(){
		return new NodeIterator<T>(this);
	}
	
	public void forEach(Consumer <? super T> o){
		Iterator <T> iterator = this.iterator();
		while(iterator.hasNext()){
			o.accept(iterator.next());
		}
	}
}
