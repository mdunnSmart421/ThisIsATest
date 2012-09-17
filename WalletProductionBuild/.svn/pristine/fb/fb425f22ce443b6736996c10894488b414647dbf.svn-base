package com.o2.finance.util;

import java.math.BigInteger;

/**
 * @author SWatson
 * 
 */
public class BaseConverter
{
    private static final String baseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String toBase62(BigInteger decimalNumber)
    {
        return fromDecimalToOtherBase(new BigInteger("62"), decimalNumber);
    }

    public static String toBase36(BigInteger decimalNumber)
    {
        return fromDecimalToOtherBase(new BigInteger("36"), decimalNumber);
    }

    public static String toBase16(BigInteger decimalNumber)
    {
        return fromDecimalToOtherBase(new BigInteger("16"), decimalNumber);
    }

    public static String toBase8(BigInteger decimalNumber)
    {
        return fromDecimalToOtherBase(new BigInteger("8"), decimalNumber);
    }

    public static String toBase2(BigInteger decimalNumber)
    {
        return fromDecimalToOtherBase(new BigInteger("2"), decimalNumber);
    }

    public static BigInteger fromBase62(String base62Number)
    {
        return fromOtherBaseToDecimal(62, base62Number);
    }

    public static BigInteger fromBase36(String base36Number)
    {
        return fromOtherBaseToDecimal(36, base36Number);
    }

    public static BigInteger fromBase16(String base16Number)
    {
        return fromOtherBaseToDecimal(16, base16Number);
    }

    public static BigInteger fromBase8(String base8Number)
    {
        return fromOtherBaseToDecimal(8, base8Number);
    }

    public static BigInteger fromBase2(String base2Number)
    {
        return fromOtherBaseToDecimal(2, base2Number);
    }

    private static String fromDecimalToOtherBase(BigInteger base, BigInteger decimalNumber)
    {
        String value = BigInteger.ZERO.equals(decimalNumber) ? "0" : "";
        int mod = 0;
        while(!BigInteger.ZERO.equals(decimalNumber))
        {
            mod           = decimalNumber.mod(base).intValue();
            value         = baseDigits.substring(mod, mod + 1) + value;
            decimalNumber = decimalNumber.divide(base);
        }
        return value;
    }

    private static BigInteger fromOtherBaseToDecimal(int base, String number)
    {
        int        iterator    = number.length();
        BigInteger returnValue = BigInteger.ZERO;
        int multiplier = 1;
        while (iterator > 0)
        {
            returnValue = returnValue.add(new BigInteger(Integer.toString(baseDigits.indexOf(number.substring(iterator - 1, iterator)) * multiplier)));
            multiplier = multiplier * base;
            --iterator;
        }
        return returnValue;
    }
}
