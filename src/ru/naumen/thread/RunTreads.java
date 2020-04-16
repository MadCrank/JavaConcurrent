package ru.naumen.thread;

public class RunTreads
{
    public static void main(String[] args)
    {
        Thread thread1 = new Thread(()-> {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("I am first thread!");});

        Thread thread2 = new Thread(()-> {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("I am second thread!");});

        thread1.start();
        thread2.start();
    }
}
