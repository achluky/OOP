package perpustakaan;
import java.util.*;

public class Driver 
{
    public static void main(String[] args) 
    {
        System.out.print("Input Jumlah Buku : ");
        Scanner input = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);
        Buku.stok = inputint.nextInt();
        Buku buku[] = new Buku[Buku.stok];
        
        for(int i=0;i<Buku.stok;i++)
        {
            buku[i] = new Buku();
            System.out.println("Buku "+(i+1));
            System.out.print("ISBN              : ");
            buku[i].setISBN(input.next());
            System.out.print("Judul             : ");
            buku[i].setJudulBuku(input.next());
            System.out.print("Pengarang         : ");
            buku[i].setPengarang(input.next());
            System.out.print("Penerbit          : ");
            buku[i].setPenerbit(input.next());
            do{
                System.out.print("Tipe              : ");
                buku[i].setTipeBuku(input.next());
            }while(buku[i].checkBookType()!=true);
            System.out.print("Jumlah            : ");
            buku[i].setJumlahBuku(inputint.nextInt());
        }
        
        System.out.print("Input Jumlah Anggota : ");
        Anggota.jumlahAnggota = inputint.nextInt();
        Anggota[] anggota = new Anggota[Anggota.jumlahAnggota];
        
        for(int i = 0;i<Anggota.jumlahAnggota; i++)
        {
            anggota[i] = new Anggota();
            System.out.println("Anggota "+(i+1));
            System.out.print("ID                  : ");
            anggota[i].setID(input.next());
            System.out.print("Nama                : ");
            anggota[i].setNama(input.next());
            do{
                System.out.print("Pekerjaan           : ");
                anggota[i].setPekerjaan(input.next());
            }while(anggota[i].checkPekerjaan()!=true);
            System.out.print("Tanggal Lahir       : ");
            anggota[i].setTanggalLahir(input.next());
            do
            {
                System.out.print("Jenis Kelamin       : ");
                anggota[i].setJenisKelamin(input.next());
            }while(anggota[i].checkJenisKelamin()!=true);
            System.out.print("Alamat              : ");
            anggota[i].setAlamat(input.next());
            System.out.print("Agama               : ");
            anggota[i].setAgama(input.next());
        }
        
        System.out.println("Menu");
        System.out.println("1. Menampilkan List Buku");
        System.out.println("2. Mengubah Data Buku ");
        System.out.println("3. Menghapus Buku");
        System.out.println("4. Menampilkan List Anggota");
        System.out.println("5. Mengubah Data Anggota");
        System.out.println("6. Menghapus Anggota");
        System.out.println("7. Exit");
        System.out.print("Pilihan = ");
        int pilihan = input.nextInt();
        
        while(pilihan != 7)
        {
            switch(pilihan)
            {
                 case 1 :
                    for(int i = 0 ;i<Buku.stok;i++)
                    {
                        System.out.println("Buku ");
                        buku[i].tampilkanBuku();
                     }
                     break;
                 case 2 :
                     System.out.print("No urut buku yang ingin diubah : ");
                     int indexBuku = inputint.nextInt();
                     System.out.println("Data Perubahan");
                     System.out.println("1. Judul");
                     System.out.println("2. Penerbit");
                     System.out.println("3. Pengarang");
                     System.out.print("Pilih : ");
                     int atributBuku = inputint.nextInt();
                     switch(atributBuku)
                     {
                         case 1:
                             System.out.print("Masukkan Judul Buku baru : ");
                             String judulBukuBaru = input.next();
                             buku[indexBuku-1].setJudulBuku(judulBukuBaru);
                             buku[indexBuku-1].tampilkanBuku();
                             break;
                         case 2:
                             System.out.print("Masukkan Penerbit baru : ");
                             String penerbitBaru = input.next();
                             buku[indexBuku-1].setPenerbit(penerbitBaru);
                             buku[indexBuku-1].tampilkanBuku();
                             break;
                         case 3:
                             System.out.print("Masukkan Pengarang baru : ");
                             String pengarangBaru = input.next();
                             buku[indexBuku-1].setJudulBuku(pengarangBaru);
                             buku[indexBuku-1].tampilkanBuku();
                             break;
                         default:
                             break;
                     }
                     break;
                 case 3:
                     System.out.print("No urut buku yang ingin dihapus : ");
                     int hapusBuku = inputint.nextInt();
                     for(int index = 0; index < Buku.stok;index++)
                     {
                         if(buku[index].equals(buku[hapusBuku-1]))
                         {
                             Buku.stok = index - 1;
                             break;
                         }
                     }
                     for(int i = 0 ;i<Buku.stok;i++)
                     {
                        System.out.println("Buku ");
                        buku[i].tampilkanBuku();
                     }
                     break;
                     
                 case 4:
                     for(int i = 0 ;i<Anggota.jumlahAnggota;i++)
                    {
                        System.out.println("Anggota ");
                        anggota[i].tampilkanAnggota();
                    }
                    break;
                 case 5:
                     System.out.print("No urut Anggota yang ingin diubah : ");
                     int indexAnggota = inputint.nextInt();
                     System.out.println("Data Yang Akan Diubah");
                     System.out.println("1. Nama");
                     System.out.println("2. Pekerjaan");
                     System.out.println("3. Alamat");
                     System.out.print("Pilih : ");
                     int atribut = inputint.nextInt();
                     switch(atribut)
                     {
                         case 1 :
                             System.out.println("Masukkan Nama Baru : ");
                             String namaBaru = input.next();
                             anggota[atribut-1].setNama(namaBaru);
                             anggota[atribut-1].tampilkanAnggota();
                             break;
                         case 2 :
                             System.out.println("Masukkan Pekerjaan Baru : ");
                             String pekerjaanBaru = input.next();
                             anggota[atribut-1].setPekerjaan(pekerjaanBaru);
                             anggota[atribut-1].tampilkanAnggota();
                             break;
                         case 3 :
                             System.out.println("Masukkan Alamat Baru : ");
                             String alamatBaru = input.next();
                             anggota[atribut-1].setAlamat(alamatBaru);
                             anggota[atribut-1].tampilkanAnggota();
                             break;
                     }
                 case 6:
                     System.out.print("No urut anggota yang ingin dihapus : ");
                     int hapusAnggota = inputint.nextInt();
                     for(int index = 0; index < Buku.stok;index++)
                     {
                         if(anggota[index].equals(anggota[hapusAnggota-1]))
                         {
                             Anggota.jumlahAnggota = index - 1;
                             break;
                         }
                     }
                     for(int i = 0 ;i<Anggota.jumlahAnggota;i++)
                     {
                        System.out.println("Buku ");
                        anggota[i].tampilkanAnggota();
                     }
                     break;
                 default:
                     System.out.println("Masukan Salah, Masukkan input yang benar !");
            }
            System.out.print("Pilihan = ");
            pilihan = input.nextInt();
         }
    }  
}
