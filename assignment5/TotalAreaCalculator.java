public class TotalAreaCalculator{
public static double calculate(Shape[] shapes, int arraySize){
		double area1 = 0;
		for(int i = 0; i < arraySize; i++){
			area1 += shapes[i].area();
		}
		return area1;
	}

}