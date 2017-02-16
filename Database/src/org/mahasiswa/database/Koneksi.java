package org.mahasiswa.database;
import java.sql.*;
/**
 *
 * @author Jayuk
 */
public class Koneksi {
    String dbUrl = "jdbc:mysql://localhost/akademik";
    String username = "root";
    String password = "jayamanik";
    
    public Connection getKoneksi() throws SQLException
    {
        Connection koneksi = DriverManager.getConnection(dbUrl,username,password);
        return koneksi;
    }
    
    public Statement getStatement() throws SQLException
    {
        Connection koneksi = getKoneksi();
        Statement statement = koneksi.createStatement();
        return statement;
    }
    
    public ResultSet getResultSet() throws SQLException
    {
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM MAHASISWA");
        return rs;
    }
    public void showData() throws SQLException
    {
        ResultSet rs = getResultSet();
        while(rs.next())
        {
            String nim = rs.getString("nim");
            String nama =  rs.getString("nama");
            System.out.println("Mahasiswa \tNIM:"+nim+"\tNama: "+nama);
        }
    }
    
}