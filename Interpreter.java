
import java.util.Scanner;


public class Interpreter {
	public static String interpret(String input)
	{
		int step = 0;
		int operation = 0;
		float x = 0;
		float y = 0;
		if (input.equalsIgnoreCase("quit"))
		{
			return "quit";
		}
		for (int i = 0; i < input.length(); i++)
		{
			if (step == 0) //x before point
			{
				if (Character.isDigit(input.charAt(i)))
				{
					while (i < input.length() && Character.isDigit(input.charAt(i)))
					{
						x = x * 10 + Character.getNumericValue(input.charAt(i));
						if (((i + 1) < input.length()) && Character.isDigit(input.charAt(i + 1))) {
							i++;
						} else {
							break;
						}
					}
					step++;
				}
				else
				{
					return "Invalid number.";
				}
			}
			else if (step == 1) //x point
			{
				if (input.charAt(i) == '.')
				{
					step++;
				}
				else if (input.charAt(i) == ' ')
				{
					step = 3;
				}
				else
				{
					return "Invalid number.";
				}
			}
			else if (step == 2) //x after point
			{
				if (Character.isDigit(input.charAt(i)))
				{
					int k = i;
					while (i < input.length() && Character.isDigit(input.charAt(i)))
					{
						int next = Character.getNumericValue(input.charAt(i));
						x += next * Math.pow(10, -(i - (k - 1)));
						i++;
					}
					step++;
				}
				else
				{
					return "Invalid number.";
				}
			}
			else if (step == 3) //space, operator
			{
				if (input.charAt(i) == ' ')
				{
					while (i < input.length() && input.charAt(i) == ' ')
					{
						i++;
					}
				}
				if (input.charAt(i) == '+')
				{
					operation = 1;
					step++;
				}
				else if (input.charAt(i) == '-')
				{
					operation = 2;
					step++;
				}
				else if (input.charAt(i) == '*')
				{
					operation = 3;
					step++;
				}
				else if (input.charAt(i) == '/')
				{
					operation = 4;
					step++;
				}
				else
				{
					return "Invalid operation.";
				}
			}
			else if (step == 4) //space, y before point
			{
				if (input.charAt(i) == ' ')
				{
					while (i < input.length() && input.charAt(i) == ' ')
					{
						i++;
					}
				}
				if (Character.isDigit(input.charAt(i)))
				{
					while (i < input.length() && Character.isDigit(input.charAt(i)))
					{
						y = y * 10 + Character.getNumericValue(input.charAt(i));
						if (((i + 1) < input.length()) && Character.isDigit(input.charAt(i + 1))) {
							i++;
						} else {
							break;
						}
					}
					step++;
					if (i == input.length() - 1)
					{
						step = 7;
					}
				}
				else
				{
					return "Invalid number.";
				}
			}
			else if (step == 5) //y point
			{
				if (input.charAt(i) == '.')
				{
					step++;
				}
				else
				{
					return "Invalid number.";
				}
			}
			else if (step == 6) //y after point
			{
				if (Character.isDigit(input.charAt(i)))
				{
					int k = i;
					while (i < input.length() && Character.isDigit(input.charAt(i)))
					{
						int next = Character.getNumericValue(input.charAt(i));
						y += next * Math.pow(10, -(i - (k - 1)));
						i++;
					}
					step++;
				}
				else
				{
					return "Invalid number.";
				}
			}
			if (step == 7) //compute
			{
				if (operation == 1)
				{
					return Float.toString(x+y);
				}
				else if (operation == 2)
				{
					return Float.toString(x-y);
				}
				else if (operation == 3)
				{
					return Float.toString(x*y);
				}
				else if (operation == 4)
				{
					return Float.toString(x/y);
				}
				else
				{
					return "Internal error.";
				}
			}
		}
		return "Internal error.";
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("Input a number, an operator, and another number separated by spaces.\n");
		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			System.out.println("\n->");
			String input = scan.nextLine();
			String output = interpret(input);
			
			if (output.equals("quit"))
			{
				System.out.println("Bye.");
				break;
			}
			else
			{
				System.out.println(output);
			}
		}
		scan.close();
	}
}
