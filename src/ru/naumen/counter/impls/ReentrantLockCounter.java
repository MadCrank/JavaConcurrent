package ru.naumen.counter.impls;

import java.util.concurrent.locks.ReentrantLock;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов на ReentrantLock
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class ReentrantLockCounter implements Counter
{
    ReentrantLock lock;
    private volatile int counter = 0;

    public ReentrantLockCounter(boolean fair)
    {
        lock = new ReentrantLock(fair);
    }

    @Override
    public int get()
    {
        lock.lock();
        try
        {
            return counter++;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public void increment()
    {
        lock.lock();
        try
        {
            counter++;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public void reset()
    {
        lock.lock();
        try
        {
            counter = 0;
        }
        finally
        {
            lock.unlock();
        }
    }

}
