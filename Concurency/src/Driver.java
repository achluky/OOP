
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(in);
        System.out.print("M :");
        int m = Integer.parseInt(console.readLine());
        System.out.print("N :");
        int n = Integer.parseInt(console.readLine());
        
        Matriks.setUkuranMatriks(m, n);
        
        for(int a=0;a<m;a++)
        {
            for(int b=0;b<n;b++)
            {
                Matriks.data[a][b]= a;
            }
        }
            
        Thread threadTemp;
        List<Runnable> listRunnable = new ArrayList<>();
        List<Thread> listThread =  new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            ThreadSum threadSum = new ThreadSum(i);
            listRunnable.add(threadSum);
        }
        for(Runnable run : listRunnable)
        {
            listThread.add(threadTemp = new Thread(run));
        }
        /*
        for(Thread thread : listThread)
        {
            thread.start();
        }
*/
        for(Thread thread : listThread)
        {
            thread.join();
        }
        
        for(int c=0;c<Matriks.getN();c++)
        {
            System.out.println(c);
        }
    }
}
