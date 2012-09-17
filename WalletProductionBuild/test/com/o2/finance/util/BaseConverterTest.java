package com.o2.finance.util;

import java.math.BigInteger;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BaseConverterTest 
extends TestCase
{
    private BigInteger seed;
    
    protected void setUp() 
    throws Exception
    {
        this.seed = new BigInteger("1234567890");
    }
    
    public void testBase62()
    {
        String expectedEncoded = "1LY7VK";
        String actualEncoded   = BaseConverter.toBase62(seed);
        Assert.assertEquals(expectedEncoded, actualEncoded);
        
        BigInteger decoded = BaseConverter.fromBase62(expectedEncoded);
        Assert.assertEquals(seed, decoded);
    }

    public void testBase36()
    {
        String expectedEncoded = "KF12OI";
        String actualEncoded   = BaseConverter.toBase36(seed);
        Assert.assertEquals(expectedEncoded, actualEncoded);
        
        BigInteger decoded = BaseConverter.fromBase36(expectedEncoded);
        Assert.assertEquals(seed, decoded);
    }

    public void testBase16()
    {
        String expectedEncoded = "499602D2";
        String actualEncoded   = BaseConverter.toBase16(seed);
        Assert.assertEquals(expectedEncoded, actualEncoded);
        
        BigInteger decoded = BaseConverter.fromBase16(expectedEncoded);
        Assert.assertEquals(seed, decoded);
    }

    public void testBase8()
    {
        String expectedEncoded = "11145401322";
        String actualEncoded   = BaseConverter.toBase8(seed);
        Assert.assertEquals(expectedEncoded, actualEncoded);
        
        BigInteger decoded = BaseConverter.fromBase8(expectedEncoded);
        Assert.assertEquals(seed, decoded);
    }

    public void testBase2()
    {
        String expectedEncoded = "1001001100101100000001011010010";
        String actualEncoded   = BaseConverter.toBase2(seed);
        Assert.assertEquals(expectedEncoded, actualEncoded);
        
        BigInteger decoded = BaseConverter.fromBase2(expectedEncoded);
        Assert.assertEquals(seed, decoded);
    }
}
