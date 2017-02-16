/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        String alamatFile1 = "C:\\Users\\Jayuk\\Documents\\TXT\\dapot1.txt";
        String alamatFile2 = "C:\\Users\\Jayuk\\Documents\\TXT\\dapot2.txt";
        System.out.println("mulai");
        try
        {
            //bacaDataReader(alamatFile1);
            //tulisDataWriter(alamatFile1, alamatFile2);
            //bacaData(alamatFile1);
            //tulisData(alamatFile1, alamatFile2);
            bacaFileMenggunakanBuffer(alamatFile1);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void bacaData(String alamat1) throws IOException
    {
        File inputFile = new File(alamat1);
        FileInputStream in = new FileInputStream(inputFile);
        int c;
        
        while((c = in.read()) != -1)
        {
            //System.out.println(c);
        }
        in.close();
    }
    
    public static void tulisData(String alamat1, String alamat2) throws IOException
    {
        File inputFile = new File(alamat1);
        File outputFile = new File(alamat2);
        
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        int c;
        while((c=in.read()) != -1)
        {
            out.write(c);
        }
        in.close();
        out.close();
    }
    
    public static void bacaDataReader(String alamat) throws IOException
    {
        File inputFile =  new File(alamat);
        FileReader in = new FileReader(inputFile);
        int c;
        while((c=in.read())!= -1)
        {
            //System.out.println(c);
        }
        in.close();
    }
    
    public static void tulisDataWriter(String alamat1, String alamat2) throws IOException
    {
        File inputFile = new File(alamat1);
        File outputFile = new File(alamat2);
        
        FileReader in =  new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);
        int c;
        while((c=in.read())!= -1)
        {
            out.write(c);
            char data = (char) c;
            System.out.print(data);
        }
        in.close();
        out.close();
    }
    public static void bacaFileMenggunakanBuffer(String alamat) throws IOException
    {
        FileReader inputFile = new FileReader(alamat);
        BufferedReader reader = new BufferedReader(inputFile);
        String line =" ";
        while((line = reader.readLine())!=null)
        {
            System.out.println(line);
        }
    }
        
}
