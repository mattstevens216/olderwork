class Circle extends Shape {
	private double radius;
	private final double pi = Math.PI;
	private Point position;
	
	public Circle(Point position, double radius){
		super();
		this.radius = radius;
		this.position = position;
	}
	
	@Override
		public double area(){
		return pi * radius * radius;
	}
	@Override
		public Point position(){
		return position;
	}
	@Override
	public int hashCode(){
		return (int)((position.x + position.y)*3.0+(radius)*4.0);
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
