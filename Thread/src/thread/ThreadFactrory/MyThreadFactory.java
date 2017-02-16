package thread.ThreadFactrory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Jayuk
 */
public class MyThreadFactory implements ThreadFactory
{
    private int counter;
    private String nama;
    private List<String> statistikThread;
    
    public MyThreadFactory(String nama)
    {
        this.nama=nama;
        this.counter=0;
        statistikThread = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) 
    {
        Thread myThread = new Thread(r, nama + "Thread_"+counter);
        statistikThread.add("Menciptakan thread "+counter+" pada "+ new Date());
        counter++;
        return myThread;
    }
    public String getStats()
    {
        String stats="";
        for(String stat : statistikThread)
        {
            stats += stat+"\n" ;
        }
        return stats;
    }
}
