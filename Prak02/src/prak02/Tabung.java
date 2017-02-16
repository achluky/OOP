package prak02;

/**
 *
 * @author Jayuk
 */
public class Tabung extends Lingkaran
{
    private float tinggi;
    
    Tabung()
    {
        
    }
    Tabung(float tinggi, float jariJari)
    {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }
    void setTinggi(float tinggi)
    {
        this.tinggi = tinggi;
    }
    float getTinggi()
    {
        return tinggi;
    }
    double luasAlasTabung(float jariJari)
    {
        double luasAlas;
        luasAlas = getLuas(jariJari);
        
        return luasAlas;
    }
    float getLuasPermukaan(float jariJari, float tinggi)
    {
        float permukaanTabung ;
        double Luas = getLuas(jariJari);
        double keliling = getKelilingLingkaran(jariJari);
        permukaanTabung = (float) (Luas + keliling * tinggi);
        
        return permukaanTabung;
    }
    float getVolume(float jariJari, float tinggi)
    {
        double  Luas = getLuas(jariJari);
        float volume = (float) Luas * tinggi;
        
        return volume;
    }
}
