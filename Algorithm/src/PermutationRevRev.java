/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class PermutationRevRev 
{
    static int stepCount=0;
    static int perCount=0;
    public static void main(String args[]) 
    {
        final long startTime = System.currentTimeMillis();
        permuteString("", "012345678945");
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)+"ms");
        System.out.println("Jumlah Langkah :"+stepCount);
        System.out.println("Jumlah Permutasi :"+perCount);
    }
    
    public static void permuteString(String beginningString, String endingString) 
    {
        stepCount++;
        if (endingString.length() <= 1)
        {
            //System.out.println(beginningString + endingString);
            perCount++;
        }
        else
            for (int i = 0; i < endingString.length(); i++) {
                try
                {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    permuteString(beginningString + endingString.charAt(i), newString);
                }
                catch (StringIndexOutOfBoundsException exception) 
                {
                    exception.printStackTrace();
                }
            }
    }
}
