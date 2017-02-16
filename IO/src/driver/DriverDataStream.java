/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Jayuk
 */
public class DriverDataStream 
{
    public static void main(String[] args) throws IOException
    {
        String alamatFile = "C:\\Users\\Jayuk\\Documents\\TXT\\faktur.txt";
        double[] harga = {20000,5000,15000,30000,10000};
        int[] jumlah = {12,8,13,29,50};
        String[] pakaian = {"kemeja", "kutang", "kaos", "celana", "dasi"};
        
        tulisData(alamatFile,jumlah,harga,pakaian);
        bacaData(alamatFile);
    }
    
    public static void bacaData(String alamatFile) throws IOException
    {
        double harga;
        double total=0;
        int jumlah;
        StringBuffer pakaian;
        DataInputStream in = new DataInputStream(new FileInputStream(alamatFile));
        String lineSepString = System.getProperty("line.separator");
        char lineSep = lineSepString.charAt(lineSepString.length()-1);
        try
        {
            while(true)
            {
                harga= in.readDouble();
                in.readChar();
                jumlah = in.readInt();
                in.readChar();
                char chr;
                pakaian = new StringBuffer(20);
                while ((chr = in.readChar()) != lineSep)
                pakaian.append(chr);
                System.out.println("Anda memesan " + jumlah + " " + pakaian + "seharga Rp. " + harga);
                total = total + jumlah* harga;
            }
        }
        catch (EOFException eofe)
        {
            
        }
        
        System.out.println("Total pembelian : Rp."+total);
        in.close();
    }
    
    public static void tulisData(String alamatFile, int[] jumlah, double[] harga, String[] pakaian) throws IOException
    {
        DataOutputStream out = new DataOutputStream (new FileOutputStream(alamatFile,true));
        for(int i=0;i<harga.length;i++)
        {
            out.writeDouble(harga[i]);
            out.writeChar('\t');
            out.writeInt(jumlah[i]);
            out.writeChar('\t');
            out.writeChars(pakaian[i]);
            out.writeChar('\n');
}
        out.close();
    }
    
}
