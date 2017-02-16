/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class DriverTemp 
{
    public static void main(String[] args) 
    {
        //System.out.println("hasil "+hasil());
        
    }
    public static double hasil()
    {
        //double[] tempNum = new double[20];
        double temporaly = 0;
        double resultTemp = 0;
        int flagsDiv=0;
        int flags=0;
        String temp="1+3/3";        
        for(int i=temp.length()-1;i>=0;i--)
        {
            int k=0;
            if(Character.isDigit(temp.charAt(i)))
            {
                temporaly += (double) pangkat(((double)temp.charAt(i)-'0'),flags);
                flags++;
            }
            else
            {
                
                if(temp.charAt(i)=='x'||temp.charAt(i)=='X')/*
                    if(tempNum[0]==0)
                        resultTemp = tempNum[0];
                    else*/
                    {
                        if(resultTemp==0)
                            resultTemp =temporaly;
                        else
                            resultTemp = resultTemp * temporaly;
                        flagsDiv++;
                        //k++;
                    }
                else if(temp.charAt(i)=='+')/*
                    if(tempNum[0]==0)
                        resultTemp += tempNum[0];
                    else*/
                    {
                        resultTemp += temporaly;
                        //k++;
                        flagsDiv++;
                    }
                else if(temp.charAt(i)=='-')/*
                    if(tempNum[0]==0)
                        resultTemp = tempNum[0];
                    else*/
                    {
                        resultTemp -= temporaly;
                        //k++;
                        flagsDiv++;
                    }
                else if(temp.charAt(i)=='/')/*
                    if(tempNum[0]==0)
                        resultTemp += tempNum[0];
                    else*/
                    {
                        //if(flagsDiv==0)
                         //   resultTemp = temporaly;
                        //else
                        if(temporaly!=0)
                            resultTemp = (resultTemp / temporaly);
                        //k++;
                    }
                flags=0;
                
                System.out.println(temporaly);
                temporaly=0;
            }
        }
        
        return resultTemp;
    }
    
    public static double pangkat(double a, int b)
    {
        if(b==0)
        {
            if(a==0)
                return 0;
            else
                return a * 1;
        }
        else if(b==1)
        {
            if(a==0)
                return 0;
            else
                return a * 10;
        }
        else if(b==2)
        {
            if(a==0)
                return 0;
            else
                return a * 100;
        }
        else if(b==3)
        {
            if(a==0)
                return 0;
            else
                return a * 1000;
        }
        else 
            return 100;
    }
}
