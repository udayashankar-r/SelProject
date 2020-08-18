package seleniumworkout;

import java.util.Scanner;

public class Day23_SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a range of number");
		Scanner input = new Scanner(System.in);
		int range = input.nextInt();
		int[] sort = new int[range];
		int temp = 0;
		int min;
		
		System.out.println("Enter "+sort.length+ " numbers: ");
		for(int i = 0 ;i<sort.length;i++) {
			
			sort[i]= input.nextInt();
		}
		
		System.out.println("Before Sort: ");
		for(int i = 0 ;i<sort.length;i++) {
			
			System.out.print(sort[i]+ " ");
		}
		
		for(int i = 0 ;i<sort.length;i++) {
			min = i;
			for(int j = i+1;j<sort.length;j++) {
				if(sort[j] < sort[min]) {
					min = j;
				}
			}
				temp = sort[min];
				sort[min] = sort[i];
				sort[i] = temp;
			
		}
		
		System.out.println("\nAfter Sort: ");
		for(int k = 0 ; k < sort.length; k++) {
			System.out.println(sort[k]);
		}

	}

}
