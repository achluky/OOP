package Teknologi;

import java.util.ArrayList;

/**
 *
 * @author Jayuk
 */
public abstract class WindowsPhone extends Smartphone
{
    int resolusiKamera;
    static int jumlahPhoto;
    ArrayList apps = new ArrayList();
    String[] os = {"Windows phone 7.0", "Windows Phone 7.5", "Windows Phone 8.0", "Windows Phone 8.1", "Windows Phone 10"};
    String version;
    int index;
    //Accessor
    public int getResolusiKamera()
    {
        return resolusiKamera;
    }
    public int getJumlahPhoto()
    {
        return jumlahPhoto;
    }
    
    public String getVersion()
    {
        return os[index];
    }
    
    //mutator
    public void setResolusiKamera(int resolusiKamera)
    {
        this.resolusiKamera = resolusiKamera;
    }
    public void setJumlahPhoto(int jumlah)
    {
        WindowsPhone.jumlahPhoto = jumlah;
    }
    
    public void setVersion(String version)
    {
        this.os[index] = version;
    }
    
    @Override
    public void upgrade()
    {
        if(index != os.length)
        {
            index++;
            version = (""+os[index]);
        }
        else
        {
            System.out.println("Your version of Windows is up to date");
        }
        System.out.println("Your windows version is" + version);
    }
    @Override
    public void install()
    {
       this.version = os[1];
    }
    @Override
    public void download(String namaApp)
    {
        apps.add(""+namaApp);
    }

    public void savePicture(){
        System.out.println("Picture has been saved..");
        jumlahPhoto++;
    }

    public abstract void takePicture();

    public void getApps() 
    {
       System.out.println(apps);
    }
}
