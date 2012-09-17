package com.o2.finance.service;

public class SystemTimeServiceImpl implements TimeService
{
    public long currentTimeInMillis()
    {
        return System.currentTimeMillis();
    }
}
