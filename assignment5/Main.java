import java.util.*;
import java.awt.List;
import java.util.Random;



class Main{
	
	public static int arraySize = 0, t_cnt = 0,
					  r_cnt = 0, s_cnt = 0, c_cnt = 0, l_cnt = 0;
					  
	public static Shape[] randomShapes( int arraySize ){
		Shape[] shapes = new Shape[arraySize];
	int m = 0;
	for(int i = 0; i < arraySize; ++i){
		m = (int)(Math.random() * 5);
		
		switch(m){
			case 0:
					Point trianglePos = new Point(Math.random() * 800, Math.random() * 800);
					Point trianglePos1 = new Point(Math.random()* 800, Math.random() * 800);
					Point trianglePos2 = new Point(Math.random()* 800, Math.random() * 800);
					shapes[i] = new Triangle(trianglePos, trianglePos1, trianglePos2);
					shapes[i].label = ("Triangle" + ++t_cnt);
					System.out.println(shapes[i]);
					break;
			case 1:
					Point rectanglePos = new Point(Math.random() * 800, Math.random() * 800);
					Point end = new Point(Math.random()*800, Math.random()*800);
					shapes[i] = new Rectangle(rectanglePos, end);
					shapes[i].label = ("Rectangle" + ++r_cnt);
					System.out.println(shapes[i]);
					break;
			case 2:
					Point circlePos = new Point(Math.random() * 800, Math.random() * 800);
					double radius = Math.random()*100;
					shapes[i] = new Circle(circlePos, radius);
					shapes[i].label = ("Circle" + ++c_cnt);
					System.out.println(shapes[i]);
					break;
			case 3:
					Point linePos = new Point(Math.random() * 800, Math.random() * 800);
					Point destination = new Point(Math.random()*800, Math.random()*800);
					shapes[i] = new LineSegment(linePos, destination);
					shapes[i].label = ("LineSegment" + ++l_cnt);
					System.out.println(shapes[i]);
					break;
			case 4:
	
					Point squarePos = new Point(Math.random() * 800, Math.random() * 800);
					double width1 = Math.random()*100;
					shapes[i] = new Square(squarePos, width1);
					shapes[i].label = ("Square" + ++s_cnt);
					System.out.println(shapes[i]);
					break;
		}
	}
	return shapes;
	
	}//do last
 //first finish reads in main, then do randomShapes then do equals


	public static Shape[] input(String s){
		System.out.println("Shape string" + s);
		Scanner parse = new Scanner(s);
		String schar = parse.findInLine(";");
		while(schar != null){
			arraySize++;
			schar = parse.findInLine(";");
			//System.out.println("Stuff added!");
		}
		Shape[] shapes = new Shape[arraySize];
		System.out.println(arraySize + " shapes");
		
		parse = new Scanner(s);
		parse.useDelimiter(";");
		int i = 0;
		
		while(parse.hasNext()){
			String shape = parse.next();
			Scanner scan = new Scanner(shape);
			String type = scan.next();
			switch(type){
				case "t":

						scan.next();
						double x3 = scan.nextDouble();
						scan.next();
						double y3 = scan.nextDouble();
						scan.next();//)
						scan.next();//(
						double z3 = scan.nextDouble();
						scan.next();
						double w3 = scan.nextDouble();
						scan.next();
						scan.next();
						double o3 = scan.nextDouble();
						scan.next();
						double l3 = scan.nextDouble();
						
						//eat last parenthesis
						shapes[i] = new Triangle(new Point(x3, y3), new Point(z3, w3), new Point(o3, l3));
						shapes[i].label = ("Triangle" + ++t_cnt);
						System.out.println(shapes[i]);
						break;
				case "r":

						scan.next();
						double x2 = scan.nextDouble();
						scan.next();
						double y2 = scan.nextDouble();
						scan.next();
						scan.next();
						double z2 = scan.nextDouble();
						scan.next();
						double w2 = scan.nextDouble();
						//eat last parenthesis
						shapes[i] = new Rectangle(new Point(x2, y2), new Point(z2, w2));
						shapes[i].label = ("Rectangle" + ++r_cnt);
						System.out.println(shapes[i]);
						break;
				case "s":

						scan.next();
						double x1 = scan.nextDouble();
						scan.next();
						double y1 = scan.nextDouble();
						scan.next();
						double r1 = scan.nextDouble();
						//eat last parenthesis
						shapes[i] = new Square(new Point(x1, y1), r1);
						shapes[i].label = ("Square" + ++s_cnt);
						System.out.println(shapes[i]);
						break;
				case "c":

						scan.next();
						double x = scan.nextDouble();
						scan.next();
						double y = scan.nextDouble();
						scan.next();
						double r = scan.nextDouble();
						//eat last parenthesis
						shapes[i] = new Circle(new Point(x, y), r);
						shapes[i].label = ("Circle" + ++c_cnt);
						System.out.println(shapes[i]);

						break;
				case "l":

						scan.next();
						double x4 = scan.nextDouble();
						scan.next();
						double y4 = scan.nextDouble();
						scan.next();
						scan.next();
						double z4 = scan.nextDouble();
						scan.next();
						double w4 = scan.nextDouble();
						//eat last parenthesis
						shapes[i] = new LineSegment(new Point(x4, y4), new Point(z4, w4));
						shapes[i].label = ("LineSegment" + ++l_cnt);
						System.out.println(shapes[i]);
						break;
			
			}
			i++;
		}
		int total = l_cnt + t_cnt + s_cnt + c_cnt + r_cnt;
		System.out.println("Total shapes: " + total + " shapes");
		return shapes;
		}
	
		public static void main(String args[]){
			double area = 0; //initialize
			
			Shape[] shapes = new Shape[arraySize];
			if (args[0].equals("S")){
				//System.out.println("The magic number is " + args[1]);
				//input( String.join(";", args) );
				shapes = input(args[1]);
				//shapes = new Shape[arraySize];
/* 				for(int i = 0; i<shapes.length; ++i){
				String [] result = args[1].split(";"); //input vector will be of different size than result string
				
					for (int k = 0; k< result.length; ++k){//System.out.println(result[k]);
/* 						if (result[k].equals("c") ){//( (result.length-1) == 3) ){ //initialize circle with points
							Point circlePos = new Point(Double.parseDouble (result[1]), (Double.parseDouble(result[2])));//using Double.parseDouble to convert string into a double
							double radius = Double.parseDouble(result[3]); // radius is last element of string
							shapes[i] = new Circle(circlePos, radius);//put circle shape into the shape array
						} */
/* 						else if (result[k].equals("t")) {//&& ( (result.length-1) == 5) ){ //initialize circle with points
							Point trianglePos = new Point(Double.parseDouble (result[1]), Double.parseDouble(result[2]));//using Double.parseDouble to convert string of doubles into a point
							Point trianglePos1 = new Point(Double.parseDouble(result[3]), Double.parseDouble(result[4]));					
							Point trianglePos2 = new Point(Double.parseDouble(result[5]), Double.parseDouble(result[6]));					
							shapes[i] = new Triangle(trianglePos, trianglePos1, trianglePos2);
						}
						
						else if (result[k].equals("r") ){//&& ( (result.length-1) == 4) ){ //initialize circle with points
							Point rectanglePos = new Point(Double.parseDouble (result[1]), Double.parseDouble(result[2]));//using Double.parseDouble to convert string into a double
							Point end = new Point(Double.parseDouble(result[3]), Double.parseDouble(result[4]));
							shapes[i] = new Rectangle(rectanglePos, end);//put circle shape into the shape array
						}
						else if (result[k].equals("s") ){//&& ( (result.length-1) == 3) ){ //initialize circle with points
							Point squarePos = new Point(Double.parseDouble (result[1]), Double.parseDouble(result[2]));//using Double.parseDouble to convert string into a double
							double width1 = Double.parseDouble(result[3]); // radius is last element of string
							shapes[i] = new Square(squarePos, width1);//put circle shape into the shape array
						}
						else if (result[k].equals("l")){// && ( (result.length-1) == 3) ){ //initialize circle with points
							Point linePos = new Point(Double.parseDouble(result[1]), Double.parseDouble(result[2]));//using Double.parseDouble to convert string into a double
							Point destination = new Point(Double.parseDouble(result[3]), Double.parseDouble(result[4])); // radius is last element of string
							shapes[i] = new LineSegment(linePos, destination);//put circle shape into the shape array
						}
						else break;
					}
				} */
				System.out.println("Shapes size is " + shapes.length);

			}
			else if (args[0].equals("R")){
				shapes = new Shape[Integer.parseInt(args[1])];
				arraySize = Integer.parseInt( args[1] ); //arraysize of following integer
				shapes = randomShapes( arraySize );
				
			}

			Triangle asd = new Triangle( new Point( 1 , 5 ), new Point( 2 , 1 ), new Point( 5 , 15 ));
			Triangle asd1 = new Triangle( new Point( 1 , 5 ), new Point( 2 , 1 ), new Point( 5 , 15 ));
			System.out.println(asd.equals(asd1));
			Arrays.sort(shapes);
			TotalAreaCalculator calc = new TotalAreaCalculator();
			System.out.println("Total Area: "+ calc.calculate( shapes, arraySize ));
			for(int i = 0; i < shapes.length; i++){
				System.out.println("Sorted: " + shapes[i]);
				System.out.println("Area: " + shapes[i].area());
			}
			
		}
	 


	 
	 
	 
	 
}