package ru.naumen.counter.impls;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов на ReentrantReadWriteLock
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class RWLockCounter implements Counter
{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile int counter = 0;

    public RWLockCounter(boolean fair)
    {
        lock = new ReentrantReadWriteLock(fair);
    }

    @Override
    public int get()
    {
        lock.readLock().lock();
        try
        {
            return counter++;
        }
        finally
        {
            lock.readLock().unlock();
        }
    }

    @Override
    public void increment()
    {
        lock.writeLock().lock();
        try
        {
            counter++;
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void reset()
    {
        lock.writeLock().lock();
        try
        {
            counter = 0;
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

}
