public abstract class Shape implements Comparable<Shape> {
	public abstract Point position();
	public abstract double area();
	public String label;
}