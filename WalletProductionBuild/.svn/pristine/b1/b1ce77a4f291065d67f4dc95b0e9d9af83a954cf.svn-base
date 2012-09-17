package com.o2.finance.util;

import java.math.BigInteger;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LuhnCalculatorTest 
extends TestCase
{
    public void testLuhnGeneration()
    {
        Assert.assertEquals("8", LuhnCalculator.generateCheckDigit(new BigInteger("1")));
        Assert.assertEquals("5", LuhnCalculator.generateCheckDigit(new BigInteger("12")));
        Assert.assertEquals("0", LuhnCalculator.generateCheckDigit(new BigInteger("123")));
        Assert.assertEquals("4", LuhnCalculator.generateCheckDigit(new BigInteger("1234")));
        Assert.assertEquals("5", LuhnCalculator.generateCheckDigit(new BigInteger("12345")));
        Assert.assertEquals("6", LuhnCalculator.generateCheckDigit(new BigInteger("123456")));
        Assert.assertEquals("4", LuhnCalculator.generateCheckDigit(new BigInteger("1234567")));
        Assert.assertEquals("2", LuhnCalculator.generateCheckDigit(new BigInteger("12345678")));
        Assert.assertEquals("7", LuhnCalculator.generateCheckDigit(new BigInteger("123456789")));
        Assert.assertEquals("3", LuhnCalculator.generateCheckDigit(new BigInteger("1234567890")));
        Assert.assertEquals("3", LuhnCalculator.generateCheckDigit(new BigInteger("1000000000000001234567")));
    }

    public void testLuhnGenerationWithZero()
    {
        Assert.assertEquals("0", LuhnCalculator.generateCheckDigit(new BigInteger("0")));
    }
}
