package akademik.dao;

import akademik.model.Kelas;
import akademik.model.Mahasiswa;
import akademik.model.Matakuliah;
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
public class MataKuliahDAO 
{
    private Connection connection;
    public MataKuliahDAO() throws SQLException, IOException
    {
        connection = DBUtil.getConnection();
    }
    
    public void addMataKuliah(Matakuliah matakuliah)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO kelas(id,nama,dosenWali) VALUES (?,?,?)");
            preparedStatement.setInt(1, matakuliah.getId());
            preparedStatement.setString(2, matakuliah.getNamaMataKuliah());
            preparedStatement.setInt(3, matakuliah.getSks());
            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteMataKuliah(int idMataKuliah)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MATAKULIAH WHERE id=?");
            preparedStatement.setInt (1, idMataKuliah);
            connection.commit();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateMataKuliah(Matakuliah matakuliah)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MATAKULIAH SET id=?, nama=?, sks=? WHERE id="+matakuliah.getId());
            preparedStatement.setInt(1, matakuliah.getId());
            preparedStatement.setString(2, matakuliah.getNamaMataKuliah());
            preparedStatement.setInt(3, matakuliah.getSks());
            preparedStatement.executeQuery();
            connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public List<Mahasiswa> getAllMahasiswaPadaSatuMatakuliah(int idMatakuliah)
    {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT a.nim, a.nama, a.indeksPrestasi, a.idKelas, a.nama FROM MAHASISWA as a, matakuliah as m WHERE a.idKelas = m.id");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            String nim=rs.getString(1);
            String nama=rs.getString(2);
            double ip = rs.getDouble(3);
            String namaKelas = rs.getString(5);
            PreparedStatement preparedStatementKelas = connection.prepareStatement("SELECT id FROM kelas WHERE nama="+namaKelas);
            ResultSet rsKelas = preparedStatementKelas.executeQuery();
            int idKelas = rsKelas.getInt(namaKelas);
            rs = preparedStatement.executeQuery();
            
            Mahasiswa m = new Mahasiswa(nim,nama,ip,new Kelas( idKelas,namaKelas));
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
    
    
    public List<Matakuliah> getAllMataKuliah()
    {
        List<Matakuliah> listMatakuliah = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MATAKULIAH");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int idKelas = rs.getInt(1);
                String nama = rs.getString(2);
                int sks = rs.getInt(3);
                listMatakuliah.add(new Matakuliah(idKelas,nama,sks));
            }
            connection.commit();
            rs.close();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return listMatakuliah;
    }
}
