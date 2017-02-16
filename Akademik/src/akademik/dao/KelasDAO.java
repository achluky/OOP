package akademik.dao;

import akademik.model.Kelas;
import akademik.model.Mahasiswa;
import akademik.util.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class KelasDAO 
{
    private Connection connection;
    public KelasDAO() throws SQLException, IOException
    {
        connection = DBUtil.getConnection();
    }
    
    public void addKelas(Kelas kelas)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO kelas(id,nama,dosenWali) VALUES (?,?,?)");
            preparedStatement.setInt(1, kelas.getId());
            preparedStatement.setString(2, kelas.getNama());
            preparedStatement.setString(3, kelas.getDosenWali());
            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteKelas(int idKelas)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM KELAS WHERE id=?");
            preparedStatement.setInt (1, idKelas);
            connection.commit();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateKelas(Kelas kelas)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE KELAS SET id=?, nama=?, dosenWali=? WHERE id=?");
            preparedStatement.setInt(1, kelas.getId());
            preparedStatement.setString(2, kelas.getNama());
            preparedStatement.executeQuery();
            connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public List<Mahasiswa> getAllMahasiswaPadaSatuKelas(int idKelas)
    {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT a.nim, a.nama, a.indeksPrestasi, a.idKelas, a.nama FROM MAHASISWA as a, kelas as b WHERE a.idKelas = b.id");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            String nim=rs.getString(1);
            String nama=rs.getString(2);
            double ip = rs.getDouble(3);
            String namaKelas = rs.getString(5);
            preparedStatement = connection.prepareStatement("SELECT id FROM kelas WHERE nama="+namaKelas);
            rs = preparedStatement.executeQuery();
            Mahasiswa m = new Mahasiswa(nim,nama,ip,new Kelas(idKelas,namaKelas));
            mahasiswas.add(m);
            }
            connection.commit();
            rs.close();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return mahasiswas;
    }
    
    public List<Kelas> getAllKelas()
    {
        List<Kelas> kelass = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KELAS");
            ResultSet rs = preparedStatement.executeQuery();
            int idKelas = rs.getInt(1);
            String nama = rs.getString(2);
            Kelas kelas =  new Kelas(idKelas,nama);
            kelass.add(kelas);
            connection.commit();
            rs.close();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return kelass;
    }
}
