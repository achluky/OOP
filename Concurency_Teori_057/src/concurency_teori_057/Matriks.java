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
public class Matriks 
{
    private int[][] data ={{1,2,3},{4,5,6},{7,8,9}};
    private int[] hasil;

    public Matriks() {
        hasil = new int[3];
    }

    public void JumlahkanTiapBaris(int baris) {
        for (int i = 0; i < data[baris].length; i++) {
            hasil[baris] += data[baris][i];
        }
    }

    public void getHasil() {
        for (int i = 0; i < hasil.length; i++) {
            System.out.println(hasil[i]);
        }
    }
}
