package seleniumworkout;

import java.util.Scanner;

public class Day24_LargestandSmallestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a range of number:");
		Scanner input = new Scanner(System.in);
		int range = input.nextInt();
		int[] arr = new int[range];		
		int temp;

		System.out.println("Enter "+arr.length+ " numbers: ");
		for(int i = 0 ;i<arr.length;i++) {
			
			arr[i]= input.nextInt();
		}
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<(arr.length);j++) {
			if(arr[i]>arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp; 
			}
		}
	}
		
		System.out.println("Smallest element of an array: "+arr[0] +"\nLargest element of an array: "+arr[(arr.length - 1)]) ;

	}

}
