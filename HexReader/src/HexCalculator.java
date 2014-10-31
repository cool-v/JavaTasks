public class HexCalculator implements NumericSystemConvertible
{
	final static int HEX_TO_DECIMAL_MULTIPLIER = 16;

	public int convertToDecimal(String stringNum)
	{
		boolean isNegative = false;
		if (stringNum.startsWith("-"))
		{
			isNegative = true;
			stringNum.substring(1);
		}
		
		int result = 0;
		for (int i = 0; i < stringNum.length(); i++)
		{
			result = result * HEX_TO_DECIMAL_MULTIPLIER + getDecimalValue(stringNum.charAt(i));
		}
		
		if (isNegative)
		{
			result *= -1;
		}
		
		return result;
	}

	public String convertFromDecimal(int decimalNum)
	{
        StringBuilder hexadecimalNumber = new StringBuilder();

        //Works with negative numbers.
        boolean negativeCheck = false;
        if (decimalNum < 0)
        {
            negativeCheck = true;
            decimalNum *= -1;
        }

        while (decimalNum != 0)
        {
            int reminder = decimalNum % HEX_TO_DECIMAL_MULTIPLIER;
            if (reminder<10)
            {
                hexadecimalNumber.insert(0, reminder);
            }
            else
            {
                hexadecimalNumber.insert(0, (char)(reminder + 55));
            }
            decimalNum /= HEX_TO_DECIMAL_MULTIPLIER;
        }

        if (negativeCheck)
        {
            hexadecimalNumber.insert(0, '-');
        }
        
        return hexadecimalNumber.toString();
	}
	
	private int getDecimalValue(char hexChar)
	{
		Character.toLowerCase(hexChar);
		switch (hexChar)
		{
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'a':
				return 10;
			case 'b':
				return 11;
			case 'c':
				return 12;
			case 'd':
				return 13;
			case 'e':
				return 14;
			case 'f':
				return 15;
			default:
				throw new IllegalArgumentException("Input hex character is not valid.");
		}
	}
}
