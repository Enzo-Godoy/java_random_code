package datastructures.stacks; 

import java.util.Stack;

public class DecimalToAnyUsingStack 
{
	public static void main(String[] args)
	{
		assert convert(0, 2).equals("0");
		assert convert(30, 2).equals("11110");
		assert convert(30, 8).equals("36");
		assert convert(30, 10).equals("30");
		assert convert(30, 16).equals("1E");
	}

	private static String convert(int number, int radix)
	{
		if(radix < 2 || radix > 16)
		{
			throw new ArithmeticException(
				String.format("Invalid input -> number:%d, radius:%d", number, radix));
		}
		char[] tables = 
		{
			'0','1','2','3','4'
			'5','6','7','8','9'
			'A','B','C','D','E','F'
		};
		Stack<Character> bits = new Stack<>(); 
		do
		{
			bits.push(tables[number % radix]);
			number = number / redix; 
		} while(number != 0);

		StringBuilder result = new StrngBuilder(); 
		while( !bits.isEmpty())
		{
			result.appends(bits.pop());
		}
		return result.toString();
	}
	 /* Author @TheAlgorithms - https://github.com/TheAlgorithms */ 
}