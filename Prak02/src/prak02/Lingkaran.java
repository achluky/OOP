package prak02;

/**
 *
 * @author Jayuk
 */
public class Lingkaran 
{
    protected float jariJari;
    private double  phi = 3.14;;
    
    public Lingkaran()
    {
        
    }
    public Lingkaran(float jariJari)
    {
     this.jariJari = jariJari;
    }
    float getJarijari()
    {
        return jariJari;
    }
    void setJariJari(float jariJari)
    {
        this.jariJari= jariJari;
    }
    double getLuas(float jariJari)
    {
        double luasLingkaran;
        luasLingkaran =   phi* jariJari * jariJari;
        
        return luasLingkaran;
    }
    float getKelilingLingkaran(float jariJari)
    {
        float kelilingLingkaran = (float) (2 * phi * jariJari);
        
        return kelilingLingkaran;
    }
}
