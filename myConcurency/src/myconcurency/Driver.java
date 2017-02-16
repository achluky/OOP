package myconcurency;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException 
    {
        List<Integer> myList = new ArrayList<>();
        for(int i = 0 ; i<= 10000000;i++)
        {
            myList.add(i);
        }
        PrintAngkaExtendThread myThread1 =  new PrintAngkaExtendThread(myList, "ThreadExtend");
        PrintAngkaInplRunnable RunnablePrintAngka = new PrintAngkaInplRunnable(myList, "ThreadImplRunnable");
        Thread myThread2 = new Thread(RunnablePrintAngka);
        
        myThread1.start();
        myThread1.join();
        
        myThread2.start();
        myThread2.interrupt();
        System.out.println("masih jalan");
        
        
    }
    
}
