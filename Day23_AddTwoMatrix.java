package seleniumworkout;

import java.util.Scanner;

public class Day23_AddTwoMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter row number");
		int rows = input.nextInt();
		System.out.println("Enter column number");
		int cols = input.nextInt();
		int[][] a = new int[rows][cols];
		int[][] b = new int[rows][cols];
		int[][] c = new int[rows][cols];
		System.out.println("Enter one "+rows+"x"+cols+" matrix: ");
		for(int i=0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				a[i][j]=input.nextInt();
			}
		}
		System.out.println("Enter another "+rows+"x"+cols+" matrix: ");
		for(int i=0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				b[i][j]=input.nextInt();
			}
		}
		
		for(int i=0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				c[i][j]=a[i][j] + b[i][j];
			}
		}
		System.out.println("Result of addition of two "+rows+"x"+cols+" matrix: ");
		for(int i=0;i<rows;i++) {
			for(int j = 0;j<cols;j++) {
				System.out.print(c[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}


