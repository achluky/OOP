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
public class Kerucut extends BangunRuang
{
    double jariJari;
    double tinggi;

    @Override
    public double luasPermukaan() 
    {
        double luasAlas =  Math.PI *jariJari * jariJari;
        double luasPermukaan = luasAlas * 2; 
        return luasPermukaan;
    }

    @Override
    public double volume() 
    {
        double volume = 1/3 *Math.PI *jariJari * jariJari * tinggi;
        return volume;
    }

    @Override
    public void info() 
    {
        System.out.println("Jari - Jari :" +jariJari);
        System.out.println("Tinggi  :" + tinggi);
        System.out.println("Luas Permukaan  :"+luasPermukaan());
        System.out.println("Volume  :"+ volume());
    }
    
}
