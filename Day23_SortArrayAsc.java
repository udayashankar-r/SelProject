package seleniumworkout;

import java.util.Scanner;

public class Day23_SortArrayAsc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a range of number");
		Scanner input = new Scanner(System.in);
		int range = input.nextInt();
		int[] sort = new int[range];
		int temp;
		System.out.println("Enter "+sort.length+ " numbers: ");
		for(int i = 0 ;i<sort.length;i++) {
			
			sort[i]= input.nextInt();
		}
		
		for(int i=0;i<sort.length;i++){
			for(int j=i+1;j<(sort.length);j++) {
			if(sort[i]>sort[j]) {
				temp = sort[i];
				sort[i] = sort[j];
				sort[j] = temp; 
			}
		}
	}
		System.out.println("Ascending sort of given numbers: ");	
		for(int i=0;i<sort.length;i++) {
			System.out.println(sort[i]);
			
		}

	}

}

