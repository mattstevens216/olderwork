import java.util.*;

class Delicious {
	public String toString(){
		return "Delicious";
	}
}

class Grocery extends Delicious {
	public String toString(){
		return "Grocery";
	}
}

class Vegetables extends Grocery {public String toString() { return "Vegetables: ";}}
class Fruits extends Grocery {public String toString() { return "Fruits: ";}}
class Tomato extends Vegetables {public String toString() { return "Tomato";}}
class Celery extends Vegetables {public String toString() { return "Celery ";}}
class Apple extends Fruits {public String toString() { return "Apple";}}
class Peach extends Fruits {public String toString() { return "Peach";}}
 
class Test3{
	static int stockCounter = 1;
	
	static <T> void print(Collection<T> c){
		System.out.println("Stock: " + ++stockCounter);
		for(T e : c){
			System.out.println(e);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Shop<Grocery> food = new Shop<Grocery>();
		Shop<Vegetables> food2 = new Shop<Vegetables>();
		
		Set<Delicious> setDelicious = new HashSet<Delicious>();
		Set<Grocery>  setGrocery = new HashSet<Grocery>();
		
		List<Vegetables> listVegetables = new ArrayList<Vegetables>();
		Queue<Fruits> queueFruits = new ArrayDeque<Fruits>();
		Grocery groceryItem = new Grocery();
		
		listVegetables.add(new Vegetables());
		listVegetables.add(new Tomato());
		listVegetables.add(new Celery());
		listVegetables.add(new Tomato());
		
		print(listVegetables);
		food.sell(listVegetables);
		food.print();
		
		queueFruits.add(new Fruits());
		queueFruits.add(new Apple());
		queueFruits.add(new Peach());
		queueFruits.add(new Apple());
	
		print(queueFruits);
		food.sell(queueFruits);
		food.print();
	}




}