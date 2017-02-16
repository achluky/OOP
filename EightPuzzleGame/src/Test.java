
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Test 
{
    public static void main(String[] args) {
        int temp1[][] = {{1,2,3},{4,5,6},{7,8,0}};
        int temp2[][] = {{1,2,3},{4,5,6},{7,8,0}};
        int a=0;
        for(int i=0;i<temp1.length;i++)
        {
            for(int j=0;j<temp1.length;j++)
            {
                if(temp1[i][j] == temp2[i][j])
                {
                    a++;
                }
            }
        }
        if(a==9)
            System.out.println("benar");
    }
}
