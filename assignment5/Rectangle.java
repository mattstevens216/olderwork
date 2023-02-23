public class Rectangle extends Shape{
	public Point end;
	private Point position;
	
	public Rectangle(Point position, Point end){
		//super(position);
		this.position = position;
		this.end = end;
	}
	
	
	
	@Override
	public double area(){
		double width1 = Math.abs(end.x - position.x);
		double length1 = Math.abs(end.y - position.y);
		return width1 * length1;
	}
	@Override
	public Point position(){
		return position;
	}
	@Override
	public int hashCode(){
		return (int)((position.x + position.y)*3.0+(end.x + end.y)*4.0);
	}
	@Override
	public String toString(){
		return label + " <( " + position().x + " , " + position().y + " )> ";
	}
	public int compareTo(Shape e) {
		if(this.area() < e.area())
			return -1;
		else if (this.area() > e.area())
			return 1;
		else
			return 0;
	}
} //include readme file