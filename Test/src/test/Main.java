/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class Main 
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        int input[] = new int[loop];
        for(int i=0;i<loop;i++)
        {
            input[i] = in.nextInt();
        }
    }
}
