package uts2;

/**
 *
 * @author Bernando Lumban Raja
 */
public class Marketing extends Manager
{
    private double Tunjangan;

    public Marketing() 
    {
    }

    public Marketing(double Tunjangan) {
        this.Tunjangan = Tunjangan;
    }

    public double getTunjangan() {
        return Tunjangan;
    }

    public void setTunjangan(double Tunjangan) {
        this.Tunjangan = 500000;
    }
    
    

    
}
