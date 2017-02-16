/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.perpus.driver;

import static javafx.application.Application.launch;
import static javafx.application.Application.launch;

/**
 *
 * @author Jayuk
 */
public class Run1 implements Runnable
{

    @Override
    public void run() {
        String[] args = null;
        launch(Perpus.class,args);
    }
    
}
