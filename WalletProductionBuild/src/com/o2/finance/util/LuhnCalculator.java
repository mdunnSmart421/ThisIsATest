package com.o2.finance.util;

import java.math.BigInteger;

public class LuhnCalculator
{
    public static String generateCheckDigit(BigInteger s)
    {
        int mod   = doLuhn(s.toString(), true) % 10;
        int digit = mod > 0 ? 10 - mod : mod;
        return "" + digit;
    }

    private static int doLuhn(String s, boolean evenPosition)
    {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(s.substring(i, i + 1));
            if (evenPosition)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            evenPosition = !evenPosition;
        }

        return sum;
    }
}
