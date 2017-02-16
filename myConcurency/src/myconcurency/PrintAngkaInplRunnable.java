/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconcurency;

import java.util.List;

/**
 *
 * @author Jayuk
 */
public class PrintAngkaInplRunnable implements Runnable
{
    private String namaThread;
    private List<Integer> myList;
    int total = 0;

    public PrintAngkaInplRunnable(List<Integer> myList, String namaThread)
    {
        this.namaThread = namaThread;
        this.myList = myList;
    }
    
    @Override
    public void run() 
    {
        for(Integer a : myList)
        {
            System.out.println(namaThread+" "+ myList.get(a));
            total += myList.get(a);
        }
    }
    
}
