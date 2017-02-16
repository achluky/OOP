package akademik.dao;

import akademik.model.Kelas;
import akademik.model.Mahasiswa;
import akademik.model.Perkuliahan;
import akademik.util.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jayuk
 */
public class PerkuliahanDAO 
{
    private Connection connection=null;
    
    public PerkuliahanDAO() throws SQLException, IOException
    {
        connection = DBUtil.getConnection();
    }
    
    public void addPerkuliahan(Mahasiswa mahasiswa, Kelas kelas, double nilai)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERKULIAHAN (nimMahasiswa,idMatakuliah,nilai) VALUES (?,?,?)");
            preparedStatement.executeQuery();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void deletePerkuliahan(String nimMahasiswa, int idMatakuliah)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERKULIAHAN WHERE nimMahasiswa=? and idMatakuliah=?");
            preparedStatement.setString(1, nimMahasiswa);
            preparedStatement.setInt(2, idMatakuliah);
            preparedStatement.executeQuery();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void updatePerkuliahan(Perkuliahan perkuliahan)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERKULIAHAN SET nimMahasiswa=?, idMatakuliah=?, nilai=? WHERE nimMahasiswa="+perkuliahan.getNim()+"and idMatakuliah"+perkuliahan.getIdMatakuliah());
            preparedStatement.setString(1, perkuliahan.getNim());
            preparedStatement.setInt(2, perkuliahan.getIdMatakuliah());
            preparedStatement.setDouble(3, perkuliahan.getNilai());
            preparedStatement.executeQuery();
            connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
        
    public void getTopThree(String idMatakuliah)
    {
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from perkuliahan where  order by nilai desc limit 3");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String nimMahasiswa = rs.getString(1);
                int idMatakuliahBaru = rs.getInt(2);
                double nilai = rs.getDouble(3);
                PreparedStatement preparedStaementMahasiswa = connection.prepareCall("select * from mahasiswa where nim=? limit 1");
                ResultSet rsMahasiswa = preparedStatement.executeQuery();
                String nim = rs.getString(1);
                String nama = rs.getString(2);
                double indeksPrestasi = rs.getDouble(3);
                int idKelas = rs.getInt(4);
                PreparedStatement preparedStatementKelas = connection.prepareStatement("select * from kelas where idKelas=?");
                ResultSet rsKelas = preparedStatementKelas.executeQuery();
                int id = rsKelas.getInt(1);
                String namaKelas = rsKelas.getString(2);
                Kelas kelas = new Kelas(id,namaKelas);
                Mahasiswa mahasiswa = new Mahasiswa(nimMahasiswa, nama, indeksPrestasi, kelas);
                System.out.println(mahasiswa);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void getAllMahasiswa(String idMatakuliah)
    {
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT mahasiswa.nim, mahasiswa.nama,mahasiswa.indeksPrestasi, mahasiswa.idKelas, kelas.nama, perkuliahan.nilai from (mahasiswa join kelas on mahasiswa.nim = kelas.id) join perkuliahan on mahasiswa.nim = perkuliahan.nimMahasiswa;");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String nimMahasiswa = rs.getString(1);
                String nama = rs.getString(2);
                double indeksPrestasi = rs.getDouble(3);
                int idKelas = rs.getInt(4);
                String namaKelas = rs.getString(5);
                double nilai = rs.getDouble(6);
                System.out.println("NIM :"+nimMahasiswa+"Nama   :"+nama+"IP"+indeksPrestasi+"IdKelas    :"+idKelas+"Nama Kelas :"+namaKelas+"Nilai :"+nilai);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
