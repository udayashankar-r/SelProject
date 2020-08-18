package seleniumworkout;

import java.util.Scanner;

public class Day22_LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n,search,i;
		boolean bool = false;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		n = s.nextInt();
		int [] arr = new int[n];
		
		System.out.println("Enter the values: ");
		for (i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter value to be searched: ");
		search = s.nextInt();
		
		for (i = 0;  i < arr.length; i++) {
			if (arr[i] == search) {
				bool = true;
			}
		}
		
		if (bool)
			System.out.println("Value is present in the list");
		else 
			System.out.println("Value is not present in the list");

	}

}
