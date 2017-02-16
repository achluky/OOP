package Teknologi;

import java.util.Scanner;


public class Driver 
{
    public static void main(String[] args) 
    {
        
        int pilihan, pilihanOS,pil;
        Scanner data = new Scanner(System.in);
        
        System.out.println("1. Android");
        System.out.println("2. Windows Phone");
        System.out.print("Pilihan Smartphone :");
        pilihanOS = data.nextInt();
        switch(pilihanOS){
            case 1:
                   android();
            break;
            case 2:
                    windowsPhone();
            break;
            
                
        }
    }
    
    public static void android()
    {
        Scanner data = new Scanner(System.in);
        Android android = new Android();
            int pilihan,pil;
            System.out.println("Android anda :");
            System.out.println("");
            System.out.println("1. Upgrade Android ");
            System.out.println("2. Download Aplikasi ");
            System.out.println("3. Lihat aplikasi :");
            System.out.println("4. Jumlah aplikasi :");
            System.out.println("5. Keluar");
        
            
            System.out.print("Pilihan :"); 
            pilihan = data.nextInt();
            switch(pilihan){
                case 1:
                    android.upgrade();
                    break;
                case 2:
                    System.out.print("Jumlah Aplikasi yang ingin didownload :");
                    pil = data.nextInt();
                    for(int i=1; i<=pil; i++){
                        System.out.print("Aplikasi "+i + " yang ingin didownload :");
                        String namaApp = data.next();
                        android.download(namaApp);
                    }
                    break;
                case 3:
                    System.out.println("Aplikasi anda :"+android.getApps());
                    break;
                case 4:
                    System.out.println("jumlah aplikasi : "+android.getNumberApp());
                    break;
                case 5:
                    System.exit(0);
            }
        }
    
    public static void windowsPhone()
    {
        Scanner data = new Scanner(System.in);
        WindowsPhone windows = new WindowsPhone() {
            @Override
            public void takePicture() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        int  pil,pilihan = data.nextInt();
                System.out.println("");
                System.out.println("1. Upgrade Windows ");
                System.out.println("2. Download Aplikasi ");
                System.out.println("3. Lihat aplikasi ");
                System.out.println("4. Take Photo ");
                System.out.println("5. See Number of Foto");
                System.out.println("5. Keluar");
                System.out.print("Pilihan :"); 
                pilihan = data.nextInt();
                switch(pilihan){
                    case 1:
                        windows.upgrade();
                        break;
                    case 2:
                        System.out.print("Jumlah Aplikasi yang ingin didownload :");
                        pil = data.nextInt();
                        for(int i=1; i<=pil; i++){
                        System.out.print("Aplikasi "+i + " yang ingin didownload :");
                        String namaApp = data.next();
                        windows.download(namaApp);
                        }
                        break;
                    case 3:
                         windows.getApps();
                        break;
                    case 4:
                        windows.takePicture();
                        System.out.println("foto disimpan? 1.Iya, 2.Tidak");
                        System.out.print("pilihan : ");
                        int milih = data.nextInt();
                        if(milih == 1){
                            windows.savePicture();
                        }
                        else{
                            
                        }
                    case 5:
                        System.out.println("Jumlah Foto : "+windows.getJumlahPhoto());
                        break;
                    case 6:
                        System.exit(0);
                }
           }
    }
