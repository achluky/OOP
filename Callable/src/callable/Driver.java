/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        CallableExample call = new CallableExample();
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(call);
        boolean listen = true;
        while(listen)
        {
            if(future.isDone())
            {
                String result;
                try
                {
                    result = future.get();
                    listen = false;
                    System.out.println(result);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                catch(ExecutionException ee)
                {
                    ee.printStackTrace();
                }
            }
        }
    }
    
}
