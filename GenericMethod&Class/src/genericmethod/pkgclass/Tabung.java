/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethod.pkgclass;

/**
 *
 * @author Jayuk
 */
public class Tabung extends BangunRuang
{
    private double jariJari;
    private double tinggi;

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    

    public Tabung(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double luasPermukaan()
    {
        double luasPermukaan = Math.PI *jariJari * jariJari;
        return luasPermukaan;
    }

    @Override
    public double volume() 
    {
        double volume = luasPermukaan() * tinggi;
        return volume;
    }

    @Override
    public void info() 
    {
        System.out.println("Tinggi  :" + tinggi);
        System.out.println("Jari - Jari :"+jariJari);
        System.out.println("Luas Permukaan   :" +luasPermukaan());
        System.out.println("Volume  :"+ volume());
    }
    
}
