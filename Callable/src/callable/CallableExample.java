/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callable;

import java.util.concurrent.Callable;

/**
 *
 * @author Jayuk
 */
public class CallableExample implements Callable<String>
{

    @Override
    public String call() throws Exception 
    {
        String s="Callable Task Run at "+System.currentTimeMillis();
        return s;
    }
  }