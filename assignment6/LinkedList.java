import java.util.*;

public class LinkedList<T> implements Iterable<T>{
	private Node<T> head;
	private Node<T> tail;
	
	public LinkedList(){
		head = null;
		tail = null;
	} // create an empty list
	
	public LinkedList(Iterable<T> iterable){
		Node<T> temp = head;
		for (T t : iterable){
			Node<T> nedo = new Node<T>(t, tail);
			if(head == null){
				head = nedo;
			}
			else{
				temp.next = nedo;
			}
		temp = nedo;
		}
	}
	@Override
	public Iterator<T> iterator(){
		return new NodeIterator<T>(head);
	}

	public LinkedList<T> reverse(){
		Node<T> ret = head, previous = null, current = null;
		while(ret != null){
			current = ret;
			ret = ret.next;
			current.next = previous;
			previous = current;
			head = current;
		}
		return this;
	}
	
	
	public String toString(){
		if(head == null)
			return "[]";
		String result = "";
		result += "[";
		if(head.next != null){
			result += head.v;
		}
		if(head != null){
			Node<T> o = head.next;
			while(o != null){
			result += ", " + o.v.toString();
			o = o.next;
			}	
		}
		result += "]";
		return result;
	}

}