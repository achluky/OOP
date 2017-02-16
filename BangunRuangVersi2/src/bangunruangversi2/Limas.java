/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangunruangversi2;

/**
 *
 * @author Jayuk
 */
public class Limas extends BangunRuang
{
    public Limas(double panjang, double lebar, double tinggi)
    {
        super(panjang,lebar,tinggi);
    }
    @Override
    public double getVolume() 
    {
        return getLuasAlas() * getTinggi() / 3d;
    }
    
}
