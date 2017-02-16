package thread.ThreadFactrory;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        MyThreadFactory myThreadFactory =  new MyThreadFactory("Kalkulator Factory");
        for(int i=0;i<10;i++)
        {
            Kalkulator kalkulator =  new Kalkulator(i);
            Thread thread = myThreadFactory.newThread(kalkulator);
            if(i%2==0)
            {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            else
            {
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            thread.start();
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        System.out.println("------STATS FACTORY----------"+myThreadFactory.getStats());
    }
}
