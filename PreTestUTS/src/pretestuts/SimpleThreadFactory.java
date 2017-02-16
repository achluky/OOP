package pretestuts;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Jayuk
 */
public class SimpleThreadFactory implements ThreadFactory
{
    public SimpleThreadFactory()
    {
        
    }

    @Override
    public Thread newThread(Runnable r) 
    {
        Thread myThread =  new Thread(r);
        return myThread;
    }
    
    
}
