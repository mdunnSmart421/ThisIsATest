package com.o2.finance.util;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Purpose: com.o2.finance.util User: D Smith Date: 18/03/2011
 */
public class MsisdnUtils
{
    public static String generateRandomMpn()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("07");
        Random random = new Random(new GregorianCalendar().getTimeInMillis());
        for (int i = 0; i < 9; i++)
        {
            buffer.append(random.nextInt(9));
        }
        return buffer.toString();
    }

    public static String generateRandomMsisdn()
    {
        String mpn = generateRandomMpn();
        return MsisdnConverter.msisdnToInternational(mpn);
    }

    public static void main(String[] args)
    {
        System.out.println(MsisdnUtils.generateRandomMpn());
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(MsisdnUtils.generateRandomMsisdn());
    }
}
