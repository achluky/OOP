/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts2;

/**
 *
 * @author Bernando Lumban Raja
 */
public class Operasional extends Manager
{
    private double tungangan;

    public Operasional(double tungangan) {
        this.tungangan = tungangan;
    }

    public double getTungangan() {
        return tungangan;
    }

    public void setTungangan(double tungangan) {
        this.tungangan = 1000000;
    }
    
    
}
