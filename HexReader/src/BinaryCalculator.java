public class BinaryCalculator implements NumericSystemConvertible
{
	public final static int BINARY_TO_DECIMAL_MULTIPLIER = 2;

	@Override
	public int convertToDecimal(String stringNum)
	{
		boolean isNegative = false;
		if (stringNum.startsWith("-"))
		{
			isNegative = true;
			stringNum.substring(1);
		}

		int number = 0;
		for (int i = 0; i < stringNum.length(); i++)
		{
			number = number * BINARY_TO_DECIMAL_MULTIPLIER + getDecimalValue(stringNum.charAt(i));
		}
		
		if (isNegative)
		{
			number *= -1;
		}
		
		return number;
	}

	@Override
	public String convertFromDecimal(int decimalNum)
	{
        String binaryNumber = "";

        //Works with negative numbers.
        boolean negativeCheck = false;
        if (decimalNum < 0)
        {
            negativeCheck = true;
            decimalNum *= -1;
        }
        
        while (decimalNum != 0)
        {
            int reminder = decimalNum % BINARY_TO_DECIMAL_MULTIPLIER;
            binaryNumber = reminder + binaryNumber;
            decimalNum /= BINARY_TO_DECIMAL_MULTIPLIER;
        }
        
        if (negativeCheck)
        {
            binaryNumber = "-" + binaryNumber;
        }
        
        return binaryNumber;
	}

	private int getDecimalValue(char binaryChar)
	{
		switch (binaryChar)
		{
			case '0':
				return 0;
			case '1':
				return 1;
			default:
				throw new IllegalArgumentException("Input binary character is not valid.");
		}
	}

}
