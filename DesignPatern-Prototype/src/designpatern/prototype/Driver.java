package designpatern.prototype;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main (String[] args) throws CloneNotSupportedException
    {
        long milisAwal = System.currentTimeMillis();
        Manusia a = new Mahasiswa();
        long milisAkhir = System.currentTimeMillis();
        System.out.println("Delay selama    :" + (milisAkhir - milisAwal)/1000d + "detik");
        milisAwal = System.currentTimeMillis();
        Manusia b = new Dosen();
        milisAkhir = System.currentTimeMillis();
        System.out.println("Delay selama    :"+ ((milisAkhir - milisAwal)/1000d) + "detik");
        System.out.println("---------------------");
        System.out.println("Mencoba mengambil dari cache");
        ManusiaCache.loadCache();
        System.out.println("---------------------");
        System.out.println("Ciptakan objek Mahasiswa");
        milisAwal = System.currentTimeMillis();
        Manusia man = ManusiaCache.getManusiaFromCache(ManusiaCache.MAHASISWA);
        milisAkhir = System.currentTimeMillis();
        System.out.println("Delay Selama    :"+((milisAwal - milisAkhir)/1000d)+"detik");
        System.out.println("Ciptakan objek Dosen");
        milisAwal = System.currentTimeMillis();
        man = ManusiaCache.getManusiaFromCache(ManusiaCache.DOSEN);
        milisAkhir = System.currentTimeMillis();
        System.out.println("Delay selama    :"+ ((milisAkhir - milisAkhir)/1000d)+"detik");
        
    }
    
}
