import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

//		System.out.println("Enter hexadecimal number: ");
//		String hexNumber = input.nextLine();
//		int hexToDecimalResult = new HexCalculator().convertToDecimal(hexNumber);
//		System.out.println(hexNumber + " = " + hexToDecimalResult);
		
		System.out.println("Enter binary number: ");
		String binaryNumber = input.nextLine();
		int binaryToDecimalResult = new BinaryCalculator().convertToDecimal(binaryNumber);
		System.out.println(binaryNumber + " = " + binaryToDecimalResult);
		
		input.close();
	}

}
