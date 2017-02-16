package Teknologi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jayuk
 */
public class Android extends Smartphone
{
   String jenisAndroid;
   public  ArrayList apps = new ArrayList();
   private String[] os = {"Froyo","Ice Cream Sandwich","Jelly Bean", "KitKat","Lolipop"};
   public int index = 1;
   
   public ArrayList getApps()
   {
       return apps;
   }
   public int getNumberApp()
   {
       return aplikasi;
   }
   public String getJenisAndroid()
   {
       return jenisAndroid;
   }
   public void setJenisAndroid(String jenisAndroid)
   {
       this.jenisAndroid = jenisAndroid;
   }
   
    public void chatting()
    {
        System.out.println("hello..");
    }
    public void addApps(String namaApps)
    {
        apps.add(""+ namaApps);
    }
    public void showListApps()
    {
        System.out.print(apps);
    }

    @Override
    public void upgrade() 
    {
       if (index != os.length)
       {
           index ++;
           System.out.println("Upgrade OS to " + os[index]);
           jenisAndroid = os[index];
       }
       else
       {
           System.out.println("Your version of Windows is up to date");
       }
       System.out.println("Your android version is" + os[index]);
    }
    

    @Override
    public void install()
    {
        this.jenisAndroid = os[index];
    }

    @Override
    public void download(String namaApp)
    {
       System.out.println("Download...."+namaApp);
       System.out.println(namaApp+" Selesai Terdownload");
    }  
}
