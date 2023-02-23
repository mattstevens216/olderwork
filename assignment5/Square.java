public class Square extends Shape {
	private double width;
	private Point position;

	public Square(Point position, double width){
		super();
	//super(position);
	this.position = position;
	this.width = width;
	}
	
	@Override
	public double area(){
	return width * width;
	}
	@Override
		public Point position(){
		return position;
	}
	@Override
	public int hashCode(){
		return (int)((position.x + position.y)*3.0+(width)*4.0);
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
}