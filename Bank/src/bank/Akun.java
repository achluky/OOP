package bank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class Akun implements Runnable
{
    private Akun akun;
    private String id;
    private String password;
    private double uang=0;
    private String historyTransaksi="";
    private List<String> history= new ArrayList<>();
    private int i =0;
    
    public Akun(String id, String password,double uang,Person person)
    {
        this.id=id;
        this.password=password;
        this.uang=uang;
        this.akun=akun;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void setUang(double uang)
    {
        this.uang=uang;
    }
    public double getUang()
    {
        return uang;
    }
    
    public void simpanUang(double deposit)
    {
        uang += deposit;
        history.add("Menyimpan uang dengan jumlah : "+deposit + " Total uang yang disimpan :"+uang);
    }
    public double ambilUang(double jumlah)
    {
        if(uang>=jumlah)
        {
            uang = uang - jumlah;
            history.add("Pengambilan uang dilakukan dengan jumlah " + jumlah + " jumlah uang tersisa :"+uang);
            return jumlah;
        }
        else
        {
            history.add("Pengambilan uang gagal karena uang tidak jumlah uang di akun tidak cukup");
            System.out.println("Uang di Akun tidak mencukupi");
            return 0;
        }
    }
    public String getHistory()
    {
        for(String stat : history)
        {
            historyTransaksi += stat+"\n";
        }
        return historyTransaksi;
    }

    @Override
    public void run()
    {
        
    }
    
}

