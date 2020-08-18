package seleniumworkout;

import java.util.Scanner;

public class Day20_LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year;
	    System.out.println("Enter an Year: ");
	    Scanner sc = new Scanner(System.in);
	    year = sc.nextInt();

	    if (year % 4 == 0)
	      System.out.println(year+" is a leap year");
	    else
	      System.out.println(year+" is not a leap year");

	}

}
