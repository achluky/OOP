/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurency_teori_057;

/**
 *
 * @author Jayuk
 */
public class ThreadSum extends Thread
{
    private Matriks matriks;
    private int baris;
    public ThreadSum(Matriks matriks, int baris) {
        this.matriks = matriks;
        this.baris = baris;
    }    
    @Override
    public void run(){
        synchronized(matriks){
            matriks.JumlahkanTiapBaris(this.baris);
        }
    }
}
