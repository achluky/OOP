/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Permutation 
{
    public static void main(String[] args) {
        int[] a =  new int[3];
        all_perm(a, 0);
    }
    
           public static void all_perm(int[] a, int n)
           {
               if (n == a.length)         
               {
                   for (int i = 0; i < a.length; i++)
                       System.out.print( a[i] + " ");
               System.out.println();
               return;         
           }
           
            int[] v = new int[a.length];
            for (int i = 0; i < n; i++)
                v[a[i]] = 1; 
                for (int i = 0; i < a.length; i++)
                {
                    if (v[i] == 0)            
                    {
                            a[n] = i;
                    }
                all_perm(a, n+1); 
                }
           }
}
