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
public class PrintAngkaExtendThread extends Thread
{
    private List<Integer> myList;
    private String namaThread;
    int total = 0;
    
    public PrintAngkaExtendThread(List<Integer> myList, String namaThread)
    {
        this.myList = myList;
        this.namaThread = namaThread;
    }
    
    @Override
    public void run()
    {
        for(Integer a : myList)
        {
            System.out.println(namaThread +" " +myList.get(a));
            total += myList.get(a);
        }
    }
}
