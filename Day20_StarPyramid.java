package seleniumworkout;

import java.util.Scanner;

public class Day20_StarPyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the range of number to pyramid of stars: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i = 0;i<=n;i++) {
			 for(int count = n; count >= i; count--)
	         {
	             System.out.print(" ");
	         }
			for(int j=0;j<i;j++) {
			 
			 System.out.format("*");
			 System.out.print(" ");	
			}
			System.out.println();			
		}

	}

}

