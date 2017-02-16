/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.perpus.driver;

import static javafx.application.Application.launch;

/**
 *
 * @author Wira
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Run1 run1 = new Run1();
        Run2 run2 = new Run2();
        Thread thread1 = new Thread(run1);
        Thread thread2 =  new Thread(run2);
    }
}
