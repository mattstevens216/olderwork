import java.util.Arrays;

public class Triangle extends Shape{
	private Point position2;
	private Point position3;
	private Point position;
	

	public Triangle(Point position, Point position2, Point position3){
		this.position = position;
		this.position2 = position2;
		this.position3 = position3;
	}
	public boolean equals(Shape a){
		if(!(a instanceof Triangle)){
			return false;
		}
		Triangle newtriangle = (Triangle) a;
		if (position.equals(newtriangle.position))
		{	
			if(position2.equals(newtriangle.position2)){
				if(position3.equals(newtriangle.position3)){
					return true;
				}
				return false;
			}
			if(position2.equals(newtriangle.position3)){
				if(position3.equals(newtriangle.position2)){
					return true;
				}
				return false;
			}
			return false;
			/* Math.sqrt( Math.pow((position2.x - position.x),2.0) + Math.pow((position2.y - position.y),2.0) );
			double side2 = Math.sqrt( Math.pow((position3.x - position2.x),2.0) + Math.pow((position3.y - position2.y),2.0) );
			double side3 = Math.sqrt( Math.pow((position3.x - position.x),2.0) + Math.pow((position.y - position.y),2.0) );
			double [] arrayOfSides = {side1, side2, side3}; */
			
			/* Arrays.sort(arrayOfSides); */
			
			/* double second = Math.sqrt( Math.pow((newtriangle.position2.x - newtriangle.position.x),2.0) + Math.pow((newtriangle.position2.y - newtriangle.position.y),2.0) );
			double second2 = Math.sqrt( Math.pow((newtriangle.position3.x - newtriangle.position2.x),2.0) + Math.pow((newtriangle.position3.y - newtriangle.position2.y),2.0) );
			double second3 = Math.sqrt( Math.pow((newtriangle.position3.x - newtriangle.position.x),2.0) + Math.pow((newtriangle.position3.y - newtriangle.position.y),2.0) );
			double [] arraySecondSides = {second, second2, second3};
			
			Arrays.sort(arraySecondSides); */
			
			/* if(Arrays.equals(arrayOfSides, arraySecondSides))
				return true; */
		}
	return false;
	}
	@Override
	public int hashCode(){
		return (int)((position.x + position.y)*3.0+(position2.x + position2.y)*4.0+(position3.x + position3.y)*6.0);
	}
	
	@Override
	public double area(){
		// double rea = (a + b + c) / 2; //perimeter div 2
		// return Math.sqrt(rea * (rea - a) * (rea - b) * (rea - c)); //heron's area formula using addition of sides (perimeter)
		double calcAreaTri =  Math.abs( ( ( position.x * (position2.y-position3.y) ) + (position2.x * (position3.y-position.y)) + (position3.x * (position.y - position2.y))) / 2 );
		return calcAreaTri;
	}
	@Override
		public Point position(){
		return position;
	}
	@Override
	public String toString(){
		return label + " <( " + position  + " , " + position2 + " , " + position3 + " )> ";
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