/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.util.Arrays;
/**
 *
 * @author Jayuk
 */
public class CrackingPassword 
{
    
    public static void main(String[] args)  
    {
        String password = "bac";
        char[] charset = "abc".toCharArray();
        //char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        CrackingPassword bf = new CrackingPassword(charset, 1);

        String attempt = bf.toString(); 
        while (true)
        {
            if (attempt.equals(password))
            {
                System.out.println("Password Found: " + attempt);
                break;
            }
            attempt = bf.toString();
            System.out.println("" + attempt);
            bf.increment();
        }
    }
private char[] cs; // Character Set
private char[] cg; // Current Guess

public CrackingPassword(char[] characterSet, int guessLength)
{
    cs = characterSet;
    cg = new char[guessLength];
    Arrays.fill(cg, cs[0]);
}

public void increment()
{
    int index = cg.length - 1;
    while(index >= 0)
    {
    if (cg[index] == cs[cs.length-1])
    {
        if (index == 0)
        {
            cg = new char[cg.length+1];
            Arrays.fill(cg, cs[0]);
            break;
        }
        else
        {
            cg[index] = cs[0];
            index--;
        }
    }
    else
    {
        cg[index] = cs[Arrays.binarySearch(cs, cg[index]) + 1];
        break;
    }
}
}

@Override
public String toString()
{
return String.valueOf(cg);
}
} 
