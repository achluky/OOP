/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamus;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class Kamus 
{
    static String alamatFileKamus="C:\\Users\\Jayuk\\Documents\\NetBeansProjects\\Kamus\\src\\FileTXT\\databasekamus.txt";
    
    public static  String tambahKata(String english, String indonesia) throws IOException
    {
        BufferedReader reader= new BufferedReader(new FileReader(alamatFileKamus));
        int count=0;

        String line=reader.readLine();
        String s[];
        while(line!=null)
        {
            s=line.split("#");
            for(String a:s)
            {
                if(a.contains(english))
                    count++;
            }
            line=reader.readLine();
        }
        if(count == 0)
        {
            Path path = Paths.get(alamatFileKamus);
            List<String> myString =  new ArrayList<>();
            myString.add(english+"#"+indonesia);
            Files.write(path, myString, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            return "kata berhasil dimasukkan";
        }
        else
        {
            return "Kata sudah ada";
        }
    }
    
    public static String terjemahkan(String kata) throws IOException
    {
        String lineNumber = "";
        String filePath = alamatFileKamus;
        BufferedReader br;
        String line = "";

        br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine()) != null)
            {
                String[] words = line.split("#");
                for (int i=0;i<words.length;i++) 
                {
                  if (words[i].equals(kata)) 
                  {
                    return words[i+1];
                  }
                }
            
            }
        return null;
    }
}
