/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nio;

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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("C:\\Users\\Jayuk\\Documents\\TXT\\NIO\\nio.txt");
        List<String> myString = new ArrayList<>();
        myString.add("baris 1");
        myString.add("baris 2");
        tulisData(path, myString);
        
        readData(path);
    }
    
    public static void tulisData(Path path, List<String> datas) throws IOException
    {
        Files.write(path, datas,StandardCharsets.UTF_8,StandardOpenOption.APPEND);
    }
    public static void readData(Path path) throws IOException
    {
        List<String> datas = Files.readAllLines(path);
        for(String data : datas)
        {
            System.out.println(data);
        }
    }
    
}
