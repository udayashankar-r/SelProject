package seleniumworkout;

import java.util.Scanner;

public class Day22_ReverseNumberUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("Enter a number: ");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		System.out.println("Reverse of Input: ");
		reverseMethod(n);

	}

	private static void reverseMethod(int n) {

		if (n<10) {
			System.out.println(n);
			return;
		} 
		else {
			System.out.print(n%10);
			reverseMethod(n/10);
		}
	}
}
