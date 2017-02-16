/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_teori_057.model;

import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Observable
{
    private String[] namas;
    private String[] nims;
    private double[] ipk;
    private String[] matakuliah;
    private double[][] nilai;

    public Mahasiswa() {
        namas = new String[3];
        nims = new String[3];
        ipk = new double[3];
        matakuliah = new String[3];
        nilai = new double[3][5];
    }

    public void setNamas() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < namas.length; i++) {
            System.out.print("Masukkan nama[" + (i+1) + "] : ");
            namas[i] = scan.next();
            setChanged();
        }
        System.out.println("");
    }

    public void setNims() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < nims.length; i++) {
            System.out.print("Masukkan nim[" + (i+1) + "] : ");
            nims[i] = scan.next();
            setChanged();
        }
        System.out.println("");
    }

    public void setIpk() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < ipk.length; i++) {
            System.out.print("Masukkan ipk[" + (i+1) + "] : ");
            ipk[i] = scan.nextDouble();
            setChanged();
        }
        System.out.println("");
    }

    public void setMatakuliah() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < matakuliah.length; i++) {
            System.out.print("Masukkan matakuliah[" + (i+1) + "] : ");
            matakuliah[i] = scan.next();
            setChanged();
        }
        System.out.println("");
    }

    public void setNilai() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < namas.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Masukkan nilai matakuliah[" + (i+1) + "][" +(j+1) + "] : ");
                nilai[i][j] = scan.nextDouble();
                setChanged();
            }
        }
        notifyObservers();
        
    }
    public String getNama(int i){
        return namas[i];
    }
    public String getMatakuliah(int i){
        return matakuliah[i];
    }
    public double getIpk(int i){
        return ipk[i];
    }
    public String getNim(int i){
        return nims[i];
    }
    public double getNilai(int i,int j){
        return nilai[i][j];
    }
}
