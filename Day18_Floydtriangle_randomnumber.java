/*04/08/2020
=============
1.Write a Java Program to print Floyd's Triangle

2.Write a Java Program to generate Random Number
*/

package seleniumworkout;

import java.util.Random;
import java.util.Scanner;

public class Day18_Floydtriangle_randomnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Day18_Floydtriangle_randomnumber fr = new Day18_Floydtriangle_randomnumber();
		fr.FloydsTriangle();
		fr.FloydsTriangle1();
		fr.RandomNumber();
	}
	
	public void FloydsTriangle()
	{
		int num=1;
		
		for(int i=1 ; i<=7 ; i++)
		{
			num=1;
			for(int j=1 ; j<=i ; j++)
			{
				System.out.print(num);
				num++;
			}
			System.out.println();
		}
	}
	
	public void FloydsTriangle1()
	{
		int number=1, rows, i, j;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the number: ");		
		rows=input.nextInt();
		
		for (i = 1; i <= rows; i++) {
			for (j = 0; j <= i; j++) {
				System.out.print(number+" ");
				number++;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void RandomNumber()
	{
		Random numbers = new Random();
		System.out.println("Random Numbers");
		for(int i=1;i<=10;i++)
		{			
			System.out.println(numbers.nextInt(500));
		}
	}

}

