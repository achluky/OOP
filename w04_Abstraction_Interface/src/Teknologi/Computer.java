package Teknologi;

/**
 *
 * @author Jayuk
 */
public final class Computer implements Teknologi
{
    int ram;
    int harddisk;
    int screenSize;
    String version;
    
    public int getRam()
    {
        return ram;
    }
    public int getHarddisk()
    {
        return harddisk;
    }
    public int getScreenSize()
    {
        return screenSize;
    }
    public void setRam(int ram)
    {
        this.ram = ram;
    }
    public void setHardDisk(int harddisk)
    {
        this.harddisk = harddisk;
    }
    public void setScreenSize(int screenSize)
    {
        this.screenSize = screenSize;
    }

    @Override
    public void upgrade() 
    {
        this.version = "Windows 10";
    }

    @Override
    public void install() 
    {
        this.version = "MS-DOS";
    }
}
