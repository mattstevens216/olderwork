public class test{
	public static void main(String[] args){
		Point triangle = new Point( 1 , 15 );
		Point triangle1 = new Point( 2 , 1 );
		Point triangle2 = new Point( 3 , 10 );
		Triangle t = new Triangle(triangle, triangle1, triangle2);
		System.out.println(t);
	}
}