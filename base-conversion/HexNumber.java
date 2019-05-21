import java.math.BigInteger;

public class HexNumber extends Number
{
    @Override
    public String toString()
    {
        return "0x" + data.toString(16).toUpperCase();
    }

    public static boolean isValid(String userString)
    {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        if (!userString.startsWith("0x"))
            return false;

        for (int i = 2; i < userString.length(); i++)
        {
            char checkedChar = userString.charAt(i);
            boolean validChar = false;

            for (char c : hexDigits)
            {
                if (checkedChar == c)
                {
                    validChar = true;
                    break;
                }
            }

            if (!validChar)
            {
                System.out.printf("\n%sThis input contains a digit that is invalid in hexadecimal: %c%s",
                        ANSI_RED, checkedChar, ANSI_RESET);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        super.data = new BigInteger(userString.substring(2), 16);
    }
}
