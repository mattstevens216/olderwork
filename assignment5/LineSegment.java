public class LineSegment extends Shape{
	private Point destination;
	private Point position;

	public LineSegment(Point position, Point destination){
	//super(position);
	this.position = position;
	this.destination = destination;
	}
	public boolean equals(Shape a){
		if (( (this.getClass().getSimpleName()).equals((a.getClass().getSimpleName()))) && (this.position().equalsP(a.position())))
		{
			
			LineSegment newLine = (LineSegment) a; 
			double side1 = Math.abs(destination.x - position.x);
	
			
			double second = Math.abs(newLine.destination.x - newLine.position.x);

			
			if(side1 == second)
				return true;
		}
	return false;
	}
	@Override
	public double area(){
	return 0;
	}
	@Override
	public int hashCode(){
		return (int)((position.x + position.y)*3.0+(destination.x + destination.y)*4.0);
	}
	@Override
		public Point position(){
		return position;
	}
	@Override
		public String toString(){
		return label + " <( " + position + " , " + destination + " )> ";
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