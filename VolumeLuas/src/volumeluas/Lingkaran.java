package volumeluas;

/**
 *
 * @author Jayuk
 */
public class Lingkaran 
{
    private final double phi = 3.14;
    private double jariJari;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }
    public double luasLingkaran()
    {
        double luasLingkaran = phi *jariJari *jariJari;
        return luasLingkaran;
    }
    
}
