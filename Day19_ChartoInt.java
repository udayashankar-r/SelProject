/*05/08/2020
=============
1. Write a Java Program To Perform Arithmetic Operation(Sum of multiple numbers) using Method Overloading 

2. Write a Java Program to convert Char to int 

3. Write a Java Program to check given number is a Perfect square.
*/

package seleniumworkout;

public class Day19_ChartoInt {
	
	int add(int num1, int num2)
	{
		return num1+num2;		
	}
	
	double add(double num1, double num2)
	{
		return num1+num2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Day19_ChartoInt ct = new Day19_ChartoInt();
		System.out.println("Sum of two numbers is: "+ct.add(5, 3));
		System.out.println("Sum of two numbers is: "+ct.add(20.5, 20.7));
		ct.CharToInt();
		ct.PerfectSquare();
	}

	public void CharToInt()
	{
		char a ='x';
		int num = Character.getNumericValue(a);
		int num1 = a;
		System.out.println("Char to Int Conversion: "+num);
		System.out.println("Char to Int Conversion: "+num1);
//		System.out.println("The numeric value of the Character " + a + " is Integer " + num);
	}

	public void PerfectSquare()
	{
		int num = 100;
		double squareRoot = Math.sqrt(num); 
		double roundValue = Math.floor(squareRoot);
		if(squareRoot == roundValue)
			System.out.println("The number is a perfect square");
		else
			System.out.println("The number is not a perfect square");
	}
}
