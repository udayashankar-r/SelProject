package seleniumworkout;

public class Day24_AddElementsOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[]{ 10,26,3,4,5,6,72,8,9,10 }; 
		int total=0;
		
		for (int i = 0; i < arr.length; i++) {
//			System.out.println("Element at index " + i + " : "+ arr[i]);
			total = total + arr[i];
		 }
		 System.out.println("The Addition of Elements in Array:"+total);

	}

}
