public class Point{
	public double x;
	public double y;
	public Point(){
		x = 0.0;
		y = 0.0;
	}
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	public boolean equalsP(Point c1){	
    	if (this.x == c1.x && this.y == c1.y)
    		return true;
    	else
    		return false;
    }
	public int hashCode(){
		return (int)(x*3.0 + y*4.0);
	}
	public double x(){ return x; }
	public double y(){ return y; }
	
	public String toString(){return (" ("+x+", "+y+")"); }
}