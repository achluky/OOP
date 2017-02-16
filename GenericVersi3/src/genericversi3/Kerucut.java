/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericversi3;

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
        double luasPermukaan = tinggi * jariJari;
        return luasPermukaan;
    }
    @Override
    public double volume()
    {
        double volume = Math.PI * jariJari * jariJari * tinggi;
        return volume;
    }
    @Override
    public void info()
    {
        System.out.println("Jari - jari \t:\n"+jariJari);
        System.out.println("Tinggi\t:\n"+ tinggi);
    }
}
