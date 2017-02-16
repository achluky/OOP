/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jayuk
 */
public class DriverGlob 
{
    public static void main(String[] args) throws IOException {
    Path path = Paths.get("C:\\Users\\Jayuk\\Documents\\TXT\\");
    DirectoryStream<Path> myDirectory = Files.newDirectoryStream(path,"dap*.*");
    for(Path entry : myDirectory)
    {
        System.out.println(entry.getFileName());
    }
    }
}
