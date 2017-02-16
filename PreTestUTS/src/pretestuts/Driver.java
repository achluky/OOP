
package pretestuts;

/**
 *
 * @author Tampan
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SimpleThreadFactory myThread= new SimpleThreadFactory();
        Komputer komputer = new Komputer("Lenovo", "B640",50);
        Pekerja pekerja = new Pekerja("123","Perdana", 100, 50);
        Komponen komponen = new Komponen("Memory","LG", 200 );
        komputer.tambahKomponen(komponen);
        komponen = new Komponen("Harddisk", "Toshiba", 300);
        komputer.tambahKomponen(komponen);
        Pabrik.listKomputer.add(komputer);
        
        
        //thread Sinkronisasi
        pekerja.addKomputer(komputer);
        Marketing marketing = new Marketing("987", "jaya", 100.0, 100000.0);
        Pembeli pembeli = new Pembeli( 1000, "Nova", "Tarutung");
        //komputer berhasil dibeli
        pembeli.membeli(marketing, "Lenovo", "B640",20);
        pembeli.faktur();
        //Thread a = myThread.newThread(pekerja);
        Thread a = myThread.newThread(marketing);
        Thread b = myThread.newThread(marketing);
        Thread c = myThread.newThread(pekerja);
        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
        System.out.println(Pabrik.listKomputer.get(0).getStok());
        
    }

}
