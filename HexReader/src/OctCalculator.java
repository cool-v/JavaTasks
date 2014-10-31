
public class OctCalculator implements NumericSystemConvertible
{
	public final static int OCT_TO_DECIMAL_MULTIPLIER = 8;

	@Override
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
			result = result * OCT_TO_DECIMAL_MULTIPLIER + getDecimalValue(stringNum.charAt(i));
		}
		
		if (isNegative)
		{
			result *= -1;
		}
		
		return result;
	}

	@Override
	public String convertFromDecimal(int decimalNum)
	{
		String octalNumber = "";

        //Works with negative numbers.
        boolean negativeCheck = false;
        if (decimalNum < 0)
        {
            negativeCheck = true;
            decimalNum *= -1;
        }

        while (decimalNum != 0)
        {
            int reminder = decimalNum % OCT_TO_DECIMAL_MULTIPLIER;
                octalNumber = reminder + octalNumber;
            decimalNum /= OCT_TO_DECIMAL_MULTIPLIER;
        }

        if (negativeCheck)
        {
            octalNumber = "-" + octalNumber;
        }
        
        return octalNumber.toString();
	}
	
	private int getDecimalValue(char octChar)
	{
		Character.toLowerCase(octChar);
		switch (octChar)
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
			default:
				throw new IllegalArgumentException("Input octal character is not valid.");
		}
	}
	
}
