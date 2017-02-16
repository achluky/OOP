/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MyThreadFactory threadFactory =  new MyThreadFactory("Thread factory");
        
        Person person1 = new Person("jaya");
        Bank bank =  new Bank();
        bank.tambahPerson(person1);
        Person person2 = new Person("Haryono");
        bank.tambahPerson(person2);
        Person person3 = new Person("Manik");
        bank.tambahPerson(person3);
        Akun akun1 = new Akun("111","satu",100000, person1);
        bank.tambahAkun(akun1);
        Akun akun2 = new Akun("222","dua",100000, person1);
        bank.tambahAkun(akun2);
        Akun akun3 = new Akun("333","tiga",100000, person1);
        bank.tambahAkun(akun3);
        Thread ambilUangThread =  threadFactory.newThread();
        for(int i=0;i<50000;i++)
        {
            bank.aksesAkun("111", "satu").ambilUang(1);
        }
        System.out.println("sisa :"+bank.aksesAkun("111", "satu").getUang());
        System.out.println(bank.aksesAkun("111", "satu").getHistory());
        
    }
    
}
