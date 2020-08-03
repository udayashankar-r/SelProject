/*03/08/2020
=============
1. Write a Java Program to Find Quotient and Remainder using any two numbers.
2. Write a Java Program to Add two Complex numbers 
(Note : Complex numbers has Real and imaginary parts [eg: 6+26i])
*/

package seleniumworkout;

public class Day17_Javaprogram {
	
		double real,image;

		Day17_Javaprogram(double r, double i)
		{
			this.real=r;
			this.image=i;
		}
		
		public static Day17_Javaprogram sum (Day17_Javaprogram re, Day17_Javaprogram im)
		{
			Day17_Javaprogram temp=new Day17_Javaprogram(0,0);
			temp.real= re.real+im.real;
			temp.image=re.image+im.image;
			return temp;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Java Program to Find Quotient and Remainder using any two numbers.
		int num1=15;
		int num2=2;
		int quotient = num1 / num2;
		int remainder = num1 % num2;

		System.out.println("The Quotient of two numbers is:"+quotient);
		System.out.println("The Remainder of two numbers is:"+remainder);

		//Java Program to Add two Complex numbers 
		Day17_Javaprogram re = new Day17_Javaprogram(6, 26);
		Day17_Javaprogram im = new Day17_Javaprogram(9, 29);
		Day17_Javaprogram temp = sum(re,im);
		
		System.out.println("Sum of two complex numbers is: "+temp.real+" + "+temp.image +"i");
		
	}

}
